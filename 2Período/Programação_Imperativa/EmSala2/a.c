int main() {
  int a, b, z;

  b = 2, a = 10;

  if (a > 0)
    printf("Valor positivo\n");
  if (a < b) {
    z = a;
    printf("A é menor que B\nZ = %d",z);
  } else {
    z = b;
    printf("B é menor que A\nZ = %d",z);
  } return (0);
}