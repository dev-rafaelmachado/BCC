<?php

    include 'conexao.php';
    include 'h_loadPedido.php';



    function finalizaPedido($p_idPedido, $conexao){ // & Fecha o pedido do usuario
        // ! Define o stats de abertura de pedido como fechado
        $query = "update ninazu.pedidos set stats = 1 where id = $p_idPedido;";
        mysqli_query($conexao, $query);
    }

    function finalizarCompraCartao($p_valorTT, $p_tipoPag, $p_cpfUser, $p_idPedido, $p_numCartao, $p_nomeTitular, $p_dataVencimento, $p_cvv, $conexao){ // & Finalizando compra como Cartão de Crédito
        // ! Inserindo os dados da compra como Cartão de Crédito
        $query = "insert into ninazu.compras (valor_total, tipo_pag, cpf_usuario, id_pedido, numCartao, nomeTitular, dataVencimento, cvv) values ($p_valorTT, '$p_tipoPag', '$p_cpfUser', $p_idPedido, '$p_numCartao', '$p_nomeTitular', ' $p_dataVencimento', '$p_cvv')";
        mysqli_query($conexao, $query);

    }
    function finalizarCompraPix($p_valorTT, $p_tipoPag, $p_cpfUser, $p_idPedido,$conexao){
        // ! Inserindo os dados da compra como Pix
        $query = "insert into ninazu.compras (valor_total, tipo_pag, cpf_usuario, id_pedido) values ($p_valorTT,'$p_tipoPag','$p_cpfUser',$p_idPedido)";
        mysqli_query($conexao, $query);
    }

    $cpfUser = $_POST['cpfUser']; // ^ Define o CPF do usuario
    $tipoPag = $_POST['tipoPag']; // ^ Define o Tipo de pagamento
    $valorTT = $_POST['valorTT']; // ^ Define o valor total

    $idPedido = loadPedido($cpfUser, $conexao); // * Define o ID do pedido do usuario
    finalizaPedido($idPedido, $conexao); // * Fecha o pedido do usuario

    if ($tipoPag == "Cartão de Crédito"){ // ? Caso o tipo de pagamento seja "Cartão de Crédito" => finalizarCompraCartao
        $numCartao = $_POST['numCartao']; // ^ Define o número do cartão
        $nomeTitular = $_POST['nomeTitular']; // ^ Define o nome do titular
        $dataVencimento = $_POST['dataVencimento']; // ^ Define a data de vencimento
        $cvv = $_POST['cvv']; // ^ Define o cvv
        finalizarCompraCartao($valorTT, $tipoPag, $cpfUser, $idPedido, $numCartao, $nomeTitular, $dataVencimento, $cvv, $conexao);
    } else { // ? Caso o tipo de pagamento seja "PIX" => finalizarCompraPix
        finalizarCompraPix($valorTT,$tipoPag,$cpfUser,$idPedido, $conexao);
    }

    $resposta["status"] = "200"; $resposta["mensagem"] = "Gravado com sucesso"; // * Escreve uma mensagem de status code de sucesso
    $objJSON = json_encode($resposta); echo $objJSON; //  * Envia os dados de status code para o front-end
?>