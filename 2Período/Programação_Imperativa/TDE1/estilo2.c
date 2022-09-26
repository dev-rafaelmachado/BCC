#include <stdio.h>
#include <locale.h>

int main(){
  setlocale(LC_ALL, "Portuguese"); //habilita a acentuação para o português
    
  char NomePaciente[20]; // nome do paciente
  int idadePaciente = 0; // idade do paciente
    
  puts("Digite o seu nome: ");
  scanf("%s", NomePaciente);

  puts("Digite a sua idade: ");
  scanf("%d", &idadePaciente);
    
  printf("%s, você tem %d anos.\n", NomePaciente, idadePaciente);
  return 0;
}