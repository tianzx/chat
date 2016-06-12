package net.tianzx;

import java.io.DataInputStream;
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
                System.err.println("a client connected");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                System.err.println(dis.readUTF());
                dis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
