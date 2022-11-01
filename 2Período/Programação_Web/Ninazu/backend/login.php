<?php

    include 'conexao.php';
    $email = $_POST["email"]; // ^ Define o email
    $senha = $_POST["senha"]; // ^ Define o senha

    $resultado =  mysqli_query($conexao, "select cpf from ninazu.usuario where email = '$email' and senha = '$senha'"); // ! Seleciona o usuario com email e senha do formulario
    $registro = mysqli_fetch_assoc($resultado); // ~ Organiza os dados de apenas 1 registro
    
    mysqli_close($conexao); // Fecha a conexão

    $objetoJSON = json_encode($registro); echo $objetoJSON; //  * Envia a resposta para o front-end
?>