#include<stdio.h>
int main()
{
char s[10];
gets(s);
puts(s); //echivalent cu printf-ul de pe linia de mai jos
printf("%s\n",s); //echivalent cu puts(s) de pe lina de mai sus
}