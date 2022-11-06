<?php

    function loadData($p_registros) { // & Organizar os dados vindo do banco
        $i = 0;
        while ($registro = mysqli_fetch_assoc($p_registros)){ // ~ Carrega os dados de 1 Resposta
            $resposta[$i]["Resposta"] = $registro["Resposta"];
            $i++;
        };
        return $resposta;
    };

    function loadPedido($p_cpfUser, $conexao){ // & Carrega o pedido em aberto do usuario fornecido
        
        $query = "select CASE when (Select count(*) from ninazu.pedidos where cpf_usuario = '$p_cpfUser' and Stats = 0) > 0 then (Select id from ninazu.pedidos where cpf_usuario = '$p_cpfUser' and Stats = 0) ELSE 'Não tem' end as 'Resposta'"; // ! Query que verifica se existe um pedido aberto com o cpf do usuario
        $registros = mysqli_query($conexao, $query);
        $resposta = loadData($registros); // Carrega os dados da consulta

        if($resposta[0]['Resposta'] == "Não tem"){ // ? Verifica se existe um pedido aberto, caso não, abre um pedido no banco e guarda este ultimo ID de pedido
            $query = "insert into ninazu.pedidos (cpf_usuario, stats) values ('$p_cpfUser',0)";
            mysqli_query($conexao, $query);
                
            $query = "Select id as 'Resposta' from ninazu.pedidos where cpf_usuario = '$p_cpfUser' and Stats = 0";
            $registros = mysqli_query($conexao, $query);
                
            $resposta = loadData($registros);
                
            return $resposta[0]['Resposta']; 


        } else { // ? Caso já exista um pedido aberto apenas guarde o ID
            return $resposta[0]['Resposta']; 
        };
    }
?>

