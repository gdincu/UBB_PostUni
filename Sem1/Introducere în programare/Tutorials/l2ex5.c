#include<stdio.h>
int main()
{
char s[10];
int a,b;
//gets(s);
//a=atoi(s);
//gets(s);
//b=atoi(s);

scanf("%d",&a);
a++;
printf("%s\n",itoa(a));
//printf("%d\n",a+b);

}

//converteste un string in numar
//folositor cand vrem sa terminam un program care citeste numere de la tastatura folosing un string (eg. EXIT)
//itoa este inversul lui atoi si converteste din numere in litere - citirea se face numai cu scanf
