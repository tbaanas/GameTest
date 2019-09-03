package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class ClientReader implements GameService {


    public void PlayerChoice(String player, String choice) {



    }


}

class ClientHandler extends Thread {
    private LinkedList<String> listString;
    private BufferedReader bufferedReader;
    private ClientActeptor acteptor;
    private PrintWriter printWriter;


    ClientHandler(Socket client) {
        try {

            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            printWriter = new PrintWriter(client.getOutputStream());
            acteptor = new ClientActeptor();
            listString = new LinkedList<>();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {


        try {
            String line;
            String name = "";
            String choice = "";
            List<String> l = new LinkedList<>();
            String msg = "";
            String msgToChat;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "@,:", true);
                while (st.hasMoreTokens()) {
                    listString.add(st.nextToken());
                }

                for (int i = 0; i < listString.size(); i++) {
                    if (listString.get(i).equalsIgnoreCase("@")) {
                        name = listString.get(i + 1);
                    }
                    if (listString.get(i).equalsIgnoreCase(",")) {
                        choice = listString.get(i + 1);
                    }
                    if (listString.get(i).equalsIgnoreCase(":")) {
                        msg = listString.get(i + 1);
                    }
                }



                msgToChat = "@" + name + ": " + msg;
                msg = name + "," + choice;

                l.add(msg);
                if(l.size()==2){
                    GameServiceImpl.whoWin(l,printWriter,sendToClient);
                }
                ClientWriterImpl.sendMsgChat(msgToChat, printWriter);

            }
        } catch (IOException i) {
            i.printStackTrace();
        }

    }



    ClientHandler sendToClient;

    public void clientMatch(ClientHandler clientHandler) {
        this.sendToClient = clientHandler;

    }
}


