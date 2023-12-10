/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvore;

/**
 *
 * @author leal.machado
 */
public class No {
    private int valor;
    private No esquerda;
    private No direita;

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
    
    public void colocaEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public void colocaDireita(No direita) {
        this.direita = direita;
    }
    
    public void colocaValor(int valor){
        this.valor = valor;
    }

    public int pegaValor() {
        return valor;
    }

    public No pegaEsquerda() {
        return esquerda;
    }

    public No pegaDireita() {
        return direita;
    }
}

