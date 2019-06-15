<?php
	$s=socket_create(AF_INET,SOCK_DGRAM,0);              		//create a UDP socket
	socket_bind($s,'0.0.0.0',5555);                      		//bind on all interfaces on port 5555
	while(true){
	
	socket_recvfrom($s,$b,30,0,$client_ip,$client_port); 		//read max 20 bytes from socket $s into buffer $b
 	echo "Received: ".$b." from IP= ".$client_ip.":".$client_port;
	for($i=0; $i<strlen($b); $i++){
		if(is_numeric ($b))
			$c="it is a number";
		else
			$c="it is a letter";
			if(is
	}
 	socket_sendto($s,$c,100,0,$client_ip, " ".$client_port);
}
?>