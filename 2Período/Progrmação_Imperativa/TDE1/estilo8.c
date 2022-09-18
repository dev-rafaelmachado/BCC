#include <stdio.h>

// Variáveis globais:
double salario_bruto;
double total_descontos;
double salario_liquido;

// Função para calcular o salário líquido do funcionário:
void calcular_salario_liquido()
{
    salario_liquido = salario_bruto - total_descontos;
}

// Função principal:
int main()
{
    puts("Digite o salário bruto:");
    scanf("%lf", &salario_bruto);
    puts("Digite o total de descontos:");
    scanf("%lf", &total_descontos);
    calcular_salario_liquido(); // chamada da função
    printf("O salário líquido é %.2f\n", salario_liquido);
    return 0;
}