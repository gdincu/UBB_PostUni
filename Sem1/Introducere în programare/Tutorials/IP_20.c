#include<stdio.h>
int main()
{
int a[32767];
int count=1, previous, _x;

for(int i=0;i<32766;i++)
	{
	printf("Introduceti un numar intreg:");
	scanf("%d",&a[i]);
	// Conditie de iesire = introducere a 2 nr identice
	if(a[i]==previous) break;
	count++;
	previous=a[i];
	}

printf("\nVrem sa afisam elementele de pe poziitile multiplii lui x. Cat sa fie x:");
scanf("%d",&_x);
	
printf("Lista elementelor de pe pozițiile multiplii lui x sunt:");
for(int i=0;i<count-1;i++)
	{
	if(i%_x==0) printf("%d ",a[i]);
	}

}