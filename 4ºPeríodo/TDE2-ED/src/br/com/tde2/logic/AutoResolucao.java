package br.com.tde2.logic;

import br.com.tde2.structure.Pilha;

public class AutoResolucao {
	private int jogadas = 0;

	public int ordenarCrescente(Pilha pilha1, Pilha pilha2, Pilha pilha3) {
		int tamanhoPilha1 = pilha1.tamanhoPilha();

		if (tamanhoPilha1 <= 0) {
			return jogadas;
		}

		int menorItem = 101;

		while (!pilha1.pilhaVazia()) {
			int item = pilha1.pop();
			if (item < menorItem) {
				menorItem = item;
			}
			pilha3.push(item);
		}

		pilha2.push(menorItem);
		jogadas++;

		while (!pilha3.pilhaVazia()) {
			int item = pilha3.pop();
			if (item != menorItem) {
				pilha1.push(item);
			}
		}

		return ordenarCrescente(pilha1, pilha2, pilha3);
	}
}
