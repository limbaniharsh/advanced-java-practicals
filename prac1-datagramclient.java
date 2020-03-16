import java.io.*;
import java.net.*;
import java.util.*;


class client{
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(6666);
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket  dout, din;
        Scanner in =new Scanner(System.in);
        String str1="",str2="";
        byte b1[],b2[] = new byte[1024];

        while(!str1.equals("bye") && !str2.equals("bye"))
        {
        System.out.print("client:");
        str1 = in.nextLine();
        b1 = str1.getBytes();
        dout = new DatagramPacket(b1, b1.length, ip, 5555);
        ds.send(dout);
        din = new DatagramPacket(b2, 1024);
        ds.receive(din);
        str2 = new String(din.getData(),0, din.getLength());
        System.out.println("server:"+str2);
    
        } 
        in.close();
        ds.close();
        
    }
}