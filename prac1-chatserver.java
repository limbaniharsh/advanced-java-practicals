import java.io.*;
import java.net.*;
import java.util.*;

class Chatserver{
    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(5555);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Scanner in = new Scanner(System.in);
        String str1="";
        String str2="";
        
        while(!str1.equals("bye") && !str2.equals("bye"))
        {
        str1 = din.readUTF();
        System.out.println("client: "+str1);
        System.out.print("server:");
        str2 = in.nextLine();
        dout.writeUTF(str2);
        }     
        in.close();
        ss.close();

    }
}