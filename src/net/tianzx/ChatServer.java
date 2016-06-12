package net.tianzx;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tianzx on 2016/6/12.
 */
public class ChatServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();
                System.err.print("a client connected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
