// TDE2 - Exercício 1 | Grupo 15

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
    
int letrasAsci[54] = {65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

int resultado[54] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


int main(int argc1, char* path[]){
  FILE *file;
  char frase[charTamanhoArquivo];
  int letra;

  printf("Parâmetro: %s\n", path[1]);
  // Escolhendo e abrindo o Arquivo
  file = fopen(path[1], "r");
  if (file == NULL){
    puts("Arquivo não encotrado\n");
    return 0;
  }
  
  puts("\nTexto:");
  while(fgets(frase, charTamanhoArquivo, file) != NULL){
    printf("%s\n",frase);
    // Um for passando por todas as letras 
    for(int i = 0; i <= numCarctes(frase); i++){
      letra = frase[i];
      if(letra != 0 && letra != 10) // Caso não seja "" e " "
        // Um for passando por todos as letras da tabela ANSI
        for(int j = 0; j < 54; j++)
          if(letra == letrasAsci[j]) // Caso a letra seja = ao código: letra no Resultado + 1
            resultado[j] += 1;
    }
  }

  // Printando o Resultado
  puts("\nResultado:");
  for(int i = 0; i < 54; i++){
    if (resultado[i] != 0)
      printf("%c | %d\n", letrasAsci[i], resultado[i]);
  }
  
  fclose(file);
  return 0;
  
}