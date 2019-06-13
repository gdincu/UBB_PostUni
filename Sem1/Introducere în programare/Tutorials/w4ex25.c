//Afisati vocalele dintr-un sir de n caractere

#include<stdio.h>
#include<ctype.h>

int isvowel(int ch)
{
  int c = toupper(ch);
 
  return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
}

int main()
{
char a[7]={'0','B','2','d','E','f','i'};
int b=3,count=0;
for (count; count<=6; count++)
{
	if (isalpha(a[count]) && isvowel(a[count])) printf("%c\n",a[count]);
}
}