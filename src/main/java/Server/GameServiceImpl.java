package Server;

import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

public class GameServiceImpl implements ClientWriter {

    GameServiceImpl(ClientReader clientReader) {

    }

    public void sendUpdates() {


    }

    static void whoWin(List<String> list, PrintWriter printWriter,ClientHandler SendToClient) {
        String player1;
        String player2;
        String namePlayerOne;
        String choicePlayerOne;
        String namePlayerTwo;
        String choicePlayerTwo;
        StringTokenizer st;
        player1 = list.get(0);
        player2 = list.get(1);

        st = new StringTokenizer(player1, ",");
        namePlayerOne = st.nextToken();
        choicePlayerOne = st.nextToken();
        st = new StringTokenizer(player2, ",");
        namePlayerTwo = st.nextToken();
        choicePlayerTwo = st.nextToken();

        if (choicePlayerOne.equalsIgnoreCase(choicePlayerTwo)) {
            ClientWriterImpl.sendDraw(printWriter,SendToClient);
        } else if (choicePlayerOne.equalsIgnoreCase("k") && choicePlayerTwo.equalsIgnoreCase("n")) {
            ClientWriterImpl.sendWin(printWriter, namePlayerOne,SendToClient);
        } else if (choicePlayerOne.equalsIgnoreCase("p") && choicePlayerTwo.equalsIgnoreCase("k")) {
            ClientWriterImpl.sendWin(printWriter, namePlayerOne,SendToClient);
        } else if (choicePlayerOne.equalsIgnoreCase("n") && choicePlayerTwo.equalsIgnoreCase("p")) {
            ClientWriterImpl.sendWin(printWriter, namePlayerOne,SendToClient);
        }else{
            ClientWriterImpl.sendWin(printWriter, namePlayerTwo,SendToClient);

        }


    }


}
