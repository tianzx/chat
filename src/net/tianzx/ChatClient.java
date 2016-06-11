package net.tianzx;

import java.awt.*;

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
        add(ta,BorderLayout.NORTH);
    }
}
