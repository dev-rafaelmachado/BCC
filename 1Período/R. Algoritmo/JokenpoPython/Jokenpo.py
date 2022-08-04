import random
# Continuar ou sair 
sMenu = 'C'
# Vars de placar
ListaJogadas = ["Pedra","Papel","Tesoura"]
sVitPL1 = 0
sVitPL2 = 0
sEmpt = 0
# Apresentação
print("OLá, vamos jogar joquempô!")
# Modo de jogo 
sMod = int(input("Escolha o seu modo de jogo: Digite (1) humano  x  computador , (2)  humano  x  humano, (3) computador  x  computador: "))
while sMod > 3:
    print("Opção inválida tente novamente")
    sMod = int(input("Digite (1) humano  x  computador , (2)  humano  x  humano, (3) computador  x  computador: "))
while sMenu == 'C':
    if sMod == 1: # humano  x  computador
        # Jogada player 1
        print("\nJogada player 1")
        jogadaPL1 = int(input("Digite (1) para pedra, (2) para papel, (3) para tesoura: "))
        while jogadaPL1 > 3:
            print("jogada invalida, tente novamente")
            jogadaPL1= int(input("Digite (1) para tesoura, (2) para papel, (3) parapedra: "))
        # Jogoda player 2
        jogadaPL2 = random.randint(1, 3)
    elif sMod == 2: # Humano vs Humano
        # Jogada player 1
        print("\nJogada player 1")
        jogadaPL1 = int(input("Digite (1) para pedra, (2) para papel, (3) para tesoura: "))
        while jogadaPL1 > 3:
            print("jogada invalida, tente novamente")
            jogadaPL1 = int(input("Digite (1) para tesoura, (2) para papel, (3) para pedra: "))
        # Jogoda player 2
        print("\nJogada player 2")
        jogadaPL2 = int(input("Digite (1) para pedra, (2) para papel, (3) para tesoura: "))
        while jogadaPL2 > 3:
            print("jogada invalida, tente novamente")
            jogadaPL2 = int(input("Digite (1) para tesoura, (2) para papel, (3) para pedra: "))
    else: # computador  x  computador
        jogadaPL1 = random.randint(1, 3)
        jogadaPL2 = random.randint(1, 3)
    
    print(" \nJogada Player1:", ListaJogadas[jogadaPL1-1] , "// Jogada Player2:", ListaJogadas[jogadaPL2-1])
    # 1 - pedra 
    # 2 - papel
    # 3 - tesoura
    print("Resultado:")
    if jogadaPL1 == jogadaPL2: # Empate
        print("Empate")
        sEmpt += 1
    elif jogadaPL1 == 1: # pedra
        if jogadaPL2 == 2:
            sVitPL2 += 1
            print("Player 2 ganhou")
        else:
            sVitPL1 += 1
            print("Player 1 Ganhou")
    elif jogadaPL1 == 2: # papel
        if jogadaPL2 == 1:
            sVitPL1 += 1
            print("Player 1 Ganhou")
        else:
            sVitPL2 += 1
            print("Player 2 ganhou")
    else: # Tesoura
        if jogadaPL2 == 2:
            sVitPL1 += 1
            print("Player 1 Ganhou")
        else:
            sVitPL2 += 1
            print("Player 2 ganhou")
    
    print(" \nVitórias do Player1:", sVitPL1, "// Vitórias do Player2:", sVitPL2, "// Empates", sEmpt)
    sMenu = input("(C) para continaur ou (S) para Sair: ")
    
print("--------------------------------------------------------------------------------")
print("Resultado Final")
print("Vitórias do Player1:", sVitPL1, "// Vitórias do Player2:", sVitPL2, "// Empates", sEmpt)
print("Obrigado por jogar, Rafael Leal Machado e Raphael de Oliveira Soares")
