package javaserver_skkclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JDialog;

public class ChatS{
    Socket sock = null;
    PrintWriter writer;
    JTextArea text;
    JTextField chatText;
    BufferedReader reader;
    JMenuBar mb;
    String name = "Anonymous";
    IDFrame idframe;
    JMenu mID = new JMenu("ID");
    JMenuItem m11= new JMenuItem("ID change");

    public static void main(String [] args){
        ChatS c = new ChatS();
        c.gui();
        
    }
    private void setUpNetworking(){
        
        try{
            sock = new Socket("127.0.0.1", 5000);//port
            System.out.println(sock);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            
            
            System.out.println("networking established");
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public class IncomingReader implements Runnable {
        public void run() {
              String message;            
              try {
                //서버에서 메세지 받기
                while ((message = reader.readLine()) != null) {                       
                   System.out.println("read " + message);
                   //area에 text 표시.
                   text.append(message + "\n");
      
                 } 
              } catch(Exception ex) {ex.printStackTrace();}
          } // close run
      } // close inner class    
   
    
    public void gui(){
        JFrame frame = new JFrame("Simple Chat");
        JPanel panel = new JPanel();
        
        mb = new JMenuBar();
        mb.add(mID);
        mID.add(m11);
        m11.addActionListener(new idListener());
        text = new JTextArea(40,20);
        text.append("익명 채팅방에 접속하셨습니다. 상단 메뉴의 'ID'를 눌러 당신의 ID를 변경하십시오"+"\n");
        text.setLineWrap(true);
        chatText = new JTextField(30);
        JScrollPane scr = new JScrollPane(text);
        scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        text.setEditable(false);
        text.setWrapStyleWord(true);
        JButton input = new JButton("Input");
            frame.setJMenuBar(mb);
            panel.add(chatText);
            panel.add(input);
            frame.getContentPane().add(scr);
            frame.getContentPane().add(BorderLayout.SOUTH, panel);
            frame.setSize(350,300);      
            frame.pack();
            frame.setVisible(true); // frame을 화면에 나타나도록 설정
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 활성화
            
            //전송 버튼 반응
            input.addActionListener(new InputButtonListener());

            setUpNetworking();
            //서버에서 메세지 받아오기
            Thread readerThread = new Thread(new IncomingReader());
            readerThread.start();
            
            //enter 반응
            chatText.addActionListener(new InputListener());
                
        }
    //메세지 전송
    class InputListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        try {
            System.out.println(name);
            writer.print(name+" : ");
            writer.println(chatText.getText());
            writer.flush();
            } catch(Exception ex) {
            ex.printStackTrace();
            }
            chatText.setText("");
            chatText.requestFocus();
    }
    }
    class InputButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            try{
                //writer을 통해 서버로 메세지 전송
                
                writer.print(name+" : ");
                writer.println(chatText.getText());
                writer.flush();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            chatText.setText("");
        }
    }
    //메뉴 누르면 새로운 창 띄우는 listener
    class idListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            System.out.println("Activated");
            if(event.getSource()== m11){
            idframe = new IDFrame();
            }
        }
    }    
    //이름 바꾸는 method. 하지만 되질 않습니다..
    void getName(String str){
        name = str;
    }

}
//메뉴 누르면 나오는 작은 창
class IDFrame extends JDialog{
    //private static final long serialVersionUID = 1L;
    JTextField idt= new JTextField(10);
    JButton ok = new JButton("OK");
    JFrame idf = new JFrame("Change ID");
    JPanel idp = new JPanel();
    ChatS chats = new ChatS();
    public IDFrame(){
        idp.add(idt);
        idp.add(ok);
        idf.getContentPane().add(BorderLayout.CENTER,idp);
        idf.setVisible(true);
        idf.setSize(300,200);
        ok.addActionListener(new IDchangeListener());
        idt.addActionListener(new IDchangeListener());
    }
    //textfield 읽어서 아이디 바꾸기
    class IDchangeListener implements ActionListener{
        String read;
        public void actionPerformed(ActionEvent e){
        read = idt.getText();
        chats.getName(read);
        idf.setVisible(false);
        System.out.println(chats.name);
        }
    }
}
