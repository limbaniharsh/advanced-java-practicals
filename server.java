import java.net.*;
import java.io.*;
import java.util.*;

class server{
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(5555);
        Socket s=ss.accept();
        DataInputStream din =new DataInputStream(s.getInputStream());
        DataOutputStream dout =new DataOutputStream(s.getOutputStream());
        int a[]=new int[10];
        for(int i=0;i<10;i++){
            a[i]=din.readInt();
        }
       
        Arrays.sort(a);
        dout.writeInt(a[a.length-2]);

        ss.close();

    }
}