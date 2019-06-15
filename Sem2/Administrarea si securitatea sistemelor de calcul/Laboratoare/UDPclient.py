import socket
bufferSize = 1024
s=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
s.sendto("333",("172.20.10.3",5555))                 
msgFromServer = s.recvfrom(bufferSize)
print(msgFromServer)