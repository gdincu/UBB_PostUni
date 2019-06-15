import java.io.*;
import java.net.*;

class c
{
   public static void main(String args[]) throws Exception
   {
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte buf[] = new byte[5];
      String s="12345";
      buf=s.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(buf, 5, IPAddress, 5555);
      clientSocket.send(sendPacket);
   }
}