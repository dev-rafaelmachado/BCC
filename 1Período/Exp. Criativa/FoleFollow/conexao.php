<?php 

    $email = $_POST["email"];
    $senha = $_POST["senha"];

    $conexao = mysqli_connect("localhost","root","","folefollow");
    mysqli_query($conexao, "INSERT INTO users (email,senha) VALUES ('$email','$senha')");
?>