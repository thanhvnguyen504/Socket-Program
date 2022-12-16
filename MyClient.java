/**
 * 
 * @author Thanh Nguyen
 */

import java.net.*;
import java.io.*;

public class MyClient {

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    
    public MyClient (String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }

        String line = "";
        while(!line.equals("over")) {
            try {
                line = input.readLine(); 
                out.writeUTF(line);
            } catch(Exception eee) {
                System.out.println(eee.getMessage());
            }
        }
        try {
            input.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        MyClient client = new MyClient("localhost", 5000);
    }

}