# Rafael Leal Machado

# Função para fazer as contas
def calc(opera,cj1,cj2):
  if opera == 'U': # União
    rtn = []
    for i in range(len(cj1)):
        rtn.append(cj1[i])
    for i in range(len(cj2)):
        if cj2[i] not in rtn:
            rtn.append(cj2[i])
    print("União: conjunto 1",cj1,"conjunto 2",cj2,"Resultado:",rtn)
  elif opera == 'I': # Interseção
    any
  elif opera == 'D': # Diferença
    any
  elif opera == 'C': # Produto Cartesiano
    any

#Abrindo o arquivo e lendo as linhas
file = open('2Período/R.P.N.D/Atv1_Conjuntos/content.txt', 'r') 
data = file.readlines()

nOpr = int(data[0]. replace("\n", "")) # Número de Operações
vSm = ['U','I','D','C'] # operações aceitas

cont = 1 # Indice geral de linhas

# Criando uma matriz onde cada linha é um bloco de operação
for j in range(nOpr):
  vetorAux = []
  for i in range(3):
    element = data[cont].replace("\n", "")
    if element in vSm:
      vetorAux.append(element)
    else: # Dividindo os elementos do conjunto em uma lista
      arr = element.split(", ")
      vetorAux.append(arr)
    cont += 1
  calc(vetorAux[0],vetorAux[1],vetorAux[2])



