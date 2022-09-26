// TDE2 - Exercício 2 | Grupo 15

#include <stdio.h>
#define charTamanhoArquivo 1024

// Função para calcular 
int numCarctes(char string[]){
   int index, count = 0;
  while(index != 0){
    index = string[count];
    count++;
  }
  return count - 1;
}

int main(int argc1, char* paths[]){
  FILE *file1;
  FILE *file2;
  char frase[charTamanhoArquivo];

  printf("Parâmetro 1: %s || Parâmetro 2: %s", paths[1],paths[2]);
  
  //Abrindo arquivo de Leitura
  file1 = fopen(paths[1], "r");
  if (file1 == NULL){
    puts("Arquivo não encotrado\n");
    return 0;
  }
  
  // Abrindo Arquivo de Gravação
  file2 = fopen(paths[2], "w");

  
  while(fgets(frase, charTamanhoArquivo, file1) != NULL){
    for(int i = 0; i <= numCarctes(frase); i++){
        if(frase[i] != 0 && frase[i] != 10 && frase[i] > 96){
          fprintf(file2,"%c", frase[i]-32);
        }
        else
          if(frase[i] != 0)
            fprintf(file2,"%c", frase[i]);
        }
      }

  puts("\nPronto!!!");
  fclose(file1);
  fclose(file2);
  return 0;
}