#include <stdio.h>

int main()
{
    char letras[10];

    puts("Digite 10 letras:");

    for (int i = 0; i < 10; i++)
    {
        printf("letra %d: ", i+1);
        letras[i] = getchar();
        getchar(); // skip the ENTER char
    }

    puts("As 10 letras digitadas foram:");

    int i = 0;
    while (i < 10)
    {
        putchar(letras[i]);
        i++;
    }
    putchar('\n');

    puts("Digite uma sequência de, no máximo, 9 letras:");
    scanf("%s", letras);
    printf("Sequência digitada: %s", letras);
    putchar('\n');
}