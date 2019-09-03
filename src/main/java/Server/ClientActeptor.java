package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ClientActeptor {

    public static void accept(ServerSocket serverSocket) throws IOException {

        ClientHandler clientFirst = new ClientHandler(serverSocket.accept());
        ClientHandler clientSecond = new ClientHandler(serverSocket.accept());
        clientFirst.clientMatch(clientSecond);
        clientSecond.clientMatch(clientFirst);
        clientFirst.start();
        clientSecond.start();
    }

}
