#include <stdio.h>

int main() {
  int placa, nEstado, nCidade, IDcarroCidade;

  printf("\ndigite o número da placa: ");
  scanf("%d", &placa);
  
  nEstado = placa / 1000;
  placa = placa - (nEstado * 1000);
  nCidade = placa / 100;
  IDcarroCidade = placa - (nCidade * 100);
  
  printf("\nNúmero do Estado: %d", nEstado);
  printf("\nNúmero da Cidade: %d", nCidade);
  printf("\nNúmero do ID do carro na cidade: %d", IDcarroCidade);
}