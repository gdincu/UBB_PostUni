#include<stdio.h>
int main()
{
int nr_n=99999;
int max=-32767;
int min=32767;
int variabila=0;
int previous=0;
for(int i=1;i<=nr_n;i++)
	{
	printf("Introduce un nr:");
	scanf("%d",&variabila);
	// Conditie de iesire = introducere a 2 nr identice
	if(variabila==previous) break;
	if(variabila > max) max=variabila;
	if(variabila < min) min=variabila;
	previous=variabila;
	}	
printf("Maximul este %d.\n",max); 
printf("Minimul este %d.\n",min); 
	}