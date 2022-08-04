Estoque = [['ID  '   'Produto  '   'Preço  '  'Qntd'],
           [1, 'Coca-Cola', 3.75, 15],
           [2, 'Pepsi', 3.67, 10],
           [3, 'Monster', 9.96, 0],
           [4, 'Café', 1.25, 30],
           [5, 'Redbull', 13.99, 8]]
status = 1
cambioVal = [200,100,50,20,10,5,2,1,0.50,0.25,0.10,0.05,0.01]

def PrintNotasVal():
    print("Notas e Moedas Válidas:")
    for i in range(len(cambioVal)):
        if cambioVal[i] >= 1:
            print(cambioVal[i],"Reais")
        else:
            print(cambioVal[i],"Centavos")
def CalcTroco(tr):
    for k in range(len(cambioVal)):
        QntTroco = int(tr // cambioVal[k])
        if (QntTroco) >= 1:
            if cambioVal[k] > 1:
                print((QntTroco)," Nota(s) de",cambioVal[k])
            else:
                print((QntTroco)," Moeda(s) de",cambioVal[k])
        tr -= ( (QntTroco) * cambioVal[k])

while status == 1:
    for i in range(len(Estoque)):
        print("".join(str(Estoque[i])))
    
    escolha = int(input("\nDigite o Código do produto: ")) 
    
    while escolha > Estoque[(len(Estoque))-1][0] or Estoque[escolha][3] < 1:
        print("Escolha inválida ou produto indisponivel, tente novamente")
        escolha = int(input("Digite o Código do produto: "))
    
    valor = Estoque[escolha][2]
    print("\nVocê escolheu",Estoque[escolha][1],"o valor a pagar é",valor)

    print("\033[1;31mInsira as notas ou moedas\033[m")
    PrintNotasVal()
    
    valorPago = 0
    valorInserido = float(input(": "))
    while not valorInserido in cambioVal:
        print("Invalido, tente novamente")
        valorInserido = float(input(": "))

    valorPago += valorInserido
    while valorPago < valor:
        print("Valor até agora inserido:", valorPago)
        valorInserido = float(input(": "))
        while not valorInserido in cambioVal:
            print("Invalido, tente novamente")
            valorInserido = float(input(": "))
        valorPago += valorInserido

    print(valorPago)
    troco = valorPago - valor
    print(troco)

    CalcTroco(troco)

    status = int(input("(1) Para comprar mais, (2) para sair: "))
