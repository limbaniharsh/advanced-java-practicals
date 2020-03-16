import java.net.*;
import java.io.*;

class client{
    public static void main(String[] args) throws Exception {
        
        Socket s = new Socket("localhost",5555);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        String str1="hello how are you";
        dout.writeUTF(str1);
        String rev= din.readUTF();
        System.out.println(rev);
        
        
    }
}