#include<stdio.h>
#include<string.h>
int main()
{
	char s[10];
	
	gets(s); 
	
	printf("%c",s[strlen(s)-1]);
}
//tipareste ultimul element din stringul s