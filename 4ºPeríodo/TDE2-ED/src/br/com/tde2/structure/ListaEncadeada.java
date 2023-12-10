package br.com.tde2.structure;

import java.util.Random;

class ListaEncadeada {
	private Node head;

	protected void insert(int data) {
		Node novoNode = new Node(data);
		novoNode.setNext(head);
		head = novoNode;
	}

	protected int remove() {
		if (head == null) {
			return -1;
		}
		int removedData = head.getData();
		head = head.getNext();
		return removedData;
	}

	protected boolean vazia() {
		return head == null;
	}

	protected void printListaEncadeada() {
		printListaRecursivamente(head);
		System.out.println();
	}

	private void printListaRecursivamente(Node node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			printListaRecursivamente(node.getNext());
		}
		return;
	}

	protected int tamanho() {
		return tamanhoRecursivo(head);
	}

	private int tamanhoRecursivo(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + tamanhoRecursivo(node.getNext());
	}

	protected boolean crescente() {
		return crescenteRecursivo(head);
	}

	private boolean crescenteRecursivo(Node node) {
		if (node == null || node.getNext() == null) {
			return true;
		}
		if (node.getData() > node.getNext().getData()) {
			return false;
		}
		return crescenteRecursivo(node.getNext());
	}

	protected boolean decrescente() {
		return decrescenteRecursivo(head);
	}

	private boolean decrescenteRecursivo(Node node) {
		if (node == null || node.getNext() == null) {
			return true;
		}
		if (node.getData() < node.getNext().getData()) {
			return false;
		}
		return decrescenteRecursivo(node.getNext());
	}
	
	protected boolean contem(int numero) {
	    return contemRecursivo(head, numero);
	}

	private boolean contemRecursivo(Node node, int numero) {
	    if (node == null) {
	        return false;
	    }
	    if (node.getData() == numero) {
	        return true;
	    }
	    return contemRecursivo(node.getNext(), numero);
	}

	protected void preencherPilha(Pilha pilha, int tamanho) {
		Random random = new Random();
		for (int i = 0; i < tamanho; i++) {
			int valorAleatorioParaInsercao = random.nextInt(100) + 1;
			while(contem(valorAleatorioParaInsercao)) {
				valorAleatorioParaInsercao = random.nextInt(100) + 1;
			}
			pilha.push(valorAleatorioParaInsercao);
		}
	}

	protected int peek() {
		if (head == null) {
			return -1;
		}
		int valor = head.getData();
		return valor;
	}

}