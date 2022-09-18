#include <stdio.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "Portuguese"); //habilita a acentuação para o português

    char nomedopaciente[20]; // nome do paciente
    puts("Digite o seu nome: ");
    scanf("%s", nomedopaciente);

    int kkk = 0; // idade do paciente
    puts("Digite a sua idade: ");
    scanf("%d", &kkk);
    
    printf("%s, você tem %d anos.\n", nomedopaciente, kkk);
    return 0;
}