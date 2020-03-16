import java.util.*;
import java.io.*;
import java.net.*;

class chatclient{
    public static void main(String args[]) throws IOException{

        Socket s = new Socket("localhost", 5555);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());
        Scanner in = new Scanner(System.in);
        String str1 = "",str2="";

        while(!str1.equals("bye") && !str2.equals("bye")){
            System.out.print("client:");
            str1 = in.nextLine();           
            dout.writeUTF(str1);
            str2 = din.readUTF();
            System.out.println("Server: "+str2);


        }
        in.close();
        s.close();
    }
}