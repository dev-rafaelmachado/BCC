# Rafael Leal Machado

file = open('2Período/R.P.N.D/Atv1_Conjuntos/content.txt', 'r') 
data = file.readlines()
nOpr = int(data[0]. replace("\n", ""))
matriz = []

for j in range(nOpr):
  vetorAux = []
  for i in range(3):
    vetorAux.append(data[i+1].replace("\n", ""))
  matriz.append(vetorAux)

print(nOpr)
print(matriz)