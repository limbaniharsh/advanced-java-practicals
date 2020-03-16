import java.net.*;
import java.io.*;

class serverdata{
    public static void main(String[] args) throws IOException {

        DatagramSocket ds=new DatagramSocket(4444);
        String str[]={"meet","harsh","bhavik","mosam","mitul"};
        byte a[]=new byte[1024];

        DatagramPacket dp =new DatagramPacket(a,1024);

        ds.receive(dp);
        String s=new String(dp.getData(),0,dp.getLength());
    
       int i=Integer.parseInt(s);
    
        System.out.println(str[i-1]);
        // for(int i:b){
        // System.out.println(i);}
        ds.close();
        
    }
}