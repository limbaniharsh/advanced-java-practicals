import java.io.*;
import java.net.*;
import java.util.*;

class server{
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5555);
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket din,dout;
        byte b[]=new byte[1024];
        din = new DatagramPacket(b, 1024);
        ds.receive(din);
        ByteArrayInputStream bin = new ByteArrayInputStream(din.getData());
        DataInputStream datain = new DataInputStream(bin);
        int l =datain.readInt();
        int input[]=new int[l];
        for(int i =0;i<l;i++){
            input[i]=datain.readInt();
        }
        Arrays.sort(input);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStream data = new DataOutputStream(bout);

        for (int i : input) {
            data.writeInt(i);
        }
        byte b1[] = bout.toByteArray();
        dout = new DatagramPacket(b1, b1.length, ip, 6667);
        ds.send(dout);
        ds.close();
    }
}
