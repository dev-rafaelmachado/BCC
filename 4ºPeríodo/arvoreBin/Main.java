/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.arvore;

import java.util.Scanner;

/**
 *
 * @author leal.machado
 */
public class Main {

    public static void main(String[] args){
        Arvore minhaArvore = new Arvore();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println(
                    "\n\n1 - Inserir um valor\n2 - Percorrer préordem\n3 - Percorrer inordem\n4 - Percorrer pósordem\n5 - Remover maior\n6 - Remover menor\n7 - Remover um valor\n0 - Sair\n:");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1 -> {
                    System.out.println("Escolha um valor para inserir:");
                    int valor = scanner.nextInt();
                    minhaArvore.inserir(valor);
                    break;
                }
                case 2 -> {
                    minhaArvore.preordem();
                    break;
                }
                case 3 -> {
                    minhaArvore.inordem();
                    break;
                }
                case 4 -> {
                    minhaArvore.posordem();
                    break;
                }
                case 5 -> {
                    minhaArvore.removerMaior();
                    break;
                }
                case 6 -> {
                    minhaArvore.removerMenor();
                }
                case 7 -> {
                    System.out.println("Escolha um valor para remover:");
                    int valor = scanner.nextInt();
                    minhaArvore.remover(valor);
                }

            }
        } while (escolha != 0);
        scanner.close();

    }
}
