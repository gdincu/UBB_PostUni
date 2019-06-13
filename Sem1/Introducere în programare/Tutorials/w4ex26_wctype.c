//Afisati consoanele dintr-un sir de n caractere

#include<stdio.h>

int main()
{
char a[7]={'A','z','2','d','E','f','i'};
int counta,var;

for (counta=0; counta<7; counta++)
{
var=a[counta];

if (var>=65 && var<=90) 
{ 
if (var!=65 && var!=69 && var!=73 && var!=79 && var!=85)
	{printf("%c\n",a[counta]);}
}

if (var>=97 && var<=122) 
{ 
if (var!=65+32 && var!=69+32 && var!=73+32 && var!=79+32 && var!=85+32)
	{printf("%c\n",a[counta]);}
}

}

}