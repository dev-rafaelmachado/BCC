<?php 

    include 'conexao.php';

    $type = $_POST['type'];

    if ($type == "Todas") {
        $query = "SELECT * FROM ninazu.produtos";
    } else {
        $query = "SELECT * FROM ninazu.produtos where categoria = '$type'";
    }

    $registros = mysqli_query($conexao, $query);
    mysqli_close($conexao);
    $i = 0;

    while ($registro = mysqli_fetch_assoc($registros)){
        $resposta[$i]["id_produto"] = $registro["id"];
        $resposta[$i]["nome"] = $registro["nome"];
        $resposta[$i]["preco"] = $registro["preco"];
        $resposta[$i]["img_link"] = $registro["img"];
        $resposta[$i]["categoria"] = $registro["categoria"];

        $i++;
    }

    $objetoJSON = json_encode($resposta);
    echo $objetoJSON;

?>