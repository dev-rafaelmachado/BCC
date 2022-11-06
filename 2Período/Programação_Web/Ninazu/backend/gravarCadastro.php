<?php

    include 'conexao.php';

    $nome = $_POST["nome"]; // ^ Define o Nome
    $email = $_POST["email"]; // ^ Define o email
    $cpf = $_POST["cpf"]; // ^ Define o cpf
    $senha = $_POST["senha"]; // ^ Define o senha

    mysqli_query($conexao, "INSERT INTO ninazu.usuario values ('$cpf','$nome','$email','$senha')"); // ! Insere um novo usuario com os dados do formulario
    mysqli_close($conexao); // Fecha a conexão

    $resposta["status"] = "200"; $resposta["mensagem"] = "Gravado com sucesso"; // * Escreve uma mensagem de status code de sucesso
    $objJSON = json_encode($resposta); echo $objJSON; //  * Envia os dados de status code para o front-end

?>