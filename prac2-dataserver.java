import java.io.*;
import java.net.*;

class server{
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5555);
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket din,dout;
        ByteArrayInputStream bin;
        ObjectInputStream objin ;
        byte b1[]=new byte[1024];
        din = new DatagramPacket(b1, 1024);
        ds.receive(din);
        bin = new ByteArrayInputStream(din.getData());
        objin = new ObjectInputStream(bin);
        File f = (File) objin.readObject();
        FileInputStream fin = new FileInputStream(f);
        byte b[] = new byte[fin.available()];
        fin.read(b);
        String str = new String(b);
        int word = str.split(" |\\n").length;
        int lines = str.split("\\n").length;
        int sent = str.split("[.?:!]+").length;
        int chr = str.length();
        String strout = "Number Of words: " + word + "\nNumber Of lines: " + lines + "\nNumber Of sentences: " + sent
                + "\nNumber Of characters: " + chr; 
        byte out[]=strout.getBytes();
        dout = new DatagramPacket(out,out.length,ip,6666 );       
        ds.send(dout);
        ds.close();
    }
}