import java.io.*;
import java.net.*;
import java.util.*;

class server{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5555);
        Socket s = ss.accept();
        DataInputStream din =new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        int l = din.readInt();
        int input[]= new int[l];
        for(int i=0;i<l;i++){
            input[i] = din.readInt();
        }
        Arrays.sort(input);
        for(int i:input){
            dout.writeInt(i);
        }

        ss.close();
        
    }
}