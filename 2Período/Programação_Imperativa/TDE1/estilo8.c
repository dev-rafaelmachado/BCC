//Depois
#include <stdio.h>

// Função para calcular o salário líquido do funcionário:
double calcular_salario_liquido(double sBrut, double ttDesc){
    return sBrut - ttDesc;
}

// Função principal:
int main(){
    double salario_bruto, total_descontos, salario_liquido;
    puts("Digite o salário bruto:"); scanf("%lf", &salario_bruto); // Atribuindo Salário Bruto
    puts("Digite o total de descontos:"); scanf("%lf", &total_descontos); // Atribuindo total de descontos
    
    printf("O salário líquido é %.2f\n", calcular_salario_liquido(salario_bruto, total_descontos)); // Exibindo o salario bruto calculado através de uma função
    
  return 0;
}