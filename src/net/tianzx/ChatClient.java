package net.tianzx;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by tianzx on 2016/6/11.
 */
public class ChatClient extends Frame{

    TextField  tf = new TextField();
    TextArea  ta = new TextArea();
    Socket socket =null;
    DataOutputStream dos = null;
    public static void main(String[] args) {
        new ChatClient().lauchFrame();
    }

    public void lauchFrame(){
        setLocation(400,300);
        this.setSize(300,300);
        this.setVisible(true);
        add(tf,BorderLayout.SOUTH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disConnect();
                super.windowClosing(e);
                System.exit(0);
            }
        });
        tf.addActionListener(new TFListener());
        add(ta,BorderLayout.NORTH);
        pack();
        setVisible(true);

        connect();
    }

    private class TFListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = tf.getText().trim();
            ta.setText(text);
            tf.setText("");

            try {
                dos.writeUTF(text);
                dos.flush();
//                dos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void connect(){

        try {
            socket = new Socket("127.0.0.1",8888);
            dos =  new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disConnect() {
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
