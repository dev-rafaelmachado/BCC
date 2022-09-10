#include <stdio.h>

int main(void) {
  int c;
  
  puts("Entre com um caracter e tecle enter");
  c = getchar();
  puts("O caracter escolhido foi: ");
  putchar(c);
  putchar('\n');
  return 0;
}