/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author rafae
 */
public class No_AVL {

    private int valor;
    private int altura;
    private No_AVL esquerda;
    private No_AVL direita;

    public No_AVL(int data) {
        this.valor = data;
        this.esquerda = null;
        this.direita = null;
    }

    public int getAltura() {
        return altura;
    }

    public int getValor() {
        return valor;
    }

    public No_AVL getEsquerda() {
        return esquerda;
    }

    public No_AVL getDireita() {
        return direita;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setEsquerda(No_AVL esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(No_AVL direita) {
        this.direita = direita;
    }

    public void setValor(int data) {
        this.valor = data;
    }
}
