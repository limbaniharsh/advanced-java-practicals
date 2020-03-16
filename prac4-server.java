import java.io.*;
import java.net.*;


class server{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5555);
        int number=0;
        while(true){
            Socket s = ss.accept();
            number++;
            System.out.println("client number"+number);
            MultiRequeast client = new MultiRequeast(s, number);
            client.start();

        }
    }
}
class MultiRequeast extends Thread{
    private Socket s;
    private int number;
    MultiRequeast(Socket in, int n){
        s= in;
        number = n;
    }
    public void run(){
    try{ 
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        String str1 = din.readUTF();
        StringBuilder str2 = new StringBuilder(str1);
        String str = str2.reverse().toString();
        dout.writeUTF(str);
        s.close();

    }catch(Exception e){

    }

    }
}