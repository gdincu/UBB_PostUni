<?php
$s=socket_create(AF_INET,SOCK_DGRAM,0);            //create a UDP socket
socket_sendto($s,f(4,5,6),3,0,"192.168.43.60",5555);      //send 3 bytes to the server
socket_recvfrom($s,$b,10,0,$serv_ip,$serv_port);   //read max 10 bytes from socket $s into buffer $b
socket_bind
echo "Received: ".$b." from IP=".$serv_ip.":".$serv_port;
?>