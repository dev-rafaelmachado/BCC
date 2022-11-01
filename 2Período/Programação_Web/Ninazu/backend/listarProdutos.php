<?php 

    include 'conexao.php';

    $type = $_POST['type']; // ^ Define a categoria a ser pesquisada

    if ($type == "Todas") { // ? Se a categoria for 'todas' selecione todos os produtos
        $query = "SELECT * FROM ninazu.produtos";
    } else { // ? Senão selecione apenas os produtos daquela categoria
        $query = "SELECT * FROM ninazu.produtos where categoria = '$type'";
    }

    // Executa a query
    $registros = mysqli_query($conexao, $query);
    mysqli_close($conexao);
    
    $i = 0;
    while ($registro = mysqli_fetch_assoc($registros)){ // ~ Organiza os dados da tebela produtos
        $resposta[$i]["id_produto"] = $registro["id"]; 
        $resposta[$i]["nome"] = $registro["nome"];
        $resposta[$i]["preco"] = $registro["preco"];
        $resposta[$i]["img_link"] = $registro["img"];
        $resposta[$i]["categoria"] = $registro["categoria"];
        $i++;
    }

    // * Devolve para o front-end os produtos
    $objetoJSON = json_encode($resposta);
    echo $objetoJSON;

?>