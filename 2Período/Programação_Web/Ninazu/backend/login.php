<?php

    include 'conexao.php';
    $email = $_POST["email"];
    $senha = $_POST["senha"];

    $resultado =  mysqli_query($conexao, "select cpf from ninazu.usuario where email = '$email' and senha = '$senha'");
    $registro = mysqli_fetch_assoc($resultado);
    mysqli_close($conexao);

    $objetoJSON = json_encode($registro);
    echo $objetoJSON;
?>