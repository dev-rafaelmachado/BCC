/* Programa para criptografar e descriptografar
o primeiro nome e o sobrenome de uma pessoa, sendo que
ambos podem ser nomes compostos */

#include <stdio.h>

const char LF = 10; // caracter de fim de linha (Line Feed)

int main()
{
    const int MAX_LETRAS = 9;
    const int TAMANHO_BUFFER = MAX_LETRAS + 1;
    const int PRIMEIRO_NOME_SHIFT = 1;
    const int SOBRENOME_SHIFT = 2;
    char primeiro_nome[TAMANHO_BUFFER];
    char sobrenome[TAMANHO_BUFFER];
    int i, nao_fim_linha;

    // LEITURA DO PRIMEIRO NOME:
    printf("Digite o primeiro nome e tecle ENTER: ");
    i = 0;
    nao_fim_linha = 1;
    while (i < MAX_LETRAS && nao_fim_linha)
    {
        char c = getchar();
        if (c == LF) // verifica se é fim de linha
            nao_fim_linha = 0;
        else
        {
            primeiro_nome[i] = c;
            i++;
        }
    }
    primeiro_nome[i] = '\0'; // termina a string
    while (nao_fim_linha) // descarta tudo até o fim da linha
    {
        char c = getchar();
        if (c == LF) // verifica se é fim de linha
            nao_fim_linha = 0;
    }
    printf("Primeiro nome armazenado: %s\n", primeiro_nome);

    // LEITURA DO SOBRENOME:
    printf("Digite o sobrenome e tecle ENTER: ");
    i = 0;
    nao_fim_linha = 1;
    while (i < MAX_LETRAS && nao_fim_linha)
    {
        char c = getchar();
        if (c == LF)
            nao_fim_linha = 0;
        else
        {
            sobrenome[i] = c;
            i++;
        }
    }
    sobrenome[i] = '\0'; // termina a string
    while (nao_fim_linha) // descarta tudo até o fim da linha
    {
        char c = getchar();
        if (c == LF)
            nao_fim_linha = 0;
    }
    printf("Sobrenome armazenado: %s\n", sobrenome);

    // CRIPTOGRAFIA DO PRIMEIRO NOME:
    char primeiro_nome_criptografado[TAMANHO_BUFFER];
    i = 0;
    while (primeiro_nome[i]) // enquanto não for da string
    {
        primeiro_nome_criptografado[i] = primeiro_nome[i] +
            PRIMEIRO_NOME_SHIFT; // criptografa o caracter
        i++;
    } 
    primeiro_nome_criptografado[i] = '\0'; // termina a string
    
    // CRIPTOGRAFIA DO SOBRENOME:
    char sobrenome_criptografado[TAMANHO_BUFFER];
    i = 0;
    while (sobrenome[i]) // enquanto não for fim da string
    {
        sobrenome_criptografado[i] = sobrenome[i] +
            SOBRENOME_SHIFT; // criptografa o caracter
        i++;
    } 
    sobrenome_criptografado[i] = '\0'; // termina a string
    
    // RESULTADOS DA CRIPTOGRAFIA:
    printf("Primeiro nome criptografado: %s\n", primeiro_nome_criptografado);
    printf("Sobrenome criptografado: %s\n", sobrenome_criptografado);

    // DESCRIPTOGRAFIA DO PRIMEIRO NOME:
    char primeiro_nome_descriptografado[TAMANHO_BUFFER];
    i = 0;
    while (primeiro_nome_criptografado[i]) // enquanto não for fim da string
    {
        primeiro_nome_descriptografado[i] = primeiro_nome_criptografado[i] -
            PRIMEIRO_NOME_SHIFT; // descriptografa o caracter
        i++;
    }
    primeiro_nome_descriptografado[i] = '\0'; // termina a string
    
    // DESCRIPTOGRAFIA DO SOBRENOME:
    char sobrenome_descriptografado[TAMANHO_BUFFER];
    i = 0;
    while (sobrenome_criptografado[i]) // enquanto não for fim da string
    {
        sobrenome_descriptografado[i] = sobrenome_criptografado[i] -
            SOBRENOME_SHIFT; // descriptografa o caracter
        i++;
    }
    sobrenome_descriptografado[i] = '\0'; // termina a string

    // RESULTADOS DA DESCRIPTOGRAFIA:
    printf("Primeiro nome descriptografado: %s\n", primeiro_nome_descriptografado);
    printf("Sobrenome descriptografado: %s\n", sobrenome_descriptografado);

    return 0;
}