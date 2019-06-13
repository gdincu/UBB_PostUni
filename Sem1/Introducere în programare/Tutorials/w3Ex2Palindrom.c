#include <stdio.h>
int main()
{
int numar,rest,invers,constanta;
printf("Introduceti un numar: ");
scanf("%d",&numar);	
constanta=numar;

while (numar!=0)
{
	rest=numar%10;
	invers=invers*10+rest;
	numar/=10;	
}

if(constanta==invers) printf("Numarul este palindrom\n\n");
if(constanta!=invers) printf("Numarul nu este palindrom\n\n");

}