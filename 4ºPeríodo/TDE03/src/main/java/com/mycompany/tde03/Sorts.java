package com.mycompany.tde03;

public class Sorts {
    private int iteracoes = 0;
    private int trocas = 0;

    public int getIteracoes() {
        return iteracoes;
    }

    public int getTrocas() {
        return trocas;
    }

    public int[] bubbleSort(int[] vetor) {
        this.iteracoes = 0;
        this.trocas = 0;

        int tamanho = vetor.length;
        int[] vetorOrdenado = vetor.clone();

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (vetorOrdenado[j] > vetorOrdenado[j + 1]) {
                    int auxiliar = vetorOrdenado[j];
                    vetorOrdenado[j] = vetorOrdenado[j + 1];
                    vetorOrdenado[j + 1] = auxiliar;
                    this.trocas++;
                }
                this.iteracoes++;
            }
            this.iteracoes++;
        }

        return vetorOrdenado;
    }

    public int[] selectionSort(int[] vetor) {
        this.iteracoes = 0;
        this.trocas = 0;
        int[] vetorOrdenado = vetor.clone();
        int tamanho = vetorOrdenado.length;

        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (vetorOrdenado[j] < vetorOrdenado[indiceMenor]) {
                    indiceMenor = j;
                }
                this.iteracoes++;
            }

            if (indiceMenor != i) {
                int auxiliar = vetorOrdenado[i];
                vetorOrdenado[i] = vetorOrdenado[indiceMenor];
                vetorOrdenado[indiceMenor] = auxiliar;
                this.trocas++;
            }
        }

        return vetorOrdenado;
    }

    private void merge(int[] vetor, int inicio, int meio, int fim) {
        int tam1 = meio - inicio + 1;
        int tam2 = fim - meio;

        int esquerda[] = new int[tam1];
        int direita[] = new int[tam2];

        for (int i = 0; i < tam1; i++) {
            esquerda[i] = vetor[inicio + i];
        }
        for (int j = 0; j < tam2; j++) {
            direita[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0;
        int iterador = inicio;

        while (i < tam1 && j < tam2) {
            if (esquerda[i] <= direita[j]) {
                vetor[iterador++] = esquerda[i++];
            } else {
                vetor[iterador++] = direita[j++];
            }
            this.iteracoes++;
        }

        while (i < tam1) {
            vetor[iterador++] = esquerda[i++];
            this.iteracoes++;
        }
        while (j < tam2) {
            vetor[iterador++] = direita[j++];
            this.iteracoes++;
        }
    }

    private void sort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            sort(vetor, inicio, meio);
            sort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
            this.iteracoes++;
        }
    }

    public int[] mergeSort(int[] vetor) {
        this.iteracoes = 0;
        this.trocas = 0;

        int[] vetorOrdenado = vetor.clone();
        sort(vetorOrdenado, 0, vetorOrdenado.length - 1);
        return vetorOrdenado;
    }

    public int[] shellSort(int[] vetor) {
        this.iteracoes = 0;
        this.trocas = 0;

        int vetorOrdenado[] = vetor.clone();

        int j, auxiliar;
        int tamanho = vetorOrdenado.length;
        double varreduras = Math.log(tamanho + 1) / Math.log(3);
        varreduras = (int) Math.ceil(varreduras);
        int intervalo = (int) Math.pow(3, varreduras) - 1;

        while (intervalo > 0) {
            for (int i = 0; i < tamanho - intervalo; i++) {
                if (vetorOrdenado[i] > vetorOrdenado[i + intervalo]) {
                    auxiliar = vetorOrdenado[i];
                    vetorOrdenado[i] = vetorOrdenado[i + intervalo];
                    vetorOrdenado[i + intervalo] = auxiliar;
                    this.trocas++;
                    j = i - intervalo;
                    while (j >= 0) {
                        if (vetorOrdenado[j] > vetorOrdenado[j + intervalo]) {
                            auxiliar = vetorOrdenado[j];
                            vetorOrdenado[j] = vetorOrdenado[j + intervalo];
                            vetorOrdenado[j + intervalo] = auxiliar;
                            this.trocas++;
                        } else {
                            break;
                        }
                        this.iteracoes++;
                        j = j - intervalo;

                    }
                }
                this.iteracoes++;
            }
            intervalo = (intervalo - 1) / 3;
        }
        return vetorOrdenado;
    }
}
