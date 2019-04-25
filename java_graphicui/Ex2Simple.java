package java_graphicui;

import javax.swing.*;
public class Ex2Simple {

    public static void main(String[] args){
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        JPanel panel = new JPanel();
        panel.add(button);
        //패널 추가
        frame.getContentPane().add(panel);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}