#include <stdio.h>

int numero, valor;
char resp;

int main() {
  /* Declaração */
  int aplic;
  char carac;
  float rel;

  /* Inicialização */
  aplic = 2;
  carac = 'A';
  valor = 3;
  resp = 'B';
  rel = 333.22;

  /* Impressão de valores */
  printf("aplic = %d\n",aplic);
  printf("carac = %c\n", carac);
  printf("valor = %d\nresp = %c\nrel = %3.2f\n", valor,resp,rel);
  
  return 0;
}