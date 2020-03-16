import java.io.*;
import java.net.*;

class client{
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5555);
        int input[]= {12,53,1,43,54,53,23},output[]=new int[input.length];
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());
        dout.writeInt(input.length);
        for (int i:input){
            dout.writeInt(i);
        }

        for(int i=0;i<input.length;i++){
            output[i] = din.readInt();
        }
        for (int i :output){
            System.out.print(i+" ");
        }
        s.close();



        
    }
}