import java.io.IOException;

public class Client2 {
    public static void main(String[] args) {
        try{
            Client client2=new Client();
            client2.sendMessage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
