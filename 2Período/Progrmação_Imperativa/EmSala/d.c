#include <stdio.h>

int main() {
  float altura;
  int idade;
  
  printf("%s","Digite a sua idade e sua altura: ");
  scanf("%3d %5f", &idade, &altura);
  printf("A sua idade é %d", idade); printf("\n");
  printf("A sua altura é %3.2f", altura); printf("\n");
  
  return 0;
}