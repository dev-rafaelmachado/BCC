#include <stdio.h>

int main() {
  int lSup, lInf;
  
  printf("Digite o Limete Inferior: ");
  scanf("%d",&lInf);
  
  for (int i = 0; i < 3; i++){
    printf("Digite o Limete Superior: ");
    scanf("%d",&lSup);
    if (!(lSup <= lInf))
      i = 3;
  }
  while (lInf % 3 != 0)
    lInf += 1;
  while(lInf <= lSup){
    printf("%d\n", lInf);
    lInf += 3;
  }
}