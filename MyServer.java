import java.net.*;
import java.io.*;

public class MyServer {
    
    private Socket socket = null; 
    private ServerSocket server = null;
    private DataInputStream in = null;

    public MyServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Waiting Client");
            socket = server.accept(); 
            System.out.println("Client accepted");

            // listening
            in = new DataInputStream(               
                new BufferedInputStream(
                    socket.getInputStream()));

            String line = "";
            
            while(!line.equals("over")){
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch(Exception ee){
                    System.out.println(ee.getMessage());
                }  
            }

            System.out.println("Connection Closed");
            socket.close();
            in.close();

        } catch (Exception e) {
            System.out.println("Error here " + e.getMessage()); 
        }
    }

    public static void main(String[] args) {
        MyServer server = new MyServer(5000);
    }

}