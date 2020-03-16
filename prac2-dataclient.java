import java.io.*;
import java.net.*;


class client{
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(6666);
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket dout, din;
        File fin = new File("test.txt");
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream objout = new ObjectOutputStream(bout);
        objout.writeObject(fin);
        byte b[] = bout.toByteArray(),b2[]=new byte[1024];
        dout=new DatagramPacket(b, b.length, ip, 5555);
        ds.send(dout);
        din = new DatagramPacket(b2, 1024);
        ds.receive(din);
        String str = new String(din.getData(),0,din.getLength());
        System.out.println(str);
        ds.close();

        

        
    }
}