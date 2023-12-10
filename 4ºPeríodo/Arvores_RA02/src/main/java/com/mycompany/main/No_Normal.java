/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author rafae
 */

public class No_Normal {
	private int valor;
	private No_Normal esquerda;
	private No_Normal direita;

	public No_Normal(int data) {
		this.valor = data;
		this.esquerda = null;
		this.direita = null;
	}

	public int getValor() {
		return valor;
	}

	public No_Normal getEsquerda() {
		return esquerda;
	}

	public No_Normal getDireita() {
		return direita;
	}

	public void setEsquerda(No_Normal esquerda) {
		this.esquerda = esquerda;
	}

	public void setDireita(No_Normal direita) {
		this.direita = direita;
	}

	public void setValor(int data) {
		this.valor = data;
	}
}