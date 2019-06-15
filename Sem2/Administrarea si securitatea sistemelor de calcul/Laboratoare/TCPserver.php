<?php

$s=socket_create(AF_INET,SOCK_STREAM,0);
socket_bind($s,"0.0.0.0",9999);
socket_listen($s);
$cs=socket_accept($s);
socket_send($cs,"Ionut",5,0);
?>