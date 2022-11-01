<?php   
    include 'conexao.php';
    include 'h_loadPedido.php';



    function finalizaPedido($p_idPedido, $conexao){
        $query = "update ninazu.pedidos set stats = 1 where id = $p_idPedido;";
        mysqli_query($conexao, $query);
    }

    function finalizarCompraCartao($p_valorTT, $p_tipoPag, $p_cpfUser, $p_idPedido, $p_numCartao, $p_nomeTitular, $p_dataVencimento, $p_cvv, $conexao){
        $query = "insert into ninazu.compras (valor_total, tipo_pag, cpf_usuario, id_pedido, numCartao, nomeTitular, dataVencimento, cvv) values ($p_valorTT, '$p_tipoPag', '$p_cpfUser', $p_idPedido, '$p_numCartao', '$p_nomeTitular', ' $p_dataVencimento', '$p_cvv')";
        mysqli_query($conexao, $query);

    }
    function finalizarCompraPix($p_valorTT, $p_tipoPag, $p_cpfUser, $p_idPedido,$conexao){
        $query = "insert into ninazu.compras (valor_total, tipo_pag, cpf_usuario, id_pedido) values ($p_valorTT,'$p_tipoPag','$p_cpfUser',$p_idPedido)";
        mysqli_query($conexao, $query);
    }

    $cpfUser = $_POST['cpfUser'];
    $tipoPag = $_POST['tipoPag'];
    $valorTT = $_POST['valorTT'];

    $idPedido = loadPedido($cpfUser, $conexao);
    finalizaPedido($idPedido, $conexao);

    if ($tipoPag == "Cartão de Crédito"){

        $numCartao = $_POST['numCartao'];
        $nomeTitular = $_POST['nomeTitular'];
        $dataVencimento = $_POST['dataVencimento'];
        $cvv = $_POST['cvv'];

        finalizarCompraCartao($valorTT, $tipoPag, $cpfUser, $idPedido, $numCartao, $nomeTitular, $dataVencimento, $cvv, $conexao);
    } else {
        finalizarCompraPix($valorTT,$tipoPag,$cpfUser,$idPedido, $conexao);
    }

    $resposta["status"] = "200"; $resposta["mensagem"] = "Gravado com sucesso"; // * Escreve uma mensagem de status code de sucesso
    $objJSON = json_encode($resposta); echo $objJSON; //  * Envia os dados de status code para o front-end
?>