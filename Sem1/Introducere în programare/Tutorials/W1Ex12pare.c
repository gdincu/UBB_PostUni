#include<stdio.h>
int main(void) 
{
int x=1, sum=0;


while (x!=0)
{
printf("Noua valoare a lui x este: ");
scanf("%d", &x);

if (x%2==0) sum=sum+x;
}

printf("Suma tuturor numerelor pozitive citite de la tastatura este %d.\n", sum);


return 0;
}