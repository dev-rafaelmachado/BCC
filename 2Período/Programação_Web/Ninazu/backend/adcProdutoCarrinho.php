<?php 

    include 'conexao.php';
    
    function loadData($p_registros) { // * Organizar os dados vindo do banco
        $i = 0;
        while ($registro = mysqli_fetch_assoc($p_registros)){
            $resposta[$i]["Resposta"] = $registro["Resposta"];
            $i++;
        };
        return $resposta;
    };
    function adcProduto($p_idPedido,$p_idProduto,$conexao){
        $query = "insert into ninazu.carrinho (id_produto, id_pedido, quantidade) values ($p_idProduto,$p_idPedido,1)";
        mysqli_query($conexao, $query);
    };

    $cpfUser = $_POST['cpfUser']; // & Define o CPF (token) do USER
    $idProduto = $_POST['idProduto'];

    $query = "select CASE when (Select count(*) from ninazu.pedidos where cpf_usuario = '$cpfUser' and Stats = 0) > 0 then (Select id from ninazu.pedidos where cpf_usuario = '$cpfUser' and Stats = 0) ELSE 'Não tem' end as 'Resposta'"; // ! Query que verifica se existe um pedido aberto com o cpf do usuario
    $registros = mysqli_query($conexao, $query);

    $resposta = loadData($registros); // Carrega os dados da consulta

    if($resposta[0]['Resposta'] == "Não tem"){ // ? Verifica se existe um pedido aberto, caso não, abre um pedido no banco e guarda este ultimo ID de pedido
        $query = "insert into ninazu.pedidos (cpf_usuario, stats) values ('$cpfUser',0)";
        mysqli_query($conexao, $query);
        
        $query = "Select id as 'Resposta' from ninazu.pedidos where cpf_usuario = '$cpfUser' and Stats = 0";
        $registros = mysqli_query($conexao, $query);
        
        $resposta = loadData($registros);
        
        $idPedido = $resposta[0]['Resposta']; 
        adcProduto($idPedido, $idProduto, $conexao);


    } else { // ? Caso já exista um pedido aberto apenas guarde o ID
        $idPedido = $resposta[0]['Resposta']; 
        adcProduto($idPedido, $idProduto, $conexao);
    };

?>