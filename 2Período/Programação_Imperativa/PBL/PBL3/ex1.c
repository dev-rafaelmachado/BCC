#include <stdio.h>

int main(){
  int N, total, fib = 1, prev = 0;

  printf("Digite o termo N: ");
  scanf("%d", &N);

  if (N == 1) printf("%d", prev);
  else if (N == 2) printf("%d\n%d\n", prev, fib);
  else {
    printf("%d\n%d\n", prev, fib);
    for(int i = 0; i <= (N-3); i++){
      total = fib + prev;
      prev = fib;
      fib = total;
      printf("%d\n", total);
  }
  }
}