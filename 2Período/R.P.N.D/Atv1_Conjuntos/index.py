# Rafael Leal Machado

# Função para fazer as contas
def calc(opera,cj1,cj2):
  rtn = []
  if opera == 'U': # União
    for i in range(len(cj1)):
        rtn.append(cj1[i])
    for i in range(len(cj2)):
        if cj2[i] not in rtn:
            rtn.append(cj2[i])
    print("União: conjunto 1",cj1,"conjunto 2",cj2,"Resultado:",rtn, "\n")
  elif opera == 'I': # Interseção
    for i in range(len(cj1)):
      if cj1[i] in cj2:
        rtn.append(cj1[i])
    print("Interseção: conjunto 1",cj1,"conjunto 2",cj2,"Resultado:",rtn, "\n")
  elif opera == 'D': # Diferença
    for i in range(len(cj1)):
      if not cj1[i] in cj2:
        rtn.append(cj1[i])
    print("Diferença: conjunto 1",cj1,"conjunto 2",cj2,"Resultado:",rtn, "\n")
  elif opera == 'C': # Produto Cartesiano
    for i in range(len(cj1)):
      for j in range(len(cj2)):
        auxVt = []
        auxVt.append(cj1[i])
        auxVt.append(cj2[j])
        rtn.append(auxVt)
    print("Produto Cartesiano: conjunto 1",cj1,"conjunto 2",cj2,"Resultado:",rtn, "\n")

# Seletor de Arquivos
print("\n (1) para o aquivo 1; \n (2) para o arquivo 2; \n (3) para o arquivo 3; \n (4) para adicionar outro arquivo")
choice = int(input(": "))
while choice < 1 or choice > 4:
      print("Inválido, tente novamente")
      choice = int(input(":"))
if choice == 1:
  path = '2Período/R.P.N.D/Atv1_Conjuntos/content-1.txt'
elif choice == 2:
      path = '2Período/R.P.N.D/Atv1_Conjuntos/content-2.txt'
elif choice == 3:
  path = '2Período/R.P.N.D/Atv1_Conjuntos/content-3.txt'
else:
  sPath = input("Coloque o arquivo na pasta Atv1_Conjuntos e digite seu nome aqui (exemplo: contas.txt): ")
  path = '2Período/R.P.N.D/Atv1_Conjuntos/' + sPath
print("\nRESULTADOS:\n")

#Abrindo o arquivo e lendo as linhas
file = open(path, 'r') 
data = file.readlines()

nOpr = int(data[0].replace("\n", "")) # Número de Operações
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