package br.com.tde2.logic;

import java.util.Scanner;

import br.com.tde2.structure.Pilha;

public class Mover {
	private Pilha pilha1;
	private Pilha pilha2;
	private Pilha pilha3;

	public Mover(Pilha pilha1, Pilha pilha2, Pilha pilha3) {
		this.pilha1 = pilha1;
		this.pilha2 = pilha2;
		this.pilha3 = pilha3;
	}

	public void moverPilhas(Scanner scanner) {
		int valor = 0;
		int escolhaDesempilhar;
		int escolhaEmpilhar;

		do {
			
			System.out.println("Qual pilha deseja desempilhar? (1, 2 ou 3)");
			escolhaDesempilhar = scanner.nextInt();
			
			if (escolhaDesempilhar < 1 || escolhaDesempilhar > 3) {
				System.out.println("Essa pilha não existe");
			} else {
				Pilha pilhaOrigem = getPilha(escolhaDesempilhar);
				if (pilhaOrigem.pilhaVazia()) {
					System.out.println("Pilha vazia");
				} else {
					valor = pilhaOrigem.pop();
				}
			}

		} while (escolhaDesempilhar < 1 || escolhaDesempilhar > 3 || valor == 0);

		do {
			System.out.println("Pilha de destino: ");
			escolhaEmpilhar = scanner.nextInt();

			if (escolhaEmpilhar < 1 || escolhaEmpilhar > 3
					|| escolhaEmpilhar == escolhaDesempilhar) {
				System.out.println("Pilha inexiste ou está sendo desempilhada");
			} else {
				Pilha pilhaDestino = getPilha(escolhaEmpilhar);
				if (pilhaDestino.pilhaCheia()) {
					System.out.println("Pilha cheia");
				} else {
					pilhaDestino.push(valor);
				}
			}

		} while (escolhaEmpilhar < 1 || escolhaEmpilhar > 3
				|| escolhaEmpilhar == escolhaDesempilhar);
	}

	private Pilha getPilha(int escolha) {
		Pilha pilhaSelecionada = null;
		if (escolha == 1) {
			pilhaSelecionada = pilha1;
		} else if (escolha == 2) {
			pilhaSelecionada = pilha2;
		} else {
			pilhaSelecionada = pilha3;
		}
		return pilhaSelecionada;
	}
}