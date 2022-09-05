#include <stdio.h>

int main() {
  int x,y;
  
  printf("Digite o primero valor:");
  scanf("%d", &x);
  
  printf("Digite o primero valor:");
  scanf("%d", &y);
  
  printf("%d / %d = %d || Resto = %d",x,y,x/y,x%y);
  
  return 0;
}