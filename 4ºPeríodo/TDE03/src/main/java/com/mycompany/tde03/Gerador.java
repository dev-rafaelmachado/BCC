/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tde03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author rafae
 */
public class Gerador {
    public int[] seedVetor(int tamanho, String nomeArquivo) {
        int[] vetor = new int[tamanho];

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            int indice = 0;
            String linha;

            while ((linha = leitor.readLine()) != null && indice < tamanho) {
                int valor = Integer.parseInt(linha);
                vetor[indice] = valor;
                indice++;
            }

            leitor.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
        }

        return vetor;
    }

    public int[] randomVetor(int tamanho) {
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }

        return vetor;
    }
}
