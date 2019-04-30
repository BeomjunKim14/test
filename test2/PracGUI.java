package test2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PracGUI implements ActionListener{
static int numClicks;
final String labeling = "plus and minus";
JLabel label = new JLabel(labeling);
    public void design(){
        
        JFrame frame = new JFrame("Practice G");
        JButton button1 = new JButton("+1");
        button1.setBackground(Color.red);
        JButton button2 = new JButton("-1");
        button2.setBackground(Color.red);
        button1.addActionListener(this);
        button2.addActionListener(event -> {numClicks-=1; label.setText(""+numClicks);});
        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);// 여기까지만 하면 pane이 없으므로 표시 x
        frame.getContentPane().add(panel);

        panel.setBackground(Color.darkGray);
        panel.add(BorderLayout.SOUTH,label);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.pack();
    } 
        
    public void actionPerformed(ActionEvent event){
        label.setText(""+ ++numClicks);
    }
    public static void main(String [] args){
        PracGUI g = new PracGUI();
        g.design();
    }
}