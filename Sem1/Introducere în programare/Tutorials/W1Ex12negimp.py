x=1
suma=0

while (x != 0):
	x=input()
	if(x%2!=0 and x<0):
		suma+=x

print ("Suma = " + str(suma))