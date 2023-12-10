package br.com.tde2.logic;

import br.com.tde2.structure.Pilha;

public class ConfereOrdem {

	public boolean verificarOrdem(Pilha pilha, String nome, int tipoOrganizacao) {
		if(tipoOrganizacao == 1) {
			return verificarDecrescente(pilha, nome);
		} else {
			return verificarCrescente(pilha, nome);
		}
	}

	private boolean verificarCrescente(Pilha pilha, String nomePilha) {
		boolean status = pilha.conferirOrdemCrescente();
		if (status) {
			System.out.println(nomePilha + " está ordenada em ordem crescente");
			return true;
		}
		return false;
	}

	private boolean verificarDecrescente(Pilha pilha, String nomePilha) {
		boolean status = pilha.conferirOrdemDecrescente();
		if (status) {
			System.out.println(nomePilha + " está ordenada em ordem decrescente!");
			return true;
		}
		return false;
	}
}
