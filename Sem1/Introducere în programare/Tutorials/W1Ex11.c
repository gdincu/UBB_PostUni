#include<stdio.h>
int main(void) 
{
int x, y, sum=0;
printf("Cate numere vrem?");
scanf("%d", &x);

for(int i=0; i<x; i++) {
printf("Introduceti un numar: ");
scanf("%d", &i);
sum+=i;
}

printf("Suma tuturor numerelor pozitive citite de la tastatura este %d.\n", sum);

return 0;
}