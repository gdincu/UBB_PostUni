#include<stdio.h>
int main()
{
int a[32767];
int count=1, previous;

for(int i=0;i<32766;i++)
	{
	printf("Introduceti un numar intreg:");
	scanf("%d",&a[i]);
	// Conditie de iesire = introducere a 2 nr identice
	if(a[i]==previous) break;
	count++;
	previous=a[i];
	}

printf("Vectorul contine urmatorii termeni pari:");	
for(int i=0;i<count-1;i++)
	{
	if(a[i]%2==0) printf("%d ",a[i]);
	}

}