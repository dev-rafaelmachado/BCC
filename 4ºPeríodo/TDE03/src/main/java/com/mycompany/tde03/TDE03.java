/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tde03;

/**
 *
 * @author rafae
 */
public class TDE03 {

    public static void main(String[] args) {
        Sorts sorts = new Sorts();
        Gerador gerador = new Gerador();

        int[] valores = { 50, 500, 1000, 5000, 10000 };
        boolean hasPrint = false;

        System.out.println("# Bubble Sort");
        for (int valor : valores) {
            int[] vetor = gerador.seedVetor(valor, "seeds/" + valor + ".txt");

            long tempoInicial = System.currentTimeMillis();
            int[] vetorOrdenado = sorts.bubbleSort(vetor);
            long tempoFinal = System.currentTimeMillis();

            if (hasPrint)
                printVetor(vetorOrdenado);

            System.out.println("### " + valor);
            System.out.println("Iterações: " + sorts.getIteracoes());
            System.out.println("Trocas: " + sorts.getTrocas());
            System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms\n");
        }
        System.out.println("\n");

        System.out.println("# Selection Sort");
        for (int valor : valores) {
            int[] vetor = gerador.seedVetor(valor, "seeds/" + valor + ".txt");

            long tempoInicial = System.currentTimeMillis();
            int[] vetorOrdenado = sorts.selectionSort(vetor);
            long tempoFinal = System.currentTimeMillis();

            if (hasPrint)
                printVetor(vetorOrdenado);

            System.out.println("### " + valor);
            System.out.println("Iterações: " + sorts.getIteracoes());
            System.out.println("Trocas: " + sorts.getTrocas());
            System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms\n");
        }
        System.out.println("\n");

        System.out.println("# Merge Sort");
        for (int valor : valores) {
            int[] vetor = gerador.seedVetor(valor, "seeds/" + valor + ".txt");

            long tempoInicial = System.currentTimeMillis();
            int[] vetorOrdenado = sorts.mergeSort(vetor);
            long tempoFinal = System.currentTimeMillis();

            if (hasPrint)
                printVetor(vetorOrdenado);

            System.out.println("### " + valor);
            System.out.println("Iterações: " + sorts.getIteracoes());
            System.out.println("Trocas: " + sorts.getTrocas());
            System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms\n");
        }
        System.out.println("\n");

        System.out.println("# Shell Sort");
        for (int valor : valores) {
            int[] vetor = gerador.seedVetor(valor, "seeds/" + valor + ".txt");

            long tempoInicial = System.currentTimeMillis();
            int[] vetorOrdenado = sorts.shellSort(vetor);
            long tempoFinal = System.currentTimeMillis();

            if (hasPrint)
                printVetor(vetorOrdenado);

            System.out.println("### " + valor);
            System.out.println("Iterações: " + sorts.getIteracoes());
            System.out.println("Trocas: " + sorts.getTrocas());
            System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms\n");
        }
        System.out.println("\n");
    }

    public static void printVetor(int[] vetor) {
        System.out.println();
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);
            if (i < vetor.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
