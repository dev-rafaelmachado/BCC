#include <stdio.h>
#include <math.h>

int main() {
  int D4, D3, D2, D1, Num = 1352;
  
  D4 = Num % 10;
  D3 = (Num / 10) % 10;
  D2 = (Num / 100) % 10;
  D1 = (Num / 1000) % 10;
  printf("%d %d %d %d", D4, D3, D2, D1);
}