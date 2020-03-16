import java.io.*;
import java.net.*;


class client{
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("localhost", 5555);
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        DataInputStream din=new DataInputStream(s.getInputStream());
        int a[]={4,2,6,5,4,34,56,23,14,67};
        
        for(int b:a){
        dout.writeInt(b);
        }
        int max=din.readInt();
        System.out.println("Second Max Number: "+max);

        s.close();
    }
}