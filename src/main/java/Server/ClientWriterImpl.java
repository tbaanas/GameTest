package Server;

import java.io.PrintWriter;



public class ClientWriterImpl {



public static void sendMsgChat(String msg,PrintWriter printWriter){
        while (!msg.isEmpty()){
            printWriter.println(msg);
            printWriter.flush();
        }

}

    static void sendWin(PrintWriter printWriter,String name,ClientHandler SendToClient) {

        printWriter.println(name+"-"+"Win!");
        printWriter.flush();

    }

    static void sendDraw(PrintWriter printWriter,ClientHandler SendToClient) {
        printWriter.println("DRAW");
        printWriter.flush();

    }





}
