package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        Server s = new Server();
        s.work();

    }


    private void work() throws IOException {
        ServerSocket serverSocket = new ServerSocket(54345);
        ClientActeptor.accept(serverSocket);;

    }

}
