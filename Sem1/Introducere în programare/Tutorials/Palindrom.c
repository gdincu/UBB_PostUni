   // for (i=0,j=strlen(s)-1 ; i<j ; ++i, --j) {
   // if (s[i] != s[j]) return 0; // Not palindrome}

#include <stdio.h>
#include <string.h>

int main()
{
    char string[10], revString[10];
    printf("Enter string for reversing it...\n");
    scanf("%s", string);

    int stringLength = strlen(string);

    for(int i = 0; string[i] != '\0'; i++, stringLength--)
    {
    revString[i] = string[stringLength - 1];
    }

    if(strcmp(string,  revString) == 0)
         printf("Given string is pelindrom\n");
    else
         printf("Given string is not pelindrom\n");
}