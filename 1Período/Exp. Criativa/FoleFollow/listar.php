<?php 
    $conexao = mysqli_connect("localhost","root","","folefollow");
    $resultado = mysqli_query($conexao,"SELECT * FROM `folefollow`.`users` ");

    $contador = 0;

    while( ($registro = mysqli_fetch_assoc($resultado)) == true ){

        $retorno[$contador]["id"] = $registro["id"];
        $retorno[$contador]["email"] = $registro["email"];
        $retorno[$contador]["senha"] = $registro["senha"];

        $contador++;

    }
    $retorno_json = json_encode($retorno);
    
    echo $retorno_json;
    
?>