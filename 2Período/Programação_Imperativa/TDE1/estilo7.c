#include <stdio.h>

int main(){
  
    char letras[10];
    puts("Digite 10 letras:");
  
    for (int index = 0; index < 10; index++){
        printf("letra %d: ", index+1);
        scanf("%2s", &letras[index]);
        
    }

    puts("As 10 letras digitadas foram:");
    for(int index = 0; index < 10; index++){
        putchar(letras[index]);
    }
    putchar('\n');

    puts("Digite uma sequência de, no máximo, 9 letras:");
    scanf("%10s", letras);
    printf("Sequência digitada: %s", letras);
    putchar('\n');
}