#include <stdio.h>

int main()
{
    const char * const prompt = "Digite o valor da conta %d: ";
    double total = 0;
    int numero_de_contas;
    
    printf("Digite o número de contas: ");
    scanf("%d", &numero_de_contas);

    for(int i = 0; i < (numero_de_contas+1); i++){
        printf(prompt, i);
        double valor;
        scanf("%lf", &valor);
        total = total + valor;
    }
    
    double valor_medio = total / numero_de_contas;

    printf("Valor total = %.2lf\n", total);
    printf("Valor médio = %.2lf\n", valor_medio);

    return 0;
}
