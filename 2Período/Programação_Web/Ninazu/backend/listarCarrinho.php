<?php

    include 'conexao.php';
    include 'h_loadPedido.php';


    function loadProdutosCarrinho($p_idPedido, $conexao) { // * Carregar Produtos apartir do ID do Pedido
        
        $query = "select id_produto, quantidade from ninazu.carrinho where id_pedido = $p_idPedido"; // ! Devolve todos produtos de um pedido específico 
        $registros = mysqli_query($conexao, $query);

        
        // ~ Busca os dados da tabela carrinho
        $i = 0;
        while($registro = mysqli_fetch_assoc($registros)){ 
            $id_produto = $registro["id_produto"];
            $quantidade = $registro["quantidade"];
            
            // ~ Busca os produtos apartir dos dados do carrinho
            $query = "SELECT * FROM ninazu.produtos where id = $id_produto";
            $otherRegistros = mysqli_query($conexao, $query);
            while($otherRegistro = mysqli_fetch_assoc($otherRegistros)){  
                $resposta["Carrinho"][$i]["id_produto"] = $otherRegistro["id"];
                $resposta["Carrinho"][$i]["nome"] = $otherRegistro["nome"];
                $resposta["Carrinho"][$i]["preco"] = $otherRegistro["preco"];
                $resposta["Carrinho"][$i]["img_link"] = $otherRegistro["img"];
                $resposta["Carrinho"][$i]["categoria"] = $otherRegistro["categoria"];
                $resposta["Carrinho"][$i]["quantidade"] = $quantidade;
            }
            $i++;
        }

        if(mysqli_num_rows($registros) == 0) { // ? Caso não exista produtos devolve um status negativo
            $resposta["status"] = "n";     
        } else { // ? Caso exista retorna um status positivo junto com os produtos
            $resposta["status"] = "s";
        }

        // * Devolve para o front-end os produtos do carrinho em JSON
        $objetoJSON = json_encode($resposta);
        echo $objetoJSON; 
        
    };

    
    $cpfUser = $_POST['cpfUser']; // & Define o CPF (token) do USER
    $idPedido = loadPedido($cpfUser, $conexao); // * carrega o pedido em aberto do usuario logado
    loadProdutosCarrinho($idPedido, $conexao);  // * Carregar Produtos apartir do ID do Pedido

    mysqli_close($conexao);

?>