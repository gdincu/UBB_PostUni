#include<stdio.h>
int main()
{
int n = 0,max,min;
printf("Acest program arata MAX si MIN dintre N numere introduse de la tastatura.\nPentru a termina programul introduceti valoarea 0 de doua ori\n");

//Daca primul N este 0 merge la label1. Daca nu seteaza minimul si maximul la prima valoare a lui N.
printf("Dati o valoare lui N: ");
scanf("%d", &n);
if(n==0) goto label1;
else {
	min = n;
	max = n;
}		

// Cat timp n este adevarat (N diferit de 0) 
while (n) {
		printf("Dati o valoare lui N: ");
		scanf("%d", &n);
		//if (n==0) break;
		if (n>max) max=n;
		while (n<min && n!=0) min=n;
}

label1: printf("Cel mai mare numar introdus a fost %d.\n", max);
printf("Cel mai mic numar introdus a fost %d.\n", min);

return 0;
}