package javaserver_skkclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lambda {

    JFrame frame;
    JLabel label;
    private static String labelPrefix = "Clicks : ";
    int x = 10;
    int y = 10;
    int clickCounter = 0;
    public static void main(String [] args){
        Lambda gui = new Lambda();
        gui.go();
    }
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(e -> {
            clickCounter++; 
            label.setText(labelPrefix+ ((clickCounter%2 ==0) ? clickCounter : clickCounter * 100));
        });

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(e -> frame.repaint());

        label = new JLabel("label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(420,300);
        frame.setVisible(true);
        for (int i = 0; i < 200; i++){
            x++;
            y++;
            drawPanel.repaint();

            try{
                Thread.sleep(50); // for문이 돌아가는 주기 설정.
            }catch(Exception ex){}
        }
    }
    class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(), this.getHeight());
    
            g.setColor(Color.green);
            g.fillOval(x,y,40,40);
            }
        }
    }