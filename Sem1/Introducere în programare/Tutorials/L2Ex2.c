#include<stdio.h>
int main()
{
int i=0,n;
char caracter, v[18];

scanf("%c",&caracter);
	
	while (caracter!='.') {
		v[i]=caracter;
		i++;
		scanf("%c",&caracter);
		}
		
n=i;
printf("am citit %d caractere.\n",n);
printf ("%c",v[0]);
for (i=0; i<n;i++)
	if((v[i-1]==' ')&&(v[i]!=' '))
		printf("%c",v[i]);
}

//programul calculeaza numarul de caractere introduse de la tastatura
//si arata initialele tuturor cuvintelor introduse