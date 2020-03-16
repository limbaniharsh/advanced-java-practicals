import java.io.*;
import java.net.*;


class server{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5555);
        Socket s = ss.accept();
        ObjectInputStream objin = new ObjectInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        File f = (File)objin.readObject();
        FileInputStream fin =new FileInputStream(f);
        byte b[] = new byte[fin.available()];
        fin.read(b);
        String str = new String(b);
        int word = str.split(" |\\n").length;
        int lines = str.split("\\n").length;
        int sent = str.split("[.?:!]+").length;
        int chr = str.length();
        String strout = "Number Of words: "+word +"\nNumber Of lines: "+lines+"\nNumber Of sentences: "
                        +sent+"\nNumber Of characters: "+chr;
        dout.writeUTF(strout);        
        ss.close();
        fin.close();
        
    }
}