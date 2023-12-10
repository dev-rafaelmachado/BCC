/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author rafae
 */
public class Arvore_Normal {

    private No_Normal no;

    public void inserir(int valor) {
        No_Normal novoNo = new No_Normal(valor);
        inserirRec(no, novoNo);
    }

    private void inserirRec(No_Normal noAtual, No_Normal novoNo) {
        if (no == null) {
            no = novoNo;
        } else if (novoNo.getValor() < noAtual.getValor()) {
            if (!(noAtual.getEsquerda() == null)) {
                inserirRec(noAtual.getEsquerda(), novoNo);
            }
            noAtual.setEsquerda(novoNo);
        } else if (novoNo.getValor() > noAtual.getValor()) {
            if (!(noAtual.getDireita() == null)) {
                inserirRec(noAtual.getDireita(), novoNo);
            }
            noAtual.setDireita(novoNo);
        }
    }

    private int encontrarMenorValor(No_Normal node) {
        int menorValor = node.getValor();
        while (node.getEsquerda() != null) {
            menorValor = node.getEsquerda().getValor();
            node = node.getEsquerda();
        }
        return menorValor;
    }

    public void remover(int valor) {
        no = removerRec(no, valor);
    }

    private No_Normal removerRec(No_Normal noAtual, int valor) {
        if (noAtual == null) {
            return noAtual;
        }

        if (valor < noAtual.getValor()) {
            noAtual.setEsquerda(removerRec(noAtual.getEsquerda(), valor));
        } else if (valor > noAtual.getValor()) {
            noAtual.setDireita(removerRec(noAtual.getDireita(), valor));
        } else {
            if (noAtual.getEsquerda() == null) {
                return noAtual.getDireita();
            } else if (noAtual.getDireita() == null) {
                return noAtual.getEsquerda();
            }
            noAtual.setValor(encontrarMenorValor(noAtual.getDireita()));
            noAtual.setDireita(removerRec(noAtual.getDireita(), noAtual.getValor()));
        }

        return noAtual;
    }

    public No_Normal buscar(int valor) {
        return buscaRec(no, valor);
    }

    private No_Normal buscaRec(No_Normal currentNode, int valor) {
        if (currentNode == null) {
            System.out.println("Valor não encontrado");
            return currentNode;
        } else if (currentNode.getValor() == valor) {
            System.out.println("Valor " + valor + " encontrado na arvore");
        }
        if (valor < currentNode.getValor()) {
            return buscaRec(currentNode.getEsquerda(), valor);
        } else {
            return buscaRec(currentNode.getDireita(), valor);
        }
    }
}
