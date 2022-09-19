#include <stdio.h>

int main()
{
    const char printChar = 'H'; // letra a ser impressa
    const int nPrint = 10; // número de vezes que a letra deve ser impressa
    int num = nPrint; // valor a ser impresso
    
  for (int i = 1; i <= nPrint; i++)
        putchar(printChar);
    putchar('\n');

    while (num > 0){
        printf("%d ", num);
        num--;
    }
    putchar('\n');

    return 0;
}