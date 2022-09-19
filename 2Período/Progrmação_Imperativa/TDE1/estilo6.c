#include <stdio.h>

// MESES DO ANO
char* meses[] = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
    "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

// DIAS DA SEMANA
char* dias_da_semana[] = { "Segunda-feira", "Terça-feira", "Quarta-feira",
    "Quinta-feira", "Sexta-feira", "Sábado", "Domingo" };

int main(){
  int mes_selecionado, dia_selecionado;
  
  // SELEÇÃO DO MÊS DO ANO:
  puts("Meses do ano: ");

  // Exibindo todos os meses 
  for (int index_Meses = 0; index_Meses <= 11; index_Meses++){
    printf("\t(%2d) %s\n", index_Meses, meses[index_Meses]);
  }

  // Selecionando o mês
  puts("Selecione um mês pelo seu número: "); scanf("%d", &mes_selecionado);
  printf("Mês selecionado: %s\n", meses[mes_selecionado]);

  // ------------------------------------------ //
  
  // SELEÇÃO DO DIA DA SEMANA:
  putchar('\n');
  puts("Dias da semana: ");

  // Exibindo todos os dias da semana 
  for (int index_DiaSemana = 0; index_DiaSemana <= 6; index_DiaSemana++){
    printf("\t(%2d) %s\n", index_DiaSemana, dias_da_semana[index_DiaSemana]);
  }

  // Selecionando o dia da semana
  puts("Selecione um dia pelo seu número: ");scanf("%d", &dia_selecionado);
  printf("Dia selecionado: %s\n", dias_da_semana[dia_selecionado]);

  // ------------------------------------------ //
  
  // TOMADA DE DECISÃO:
  putchar('\n');

  if (mes_selecionado == 0 || dia_selecionado == 6) // mês 0 = janeiro | dia 8 = domingo
      puts("Descansar!\n");
  else
      puts("Trabalhar!\n");
  
  return 0;
}