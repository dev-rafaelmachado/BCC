#include <stdio.h>

int main() {
  int a,b;

  /* Exemplo de Pós incremento */
  b = 10;
  a = b++;
  printf("a = %d\nb = %d\n\n", a,b);

  /* Exemplo de Pré incremento */
  b = 10;
  a = ++b;
  printf("a = %d\nb = %d\n\n", a,b);
  return 0;
}