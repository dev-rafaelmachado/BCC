package br.com.tde2.main;

import java.util.Scanner;

import br.com.tde2.logic.AutoResolucao;
import br.com.tde2.logic.ConfereOrdem;
import br.com.tde2.logic.Mover;
import br.com.tde2.structure.Pilha;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int escolhaMenu = 0;
		int contadorJogadas  = 0;
		String menu = "\n1. Fazer um movimento\n2. Auto Resolução\n3. Sair"; 
		boolean primeiraJogada  = true;
		int tipoOrganizacao = 0;

		System.out.print("Tamanho das pilhas: ");
		int tamanhoPilhas = scanner.nextInt();
		
		System.out.print("Escolha o estilo de organização \n1 - Decrescente\n2 - Crescente\n");
		tipoOrganizacao = scanner.nextInt();
		while(tipoOrganizacao > 2 || tipoOrganizacao < 1) {
			System.out.print("Escolha inválida\nEscolha o estilo de organização \n1 - Decrescente\n2 - Crescente\n");
			tipoOrganizacao = scanner.nextInt();
		}

		Pilha pilha1 = new Pilha(tamanhoPilhas);
		pilha1.preencherAleatorio(pilha1, tamanhoPilhas);
		
		Pilha pilha2 = new Pilha(tamanhoPilhas);
		Pilha pilha3 = new Pilha(tamanhoPilhas);


		Mover movimentacao = new Mover(pilha1, pilha2, pilha3);
		
		ConfereOrdem confereOrdem = new ConfereOrdem();
		AutoResolucao resolucao = new AutoResolucao();

		do {
            if (pilha1.tamanhoPilha() == tamanhoPilhas) {
                if(confereOrdem.verificarOrdem(pilha1, "pilha 1", tipoOrganizacao)) return;
            } else if (pilha2.tamanhoPilha() == tamanhoPilhas) {
            	if(confereOrdem.verificarOrdem(pilha2, "pilha 2", tipoOrganizacao)) return;
            } else if (pilha3.tamanhoPilha() == tamanhoPilhas) {
            	if(confereOrdem.verificarOrdem(pilha3, "pilha 3", tipoOrganizacao)) return;
            }
            System.out.println();

            System.out.print("Pilha 1:");
            pilha1.printPilha();
            System.out.print("Pilha 2:");
            pilha2.printPilha();
            System.out.print("Pilha 3:");
            pilha3.printPilha();

            if (contadorJogadas  >= 1) primeiraJogada  = false;
            if (!primeiraJogada ) menu = "\n1. Mover\n3. Sair";

            System.out.println(menu);
            escolhaMenu = scanner.nextInt();

            switch (escolhaMenu) {
                case 1:
                    movimentacao.moverPilhas(scanner);
                    contadorJogadas ++;
                    break;
                case 2:
                    if (!primeiraJogada ) {
                        System.out.println("Escolha inválida, permitido apenas no começo do jogo");
                    } else {
                        contadorJogadas  = resolucao.ordenarCrescente(pilha1, pilha2, pilha3);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Escolha inválida");
            }
        } while (escolhaMenu != 3);

		System.out.println("Total de jogadas: " + contadorJogadas );
		scanner.close();
	}
}
