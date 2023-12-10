package br.com.tde2.structure;

public class Pilha {
	private ListaEncadeada ListaEncadeada;
	private int tamanhoMaximo;

	public Pilha(int tamanhoMaximo) {
		ListaEncadeada = new ListaEncadeada();
		this.tamanhoMaximo = tamanhoMaximo;
	}

	public boolean pilhaVazia() {
		return ListaEncadeada.vazia();
	}

	public boolean pilhaCheia() {
		return ListaEncadeada.tamanho() == tamanhoMaximo;
	}

	public void push(int data) {
		ListaEncadeada.insert(data);
	}

	public int pop() {
		return ListaEncadeada.remove();
	}
	
	public int peek() {
		return ListaEncadeada.peek();
	}

	public void printPilha() {
		ListaEncadeada.printListaEncadeada();
	}

	public int tamanhoPilha() {
		return ListaEncadeada.tamanho();
	}

	public boolean conferirOrdemCrescente() {
		return ListaEncadeada.crescente();
	}

	public boolean conferirOrdemDecrescente() {
		return ListaEncadeada.decrescente();
	}

	public void preencherAleatorio(Pilha pilha, int tamanhoMaximo) {
		ListaEncadeada.preencherPilha(pilha, tamanhoMaximo);
	}

}
