import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Client() throws IOException{
            socket=new Socket("127.0.0.1",2000);
            System.out.println("Connected to Server ...");
            inputStream=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            outputStream=new DataOutputStream(socket.getOutputStream());

    }
    public void sendMessage(){
        System.out.println("write message");
        Scanner scanner=new Scanner(System.in);
        String message=null;
        byte[] buffer=new byte[2048];
        try{
            do{

                    message=scanner.nextLine();
                    outputStream.write(message.getBytes());
                    System.out.println("message sent: "+ message);
                    int read=inputStream.read(buffer);
                    System.out.println("message received : "+new String(buffer,0,read));

            }while(!message.equals("over"));
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("all message sent.");

    }
}
