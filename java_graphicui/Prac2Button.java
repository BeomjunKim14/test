/**
 * Prac2Button
 */
package java_graphicui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prac2Button {

    JFrame frame;
    JLabel label;
    int x = 10;
    int y = 10;
    public static void main(String [] args){
        Prac2Button gui = new Prac2Button();
        gui.go();
    }
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300,300);
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
    

class LabelListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        label.setText("Ouch!");
    }
}
class ColorListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        frame.repaint();
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