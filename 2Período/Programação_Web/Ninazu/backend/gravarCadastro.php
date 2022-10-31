<?php
include 'conexao.php';

$nome = $_POST["nome"];
$email = $_POST["email"];
$cpf = $_POST["cpf"];
$senha = $_POST["senha"];


$resultado =  mysqli_query($conexao, "INSERT INTO ninazu.usuario values ('$cpf','$nome','$email','$senha')");
mysqli_close($conexao);

$resposta["status"] = "200";
$resposta["mensagem"] = "Gravado com sucesso";

$objJSON = json_encode($resposta);
echo $objJSON;
?>