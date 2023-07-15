import java.io.IOException;

public class Client3 {
    public static void main(String[] args) {
        try{
            Client client3=new Client();
            client3.sendMessage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
