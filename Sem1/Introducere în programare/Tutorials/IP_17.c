#include<stdio.h>
int main()
{
int a[32767];
int max=-32767;
int min=32767;
int count=1;
int previous=-32767;

for(int i=0;i<32766;i++)
	{
	printf("Introduceti un numar intreg:");
	scanf("%d",&a[i]);
	// Conditie de iesire = introducere a 2 nr identice
	if(a[i]==previous) break;
	count++;
	previous=a[i];
	if(a[i]>max) max=a[i];
	if(a[i]<min) min=a[i];
	}

printf("Vectorul contine urmatorii termeni:");	
for(int i=0;i<count-1;i++)
	{
	printf("%d ",a[i]);
	}

printf("\nCel mai mic element este %d.\n",min);
printf("\nCel mai mare element este %d.\n",max);

}