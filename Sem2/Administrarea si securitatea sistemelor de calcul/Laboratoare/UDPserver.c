#include <netinet/ip.h>
char buf[8] = "xxxxxxxx";
int sfd,r;
struct sockaddr_in soc,csoc;
void main (){
  int clen=sizeof(struct sockaddr_in);
  sfd = socket (AF_INET, SOCK_DGRAM, 0);
  
  soc.sin_family=AF_INET;
  soc.sin_port=htons(7777);
  soc.sin_addr.s_addr=inet_addr("0.0.0.0");
  
  bind(sfd,&soc,sizeof(struct sockaddr_in));
r=recvfrom (sfd,buf,100,0,&csoc,&clen);
buf[r]=0;
printf(" %d %s\n",strlen(buf),buf);
} 