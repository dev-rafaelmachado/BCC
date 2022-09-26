#include <stdio.h>

char vVogais[10] = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

int fVerificarVogal(char pCarc){
  for (int i = 0; i <= 10; i++){
    if (pCarc == vVogais[i])
      return (1);
  }
  return (0);
}

int main() {
  char caracter[1];
  int nVogal = 0, nCons = 0;

  while (caracter[0] != '0'){
  printf("Entre com um caracter: ");
  scanf("%s", &caracter[0]);
  if (fVerificarVogal(caracter[0]) == 1)
    nVogal += 1;
  else
    nCons += 1;
  } 
  printf("Consoantes = %d Vogais = %d", (nCons - 1), nVogal);
  
}