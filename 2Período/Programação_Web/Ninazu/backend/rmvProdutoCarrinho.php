<?php 

    include 'conexao.php';
    include 'h_loadPedido.php';
    
    function rmvProduto($p_idPedido,$p_idProduto,$conexao){ // & Remove um produto do carrinho
        $query = "DELETE FROM ninazu.carrinho WHERE (id_produto = $p_idProduto) and (id_pedido = $p_idPedido)"; // ! Remove um produto apartir do ID do pedido e do produto
        mysqli_query($conexao, $query);
    };

    $cpfUser = $_POST['cpfUser']; // ^ Define o CPF (token) do USER
    $idProduto = $_POST['idProduto']; // ^ Define o ID do Produto

    $idPedido = loadPedido($cpfUser, $conexao); // * carrega o pedido em aberto do usuario logado
    rmvProduto($idPedido, $idProduto, $conexao);  // * Remove um produto do carrinho

    mysqli_close($conexao);
?>

