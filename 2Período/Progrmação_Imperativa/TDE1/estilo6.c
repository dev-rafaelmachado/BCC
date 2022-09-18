#include <stdio.h>

// MESES DO ANO
const int janeiro = 0;
const int fevereiro = 1;
const int marco = 2;
const int abril = 3;
const int maio = 4;
const int junho = 5;
const int julho = 6;
const int agosto = 7;
const int outubro = 9;
const int novembro = 10;
const int dezembro = 11;

// DIAS DA SEMANA
const int segunda = 0; // segunda-feira
const int terca = 1; // terça-feira
const int quarta = 2; // quarta-feira
const int quinta = 3; // quinta-feira
const int sexta = 4; // sexta-feira
const int sabado = 5; // sábado
const int domingo = 6; // domingo

char* meses[] = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
    "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

char* dias_da_semana[] = { "Segunda-feira", "Terça-feira", "Quarta-feira",
    "Quinta-feira", "Sexta-feira", "Sábado", "Domingo" };

int main()
{
    // SELEÇÃO DO MÊS DO ANO:
    puts("Meses do ano: ");
    
    for (int m = janeiro; m <= dezembro; m++)
    {
        printf("\t(%2d) %s\n", m, meses[m]);
    }

    int mes_selecionado;
    puts("Selecione um mês pelo seu número: ");
    scanf("%d", &mes_selecionado);
    printf("Mês selecionado: %s\n", meses[mes_selecionado]);

    // SELEÇÃO DO DIA DA SEMANA:
    putchar('\n');
    puts("Dias da semana: ");

    for (int d = segunda; d <= domingo; d++)
    {
        printf("\t(%2d) %s\n", d, dias_da_semana[d]);
    }

    int dia_selecionado;
    puts("Selecione um dia pelo seu número: ");
    scanf("%d", &dia_selecionado);
    printf("Dia selecionado: %s\n", dias_da_semana[dia_selecionado]);

    // TOMADA DE DECISÃO:
    putchar('\n');

    if (mes_selecionado == janeiro || dia_selecionado == domingo)
    {
        puts("Descansar!\n");
    }
    else
    {
        puts("Trabalhar!\n");
    }

    return 0;
}