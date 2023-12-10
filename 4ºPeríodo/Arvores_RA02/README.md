# Arvores_RA02

### Inserção

| Arvore | Quantidade de Elementos | % CPU | Tempo |
| ------ | ----------------------- | ----- | ----- |
| Normal | 100                     | 0,364% | < 1 ms |
| Normal | 500                     | 0,448% | 2 ms |
| Normal | 1000                   | 0,546% | 2 ms |
| Normal | 10000                 | 0,770% | 3 ms |
| Normal | 20000                 | 1,050% | 4 ms |
| AVL     | 100                     | 0,427% | 2 ms |
| AVL     | 500                     | 0,525% | 2 ms |
| AVL     | 1000                   | 0,609% | 3 ms |
| AVL     | 10000                 | 1,610% | 8 ms |
| AVL     | 20000                 | 2,520% | 14 ms |

### Removendo 1 valor

| Arvore | Quantidade de Elementos | % CPU | Tempo |
| ------ | ----------------------- | ----- | ----- |
| Normal | 100                     | < 0,100% | < 1 ms |
| Normal | 500                     | < 0,100% | < 1 ms |
| Normal | 1000                   | < 0,100% | < 1 ms |
| Normal | 10000                 | < 0,100% | < 1 ms |
| AVL     | 100                     | < 0,100% | < 1 ms |
| AVL     | 500                     | < 0,100% | < 1 ms |
| AVL     | 1000                   | < 0,100% | < 1 ms |
| AVL     | 2000                   | < 0,100% | < 1 ms |
| AVL     | 20000                 | < 0,100% | < 1 ms |

### Buscando

| Arvore | Quantidade de Elementos | % CPU | Tempo |
| ------ | ----------------------- | ----- | ----- |
| Normal | 100                     | < 0,100% | < 1 ms |
| Normal | 500                     | < 0,100% | < 1 ms |
| Normal | 1000                   | < 0,100% | < 1 ms |
| Normal | 10000                 | < 0,100% | < 1 ms |
| AVL     | 100                     | < 0,100% | < 1 ms |
| AVL     | 500                     | < 0,100% | < 1 ms |
| AVL     | 1000                   | < 0,100% | < 1 ms |
| AVL     | 2000                   | < 0,100% | < 1 ms |
| AVL     | 20000                 | < 0,100% | < 1 ms |


---------------------
# Gráficos
<img src="https://cdn.discordapp.com/attachments/1105267542085345402/1159296753368047647/Figure_1.png?ex=6530823c&is=651e0d3c&hm=b9ab51ea05ff9e59ff8e6109797ef6a6d29a80d8ea7eda3d4b3d211be3d9d2f1&" />

---------------------

Os resultados demonstraram que, para um pequeno número de elementos, ambas as árvores apresentaram desempenho semelhante. No entanto, à medida que o número de elementos aumentou, as árvores AVL se destacaram, mostrando um alto uso de CPU e tempo durante operações de inserção. Para a operação de remoção, teoricamente, a árvore AVL teria um consumo de CPU mais elevado do que a árvore normal; no entanto, devido aos testes realizados não exercerem suficientemente a CPU, os dados não possuem um valor muito significativo. Na busca, é onde a árvore AVL ganha vantagem, pois já está balanceada, exigindo menos etapas do que a árvore normal.


#### Configuração do PC que rodou os testes:
- CPU: I5 10400F
- RAM: 16 GB 2666hz
- Sistema: Win 11 Pro
