#include <stdio.h>
#include <math.h>

int main() {
  float PI = 3.1416, Volume;
  int R = 0;

  while (R <= 6){
    Volume = 4/3 * PI * (pow(R,3));
    printf("R = %d\t Volume = %f3.2\n", R, Volume);
    R += 2;
  }
}