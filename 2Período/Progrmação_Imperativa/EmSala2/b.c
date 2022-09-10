#include <stdio.h>

int main() {
  int a = 10, b = 0;

  while((a != 0) || (b != 10)){
    printf("A = %d B = %d\n",a,b);
    a--;
    b++;
  }
  return(0);
}