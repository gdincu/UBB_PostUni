#include<stdio.h>
#include<stdlib.h>

//Functie de curatare a ecranului
void clr()
{
	start1:system("@cls||clear");
}

int main()
{
	char x[10]={'0','1','2','3','4','5','6','7','8','9'},rematch; 
	int n1,n2,n3,n4,n5,n6,n7,n8,n9,numar,check1; 

// Functie de actualizare a ecranului
void print()
	{
	printf("--------------------------------------------------------------\nX si 0 - V1.0\n--------------------------------------------------------------\n");
	printf("Jucatorul 1 va juca cu [X] in timp ce jucatorul 2 va juca cu [0].\n\n");	
	printf("%c|%c|%c\n",x[1],x[2],x[3]);
	printf("¯ ¯ ¯\n");
	printf("%c|%c|%c\n",x[4],x[5],x[6]);
	printf("¯ ¯ ¯\n");
	printf("%c|%c|%c\n",x[7],x[8],x[9]);
	printf("¯ ¯ ¯\n");
	}	

// Functie de verificare - player1
void player1()
	{
		
	if(x[1]==x[2] && x[2]==x[3]) 
	{printf("Jucatorul 1 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[1]==x[5] && x[5]==x[9])
	{printf("Jucatorul 1 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[1]==x[4] && x[4]==x[7]) 
	{printf("Jucatorul 1 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[2]==x[5] && x[5]==x[8])
	{printf("Jucatorul 1 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[3]==x[6] && x[6]==x[9])
	{printf("Jucatorul 1 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[3]==x[5] && x[5]==x[7])
	{printf("Jucatorul 1 a castigat!!!!");
	check1=1;
	getchar();}	
	
	if(x[4]==x[5] && x[5]==x[6])
	{printf("Jucatorul 1 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[7]==x[8] && x[7]==x[9])
	{printf("Jucatorul 1 a castigat!!!!");
	check1=1;
	getchar();}
	
	}

// Functie de verificare - player2
void player2()
	{
		
	if(x[1]==x[2] && x[2]==x[3]) 
	{printf("Jucatorul 2 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[1]==x[5] && x[5]==x[9])
	{printf("Jucatorul 2 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[1]==x[4] && x[4]==x[7]) 
	{printf("Jucatorul 2 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[2]==x[5] && x[5]==x[8])
	{printf("Jucatorul 2 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[3]==x[6] && x[6]==x[9])
	{printf("Jucatorul 2 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[3]==x[5] && x[5]==x[7])
	{printf("Jucatorul 2 a castigat!!!!");
	check1=1;
	getchar();}	
	
	if(x[4]==x[5] && x[5]==x[6])
	{printf("Jucatorul 2 a castigat!!!!");
	check1=1;
	getchar();}
	
	if(x[7]==x[8] && x[7]==x[9])
	{printf("Jucatorul 2 a castigat!!!!");
	check1=1;
	getchar();}
	
	}
	
// Start Program	
// Curatam ecranul si afisam tabelul intial
clr();
print();

//Input 1-1
	printf("Jucatorul 1 - alege un numar: ");
	scanf("%d",&n1);
	x[n1]='X';
	clr();
	print();
	
//Input 2-1
	printf("Jucatorul 2 - alege un numar: ");
	scanf("%d",&n2);
	x[n2]='0';
	clr();
	print();

//Input 1-2
	printf("Jucatorul 1 - alege un numar: ");
	scanf("%d",&n3);
	x[n3]='X';
	clr();
	print();

//Input 2-2	
	printf("Jucatorul 2 - alege un numar: ");
	scanf("%d",&n4);
	x[n4]='0';
	clr();
	print();

//Input 1-3
	printf("Jucatorul 1 - alege un numar: ");
	scanf("%d",&n5);
	x[n5]='X';
	clr();
	print();
	player1();
	if(check1==1) goto label1;
	
//Input 2-3
	printf("Jucatorul 2 - alege un numar: ");
	scanf("%d",&n6);
	x[n6]='0';
	clr();
	print();
	player2();
	if(check1==1) goto label1;

//Input 1-4
	printf("Jucatorul 1 - alege un numar: ");
	scanf("%d",&n7);
	x[n7]='X';
	clr();
	print();
	player1();
	if(check1==1) goto label1;

//Input 2-4
	printf("Jucatorul 2 - alege un numar: ");
	scanf("%d",&n8);
	x[n8]='0';
	clr();
	print();
	player2();
	if(check1==1) goto label1;

//Input 1-5
	printf("Jucatorul 1 - alege un numar: ");
	scanf("%d",&n9);
	x[n9]='X';
	clr();
	print();
	player1();
	if(check1==1) goto label1;

// Label pre-definit pentru terminarea programului
label1: printf("\n--------------------------------------------------------------\nEND OF GAME\n--------------------------------------------------------------\n\n");

// Jucati din nou? [Y/N]: ");
// scanf("	%c\n",rematch);
// if(rematch=='Y' || rematch=='y')
// goto start1;
}