package com.zach;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewClass extends JFrame {

    public NewClass() {
        init();
    }

    public void init() {

    }


    public static void main(String arg[]) {
        JFrame jFrame = new JFrame();
        JPanel pan1 = new JPanel();
        JButton jb1 = new JButton("one");
        JButton jb2 = new JButton("two");
        jb1.setBounds(new Rectangle(50, 10));
        jb2.setBounds(new Rectangle(50, 10));


        pan1.setLayout(new FlowLayout());
        pan1.add(jb1);
        pan1.add(jb2);
        pan1.setBackground(Color.BLACK);


        jFrame.setBounds(0, 0, 400, 400);
        jFrame.setVisible(true);
    }
}