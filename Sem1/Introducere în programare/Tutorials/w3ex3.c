#include<stdio.h>
int main()
{
int a[99999],count,e;
for (count=0; count<99999; count++)
	{	
	printf("Introduce elementul %d: ",count);
	scanf("%d\n",&a[count]);
	
	// Conditia de iesire din FOR
	if(a[count]==a[count-1]) break;
	
	// if(a[count]%2==0) break;
	
	}
	
for(e=count;e>=0;e--)
 if(a[e]%2!=0) break;


// printf("\n\n Primul element par este %d.\n",a[count]);	
printf("\n\n Ultimul element impar este %d.\n",a[e]);	
}