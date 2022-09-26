/* Programa para calcular as raízes de uma
equação de segundo grau */

#include <stdio.h>
#include <math.h>

int main() {   
  float vA, vB, vC;
    
  puts("Digite a: "); scanf("%f", &vA); // Atribuindo valor para A
  puts("Digite b: "); scanf("%f", &vB); // Atribuindo valor para B
  puts("Digite c: "); scanf("%f", &vC); // Atribuindo valor para C
    
  float delta = pow(vB,2) - 4 * vA * vC; printf("%f\n", delta); // Calculando Delta
    
  if (delta < 0) 
    puts("Nao existe raiz!"); 
  else if (delta == 0) {
    puts("Existe uma raiz:");
    float vX = -vB/(2* vA); printf("%f\n", vX); // Calculando a raiz
  } else {
    puts("Existem duas raizes:");
    float raizDelta = pow(delta,0.5); // 
    float vX = (-vB + raizDelta )/(2*vA); printf("%f\n", vX); // Calculando a raiz x1
    vX = (-vB -raizDelta ) / (2*vA); printf("%f\n", vX); // Calculando a raiz x2
  }
  return 0;
}