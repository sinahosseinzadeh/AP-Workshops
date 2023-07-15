

import javax.net.ssl.HostnameVerifier;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable {
    private Socket socket;
    private int clientId;
    private StringBuilder clientNote;

    public ClientHandler(Socket socket, int clientId) {
        this.socket = socket;
        this.clientId = clientId;
        clientNote = new StringBuilder();
    }

    @Override
    public void run() {
        try {
            DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutput output = new DataOutputStream(socket.getOutputStream());
            byte[] buffer = new byte[2048];
            String incomeString = null;
            do {
                int read = inputStream.read(buffer);
                incomeString = new String(buffer, 0, read);
                System.out.println("message received "+"(Client "+clientId+") :" + incomeString);
                clientNote.append(incomeString).append(" ");
                output.write(clientNote.toString().getBytes());
                System.out.println("message sent " +"(Client "+clientId+") :" + clientNote.toString());
            } while (!incomeString.equals("over"));
            System.out.println("Communication with client "+clientId+" finished");
        } catch (SocketException e) {
            System.out.println("connection reset "+"->"+" (Client "+clientId+")");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
