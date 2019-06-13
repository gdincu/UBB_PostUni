#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

int main()
{
char x[10]={'0','1','2','3','4','5','6','7','8','9'}; 
int n[10]={1,2,3,4,5,6,7,8,9},numar,check1,count=1;
	    
// Functie de actualizare a ecranului
void print()
	{
	system("@cls||clear");
	printf(" ___________________________________________________________________\n|                          X si 0 - V1.0                            |\n ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
	printf("| Jucatorul 1 va juca cu [X] in timp ce jucatorul 2 va juca cu [0]  |\n ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n\n ___________________________________________________________________\n|                                                                   |\n|                                                                   |\n|                                                                   |\n");	
	printf("|                            %c|%c|%c                                  |\n",x[1],x[2],x[3]);
	printf("|                            ¯ ¯ ¯                                  |\n");
	printf("|                            %c|%c|%c                                  |\n",x[4],x[5],x[6]);
	printf("|                            ¯ ¯ ¯                                  |\n");
	printf("|                            %c|%c|%c                                  |\n",x[7],x[8],x[9]);
	printf("|                            ¯ ¯ ¯                                  |\n|                                                                   |\n|                                                                   |\n|                                                                   |\n ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n\n\n");
	}	


void win_p1 ()
{
printf("                    Jucatorul 1 a castigat!!!!\n\n");
check1=1;
getchar();
}

void win_p2 ()
{
printf("                    Jucatorul 2 a castigat!!!!\n\n");
check1=1;
getchar();
}

// Functie de verificare - player1
void player1()
	{
		
	if(x[1]==x[2] && x[2]==x[3]) 
	win_p1();
	
	if(x[1]==x[5] && x[5]==x[9])
	win_p1();
	
	if(x[1]==x[4] && x[4]==x[7]) 
	win_p1();
	
	if(x[2]==x[5] && x[5]==x[8])
	win_p1();
	
	if(x[3]==x[6] && x[6]==x[9])
	win_p1();
	
	if(x[3]==x[5] && x[5]==x[7])
	win_p1();
	
	if(x[4]==x[5] && x[5]==x[6])
	win_p1();
	
	if(x[7]==x[8] && x[7]==x[9])
	win_p1();
	
	}

// Functie de verificare - player2
void player2()
	{
		
	if(x[1]==x[2] && x[2]==x[3]) 
	win_p2();
	
	if(x[1]==x[5] && x[5]==x[9])
	win_p2();
	
	if(x[1]==x[4] && x[4]==x[7]) 
	win_p2();
	
	if(x[2]==x[5] && x[5]==x[8])
	win_p2();
	
	if(x[3]==x[6] && x[6]==x[9])
	win_p2();
	
	if(x[3]==x[5] && x[5]==x[7])
	win_p2();	
	
	if(x[4]==x[5] && x[5]==x[6])
	win_p2();
	
	if(x[7]==x[8] && x[7]==x[9])
	win_p2();
	
	}

	
// Curatam ecranul si afisam tabelul intial
print();

// Bucla de verificare
for(count;count<=9;count++)
	{	
	reintro:print();
			if(count%2!=0)
		{	printf("X - alege un numar: ");
			scanf("%d",&n[count]);
			if (!isdigit(x[n[count]])) goto reintro;
			x[n[count]]='X';
			print();
			player1();
			if(check1==1) goto label1;
		}
	else
		{ 	printf("O - alege un numar: ");
			scanf("%d",&n[count]);
			if (!isdigit(x[n[count]])) goto reintro;
			x[n[count]]='O';
			print();
			player2();
			if(check1==1) goto label1;
		}
	}

// Label pre-definit pentru terminarea programului
label1: printf("\n ___________________________________________________________________\n|                          END OF GAME                              |\n ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n\n");

}