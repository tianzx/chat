package net.tianzx;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by tianzx on 2016/6/11.
 */
public class ChatClient extends Frame{

    TextField  tf = new TextField();
    TextArea  ta = new TextArea();

    public static void main(String[] args) {
        new ChatClient().lauchFrame();
    }

    public void lauchFrame(){
        setLocation(400,300);
        this.setSize(300,300);
        this.setVisible(true);
        add(tf,BorderLayout.SOUTH);
        pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        tf.addActionListener(new TFListener());
        add(ta,BorderLayout.NORTH);
        setVisible(true);
        connect();
    }

    private class TFListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = tf.getText().trim();
            ta.setText(text);
        }
    }

    public void connect(){
        try {
            Socket socket = new Socket("127.0.0.1",8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
