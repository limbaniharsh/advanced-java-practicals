import java.io.*;
import java.net.*;
import java.util.*;

class client{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5555);
        ObjectOutputStream objout = new ObjectOutputStream(s.getOutputStream());
        File fin = new File("test.txt");
        DataInputStream din = new DataInputStream(s.getInputStream());

        objout.writeObject(fin);
        String str = din.readUTF();
        System.out.println(str);
        s.close();

        
    }
}