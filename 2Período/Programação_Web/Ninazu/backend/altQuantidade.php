<?php   
    include 'conexao.php';
    include 'h_loadPedido.php';

    function altQuantidade($p_idProduto, $p_idPedido, $p_operação, $conexao){
        // ! Query que altera a quantidade do p_produto 
        $query = ("update ninazu.carrinho SET quantidade = quantidade + ($p_operação) where (id_produto = $p_idProduto) and (id_pedido = $p_idPedido)");
        mysqli_query($conexao, $query);

        // ! Query que verifica se a quantidade é igual a 0
        $query = "select case when (select quantidade from ninazu.carrinho where id_produto = $p_idProduto and id_pedido = $p_idPedido) = 0 then 'del' else 'no del' end as resposta";
        $resultados = mysqli_query($conexao, $query);
        
        while($registro = mysqli_fetch_assoc($resultados)){ // ~ Carrega os dados de 1 Resposta
            $respostaIF = $registro['resposta'];
        }

        if($respostaIF == "del"){ // ? Caso a quantidade é igual a 0, remova o produto do carrinho
            $query = "DELETE FROM ninazu.carrinho WHERE (id_produto = $p_idProduto) and (id_pedido = $p_idPedido)"; // ! Remove um produto apartir do ID do pedido e do produto
             mysqli_query($conexao, $query);
        }
    }

    $cpfUser = $_POST['cpfUser']; // ^ Define o CPF (token) do USER
    $idProduto = $_POST['idProduto']; // ^ Define o ID do Produto
    $operação = $_POST['operacao']; // ^ Define a operação na quantidade

    $idPedido = loadPedido($cpfUser, $conexao);
    altQuantidade($idProduto, $idPedido, $operação, $conexao);

?>