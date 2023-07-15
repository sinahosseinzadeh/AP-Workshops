import java.io.IOException;

public class Client1 {
    public static void main(String[] args) {
           try{
               Client client1=new Client();
               client1.sendMessage();
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
    }
}
