/* Programa para calcular as raízes de uma
equação de segundo grau */

#include <stdio.h>
#include <math.h>

int main() {   float a, b, c;
    puts("Digite a: "); scanf("%f", &a);
        puts("Digite b: "); scanf("%f", &b);
puts("Digite c: "); scanf("%f", &c);
    float d = pow(b,2)-4*
    a*c;
      printf("%f\n", d);
  if (d<0) puts("Nao existe raiz!"); else 
    if (d==0) {puts("Existe uma raiz:");
    float x = -b/(2* a); printf("%f\n", x);
     } else {
    puts("Existem duas raizes:");
    float rd = pow(d,0.5);
    float x = (-b + rd)/(2*a); printf("%f\n", x);
    x = (-b - rd)/(2*a); printf("%f\n", x);}
       return 0;
}