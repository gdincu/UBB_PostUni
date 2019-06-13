//Tema laborator 3 - concatenarea a 2 siruri citie de la tastatura

#include <stdio.h>

int main() 
{
    int a[9999], b[9999], concat[200], m, n, c, d;
    
//Populam primul sir cu elemente
    for (m=0; m<99999; m++)
	{	
	printf("Introduce elementul %d al primului sir: ",m);
	scanf("%d\n",&a[m]);
	
	// Conditia de iesire din FOR
	if(a[m]==a[m-1]) break;
	}
	
//Populam sirul doi cu elemente
	for (n=0; n<99999; n++)
	{	
	printf("Introduce elementul %d al celui de-al doilea sir: ",n);
	scanf("%d\n",&b[n]);
	
	// Conditia de iesire din FOR
	if(b[n]==b[n-1]) break;
	}
	
	for(c;c<m+n;c++)
	{
		if(c<m) 
		{
			concat[c]=a[c];
		}
		else 
		{
			concat[c]=b[d];
			d++;
		}
		
		printf("%d\n",concat[c]);
	}
}