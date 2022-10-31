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

    function loadProdutosCarrinho($p_idPedido, $conexao) { // * Carregar Produtos apartir do ID do Pedido

        $query = "select id_produto, quantidade from ninazu.carrinho where id_pedido = $p_idPedido";
        $registros = mysqli_query($conexao, $query);

        $i = 0;
        while($registro = mysqli_fetch_assoc($registros)){
            $id_produto = $registro["id_produto"];
            $quantidade = $registro["quantidade"];
            
            $query = "SELECT * FROM ninazu.produtos where id = $id_produto";
            $otherRegistros = mysqli_query($conexao, $query);
            
            while($otherRegistro = mysqli_fetch_assoc($otherRegistros)){
                $resposta["Carrinho"][$i]["id_produto"] = $otherRegistro["id"];
                $resposta["Carrinho"][$i]["nome"] = $otherRegistro["nome"];
                $resposta["Carrinho"][$i]["preco"] = $otherRegistro["preco"];
                $resposta["Carrinho"][$i]["img_link"] = $otherRegistro["img_link"];
                $resposta["Carrinho"][$i]["categoria"] = $otherRegistro["categoria"];
                $resposta["Carrinho"][$i]["quantidade"] = $quantidade;
            }
            $i++;
        }

        if(mysqli_num_rows($registros) == 0) {
            $resposta["status"] = "n";
            $objetoJSON = json_encode($resposta);
        }else{
            $resposta["status"] = "s";
            $objetoJSON = json_encode($resposta);
        }
        echo $objetoJSON;
        
    };

    
    $cpfUser = $_POST['cpfUser']; // & Define o CPF (token) do USER
    
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
        loadProdutosCarrinho($idPedido, $conexao);


    } else { // ? Caso já exista um pedido aberto apenas guarde o ID
        $idPedido = $resposta[0]['Resposta']; 
        loadProdutosCarrinho($idPedido, $conexao);
    };
    
    mysqli_close($conexao);

?>