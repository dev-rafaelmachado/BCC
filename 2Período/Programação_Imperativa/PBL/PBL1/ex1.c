#include <stdio.h>

int main() {
  float primeroTermo;
  float razao;
  int n;
  float nTermo;

  printf("Digite o primero termo:");
  scanf("%f", &primeroTermo);

  printf("Digite a razão:");
  scanf("%f", &razao);

  printf("Digite o termo N:");
  scanf("%d", &n);
  
  /* an = a1 + (n – 1) . r */

  nTermo = primeroTermo + (n - 1) * razao;
  printf("O n-ésimo termo é: %3.2f",nTermo);
  return 0;
}