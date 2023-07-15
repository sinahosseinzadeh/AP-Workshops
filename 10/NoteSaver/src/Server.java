import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket;
    private ExecutorService executorPool;

    public static void main(String[] args) {
        Server server=new Server();
        server.runServer();
    }
    public Server(){
        try {
            serverSocket=new ServerSocket(2000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        executorPool= Executors.newCachedThreadPool();
    }

    //run server
    private void runServer(){
        System.out.println("Server started . waiting for clients");
        int counter=1;
        while(counter<4){
            try {
                Socket newClientSocket=serverSocket.accept();
                System.out.println("new Client accepted");
                executorPool.execute(new ClientHandler(newClientSocket,counter));
                counter++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Not accepting more clients");
        executorPool.shutdown();
    }
    // close connection
}
