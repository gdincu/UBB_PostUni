//Tema laborator 3 - concatenarea a 2 siruri citie de la tastatura + sortarea lor

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
	
//Atribuim valori sirului concat	
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
	
	for(c=0;c<m+n;c++)
	{
		for (d = 0; d < n; d++)             //Loop for comparing other values
		{
			if (concat[d] > concat[c])                //Comparing other array elements
			{
				int tmp = a[c];         //Using temporary variable for storing last value
				a[c] = a[d];            //replacing value
				a[d] = tmp;             //storing last value
			}  
		}
	}
	for (int c = 0; c < m+n; c++)                     //Loop for printing array data after sorting
	{
		printf(" %d ", concat[c]);
	}
}