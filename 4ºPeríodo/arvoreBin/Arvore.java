/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvore;

/**
 *
 * @author leal.machado
 */
public class Arvore {

    private No raiz;

    public Arvore() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.pegaValor()) {
            raiz.colocaEsquerda(inserirRecursivo(raiz.pegaEsquerda(), valor));
        } else if (valor > raiz.pegaValor()) {
            raiz.colocaDireita(inserirRecursivo(raiz.pegaDireita(), valor));
        }

        return raiz;
    }

    public void preordem() {
        preordemRecursivo(raiz);
    }

    private void preordemRecursivo(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.pegaValor() + " ");
            preordemRecursivo(raiz.pegaEsquerda());
            preordemRecursivo(raiz.pegaDireita());
        }
    }

    public void inordem() {
        System.out.print("\n");
        inordemRecursivo(raiz);
    }

    private void inordemRecursivo(No raiz) {
        if (raiz != null) {
            inordemRecursivo(raiz.pegaEsquerda());
            System.out.print(raiz.pegaValor() + " ");
            inordemRecursivo(raiz.pegaDireita());
        }
    }

    public void posordem() {
        posordemRecursivo(raiz);
    }

    private void posordemRecursivo(No raiz) {
        if (raiz != null) {
            posordemRecursivo(raiz.pegaEsquerda());
            posordemRecursivo(raiz.pegaDireita());
            System.out.print(raiz.pegaValor() + " ");
        }
    }

    public void removerMaior() {
        raiz = removerMaiorRecursivo(raiz);
    }

    private No removerMaiorRecursivo(No raiz) {
        if (raiz == null) {
            return raiz;
        } else if (raiz.pegaDireita() == null) {
            return raiz.pegaEsquerda();
        } else {
            raiz.colocaDireita(removerMaiorRecursivo(raiz.pegaDireita()));
            return raiz;
        }
    }

    public void removerMenor() {
        raiz = removerMenorRecursivo(raiz);
    }

    private No removerMenorRecursivo(No raiz) {
        if (raiz == null) {
            return raiz;
        } else if (raiz.pegaEsquerda() == null) {
            return raiz.pegaDireita();
        } else {
            raiz.colocaEsquerda(removerMenorRecursivo(raiz.pegaEsquerda()));
            return raiz;
        }
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor < raiz.pegaValor()) {
            raiz.colocaEsquerda(removerRecursivo(raiz.pegaEsquerda(), valor));
        } else if (valor > raiz.pegaValor()) {
            raiz.colocaDireita(removerRecursivo(raiz.pegaDireita(), valor));
        } else {
            if (raiz.pegaEsquerda() == null) {
                return raiz.pegaDireita();
            } else if (raiz.pegaDireita() == null) {
                return raiz.pegaEsquerda();
            }

            raiz.colocaValor(minValor(raiz.pegaDireita()));
            raiz.colocaDireita(removerRecursivo(raiz.pegaDireita(), raiz.pegaValor()));
        }

        return raiz;
    }

    private int minValor(No raiz) {
        int valorMin = raiz.pegaValor();
        while (raiz.pegaEsquerda() != null) {
            valorMin = raiz.pegaEsquerda().pegaValor();
            raiz = raiz.pegaEsquerda();
        }
        return valorMin;
    }

}
