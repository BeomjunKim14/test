package java_graphicui;

/**
 * Ex4BorderLayout
 */
import javax.swing.*;
import java.awt.*;
public class Ex4BorderLayout extends JFrame{

    JButton b1 = new JButton("Button 1"), b2 =new JButton("Button 2"), b3 =new JButton("Button 3"), b4 =new JButton("Button 4"),b5 =new JButton("Button 5");
    public Ex4BorderLayout(){
        setTitle("BorderLayout Test");
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(b1,"North");
        pane.add(b2,"South");
        pane.add(b3,"East");
        pane.add(b4,"West");
        pane.add(b5,"Center");
        setBounds(50,50,100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args []){
        JFrame f = new Ex4BorderLayout();
            f.setVisible(true);
    }
}