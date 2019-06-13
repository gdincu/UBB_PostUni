#include<stdio.h>
int main()
{
int a[32767];
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
	if(a[i]<0) 
		{i--;
		count--;
		}
	}

for(int i=0;i<count-1;i++)
	printf("%d ",a[i]);

}