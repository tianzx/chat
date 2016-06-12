package net.tianzx;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
    }

    private class TFListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = tf.getText().trim();
            ta.setText(text);
        }
    }
}
