package java_gui;

import javax.swing.*;
public class helloworld {

    public static void main(String[] args){
        JFrame frame = new JFrame("Hello World");
        final JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}