#include <stdio.h>

int main()
{
    float oper1, oper2; // operandos
    double result = 0; // result da operação
    char operador; // operador na forma de caracter
  
    puts("Digite o primeiro operando: ");
    scanf("%f", &oper1);
    
    puts("Digite o segundo operando: ");
    scanf("%f", &oper2);
    
    getchar(); // Consumir o Enter
  
    puts("Digite um operador (+, -, *, /): ");
    operador = getchar();

    switch(operador){
      case '+':
        result = oper1 + oper2;
        break;
      
      case '-':
        result = oper1 - oper2;
        break;
      
      case '*':
        result = oper1 * oper2;
        break;
      
      case '/':
        result = oper1 / oper2;
        break;
      
      default:
        puts("Operador inválido");
    }

    printf("Resultado = %.2f\n", result);
    return 0;
}