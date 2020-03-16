import java.net.*;
import java.io.*;
import java.util.*;
class clientdata{
    public static void main(String[] args) throws IOException{
        DatagramSocket ds=new DatagramSocket();
        Scanner in=new Scanner(System.in);
        System.out.print("Enter index of element: ");
        String str=in.nextLine();
        
        byte a[]=str.getBytes();
       
        InetAddress ip=InetAddress.getByName("localhost");
        DatagramPacket dp=new DatagramPacket(a,a.length,ip,4444);

        ds.send(dp);

        ds.close();


        
    }
}