<?php

    include 'conexao.php';
    $email = $_POST["email"]; // ^ Define o email
    $senha = $_POST["senha"]; // ^ Define o senha

    $resultado =  mysqli_query($conexao, "select cpf from ninazu.usuario where email = '$email' and senha = '$senha'"); // ! Seleciona o usuario com email e senha do formulario
    mysqli_close($conexao); // Fecha a conexão

    if(mysqli_num_rows($resultado) == 0) { // ? Caso não exista usuario devolve um status negativo
        $resposta["status"] = "n";     
    } else { // ? Caso exista retorna um status positivo 
        $registro = mysqli_fetch_assoc($resultado);
        $resposta = $registro;
        $resposta["status"] = "s";
    }

    $objetoJSON = json_encode($resposta); echo $objetoJSON; //  * Envia a resposta para o front-end
