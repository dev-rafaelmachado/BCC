<?php 

    include 'conexao.php';
    include 'h_loadPedido.php';
    
    function adcProduto($p_idPedido,$p_idProduto,$conexao){ // & Adiciona ou aumenta a quantidade de um produto no carrinho
        
        // ! Query que verifica se existe já o p_produto com no carrinho do usuario
        $query = "select case when (select count(*) from ninazu.carrinho where id_pedido = $p_idPedido and id_produto = $p_idProduto) > 0 then 'Tem' else 'não tem' end as resposta";
        $resultados = mysqli_query($conexao, $query);
        
        while($registro = mysqli_fetch_assoc($resultados)){ // ~ Carrega os dados de 1 Resposta
            $respostaIF = $registro['resposta'];
        }

        if($respostaIF == "Tem"){ // ? Verifica se já existe o p_produto no carrinho do usuario, caso exista define uma query para acrescentar na sua quantidade
            $query = "UPDATE ninazu.carrinho SET quantidade = quantidade + 1 where id_pedido = $p_idPedido and id_produto = $p_idProduto";
        } else { // ? Caso não exista define uma query que insere um novo produto no carrinho
            $query = "insert into ninazu.carrinho (id_produto, id_pedido, quantidade) values ($p_idProduto,$p_idPedido,1)";
        };
        mysqli_query($conexao, $query); // Executa a query
        
    };

    $cpfUser = $_POST['cpfUser']; // ^ Define o CPF (token) do USER
    $idProduto = $_POST['idProduto']; // ^ Define o ID do Produto

    $idPedido = loadPedido($cpfUser, $conexao); // * carrega o pedido em aberto do usuario logado
    adcProduto($idPedido, $idProduto, $conexao);  // * Adiciona ou aumenta a quantidade de um produto no carrinho

?>