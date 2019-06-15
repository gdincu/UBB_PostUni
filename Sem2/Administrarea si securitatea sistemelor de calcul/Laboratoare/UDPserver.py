import socket
s=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)  
s.bind(("0.0.0.0",5555))        

# Trimite inapoi lungimea cuvantului primit
# while True:
	# buff,addr=s.recvfrom(30)                           
	# print ("Received : ",buff)
	# trimis=str(len(buff))
	# s.sendto(trimis, addr)
	
# Trimite inapoi numarul vocalelor
while True:
	buff,addr=s.recvfrom(30)                           
	print ("Received : ",buff)
	L = list(buff)
	count=0
	for x in L
	s.sendto(x, addr)
	# if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u') count++
	# trimis=str(count)
	# s.sendto(trimis, addr)