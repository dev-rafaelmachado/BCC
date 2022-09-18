#include <stdio.h>

int main()
{
    const char l = 'H'; // letra a ser impressa
    const int I = 10; // número de vezes que a letra deve ser impressa
    for (int i = 1; i <= I; i++)
        putchar(l);
    putchar('\n');

    int O = I; // valor a ser impresso
    while (O > 0)
    {
        printf("%d ", O);
        O--;
    }
    putchar('\n');

    return 0;
}