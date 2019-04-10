package java_gui;
import javax.swing.*;
import java.awt.event.*;

public class Ex3Button implements ActionListener{
    private static String labelPrefix = "Number of button clicks: ";
    private int numClicks = 0;
    JLabel label = new JLabel(labelPrefix + "0   ");
    public void go(String title){
        JFrame frame = new JFrame(title);
        JButton button = new JButton("Swing button!");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        label.setText(labelPrefix + ++numClicks);
    }
    public static void main(String[] args) {
        Ex3Button button = new Ex3Button();
        button.go("Event handling");    
    }
}