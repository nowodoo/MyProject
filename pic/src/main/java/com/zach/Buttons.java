package com.zach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Hello world!
 */
public class Buttons {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("button面板");

        Container contentPane = jFrame.getContentPane();


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(Color.BLACK);


        //--------------------------------------------------
        int verticalRowNum = 101;
        int horizontallRowNum = 100;
        //表示行
        for (int i = 0; i < verticalRowNum; i++) {
            //表示列
            for (int j = 0; j < horizontallRowNum; j++) {
                int x = j;
                int y = verticalRowNum - i - 1;

                JButton jButton = new JButton("("+x+","+y+")");
                jButton.setPreferredSize(new Dimension(5,5));
                jButton.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                    }
                    public void mousePressed(MouseEvent e) {
                        MouseStatus.mousePress = 1;
                        System.out.println("pressed!");
                    }
                    public void mouseReleased(MouseEvent e) {
                        MouseStatus.mousePress = 0;
                        System.out.println("released!");
                    }
                    public void mouseEntered(MouseEvent e) {
                        if (1 == MouseStatus.mousePress) {
                            MouseStatus.xys.add(((JButton)e.getSource()).getText());
                        }
                    }
                    public void mouseExited(MouseEvent e) {
                    }
                });
                jPanel.add(jButton);
            }
        }


        //--------------------------------------------------
        jPanel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }
            public void mousePressed(MouseEvent e) {
                MouseStatus.mousePress = 1;
                System.out.println("pressed!");
            }
            public void mouseReleased(MouseEvent e) {
                MouseStatus.mousePress = 0;
                System.out.println("released!");
                System.out.println(MouseStatus.xys);
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
        });




        contentPane.add(jPanel, FlowLayout.LEFT);
        jFrame.setTitle("生成坐标点");
        jFrame.setSize(1000, 1000);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
