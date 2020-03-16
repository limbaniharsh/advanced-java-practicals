import java.io.*;
import java.net.*;

class client{
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(6667);
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket din,dout;
        int input[]= {12,53,1,43,54,53,23},output[]=new int[input.length];
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStream data = new DataOutputStream(bout);
        data.writeInt(input.length);
        for (int i: input){
            data.writeInt(i);    
        }
        byte b[] = bout.toByteArray();
        dout = new DatagramPacket(b, b.length, ip, 5555);
        ds.send(dout);
        byte b1[]=new byte[1024];
        din = new DatagramPacket(b1, 1024);
        ds.receive(din);
        ByteArrayInputStream bin = new ByteArrayInputStream(din.getData());
        DataInputStream datain = new DataInputStream(bin);
        for (int i = 0; i < input.length; i++) {
            System.out.print(datain.readInt()+" ");
        }
    }
}