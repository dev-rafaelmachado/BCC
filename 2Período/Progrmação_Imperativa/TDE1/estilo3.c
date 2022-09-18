#include <stdio.h>

int main()
{
    float _a1, _a2; // operandos
    double RESULTADO = 0; // resultado da operação
    char op_char; // operador na forma de caracter
    puts("Digite o primeiro operando: ");
    scanf("%f", &_a1);
    puts("Digite o segundo operando: ");
    scanf("%f", &_a2);
    getchar();
    puts("Digite um operador (+, -, *, /): ");
    op_char = getchar();
    if (op_char == '+')
        RESULTADO = _a1 + _a2;
    else if (op_char == '-')
        RESULTADO = _a1 - _a2;
    else if (op_char == '*')
        RESULTADO = _a1 * _a2;
    else if (op_char == '/')
        RESULTADO = _a1 / _a2;
    else
        puts("Operador inválido");

    printf("Resultado = %.2f\n", RESULTADO);
    return 0;
}