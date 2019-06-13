#include<stdio.h>
#include<string.h>
int main()
{
	int count=0,count_voc,count_con;
	char litera[999], voc[] = { 'a', 'e', 'i', 'o', 'u' }, consoane[999], vocale[999];
	printf("Acest program grupeaza toate caracterele tastate in 2 vectori diferiti - vocale si consoane.\n\nTasteaza [.] pentru a termina input-ul\n\n");
	// printf("Tasteaza o litera: ");
	

	for(count; count<999; count++)
		{
		printf("Tasteaza o litera: ");
		scanf("%c",&litera[count]);
		if (litera[count] == 'a' || litera[count] == 'A' || litera[count] == 'e' || litera[count] == 'E' || litera[count] == 'i' || litera[count] == 'I' || litera[count] =='o' || litera[count]=='O' || litera[count] == 'u' || litera[count] == 'U')
		printf("%c este o vocala.\n", litera[count]);
		
		// if (litera[count] == 'a' || litera[count] == 'A' || litera[count] == 'e' || litera[count] == 'E' || litera[count] == 'i' || litera[count] == 'I' || litera[count] =='o' || litera[count]=='O' || litera[count] == 'u' || litera[count] == 'U')
		// printf("%c este o vocala.\n", litera[count]);
		
		}
		
		
}