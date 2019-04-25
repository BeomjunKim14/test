package java_graphicui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java_graphicui.*; //본인 클래스 import 사용 권장.

public class Calculator /*implements ActionListener*/ {
 JFrame frame; // JFrame 변수 선언
 JTextField textfieldUpper;
 JTextField textField;
 JPanel panel1; // Border
 JPanel panelUpper; // Border
 GridLayout grid;
 JButton JBu;
 String[] strGrid = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "+", "=" };

 ArrayList<Integer> ee = new ArrayList<Integer>(); // 값들 누적으로 받기.
 ArrayList<String> store = new ArrayList<String>(); // 연산자 누적으로 저장.

 public Calculator() {
  frame = new JFrame("계산기");
  panel1 = new JPanel();
  panelUpper = new JPanel();
  textField = new JTextField("0"); // 초기값 아무것도 안보이게
  textfieldUpper = new JTextField(""); // 연산자만 보이는 텍스트
 }// 생성자 calc()

 public void gui() {
  textField.setHorizontalAlignment(JTextField.RIGHT); // 우측정렬
  textField.setEditable(false); // 텍스트필드창에 텍스트쓰지못하게 잠금

  textfieldUpper.setHorizontalAlignment(JTextField.RIGHT); // 우측정렬
  textfieldUpper.setEditable(false); // 텍스트필드창에 텍스트쓰지못하게 잠금

  panelUpper.setLayout(new BorderLayout()); // 레이아웃 설정.
  panelUpper.add(BorderLayout.NORTH, textfieldUpper); // 패널에 텍스트필드를 두개 붙임.
  panelUpper.add(BorderLayout.CENTER, textField);

  panel1.setLayout(new GridLayout(4, 3, 8, 8)); // 그리드 레이아웃 속성설정
  panel1.setBackground(new Color(222, 232, 244)); // 패널색상

  for (int i = 0; i < strGrid.length; i++) {
   JBu = new JButton(strGrid[i]); // 버튼 생성
 //JBu.addActionListener(ActionListener);// 각 버튼마다 리스너 붙이기
   //JBu.setBackground(new Color(241, 244, 249)); // 버튼 집어넣기
   panel1.add(JBu); // 패널에 각각의 버튼들 붙이기
  }

  frame.add(BorderLayout.NORTH, panelUpper);
  frame.add(BorderLayout.CENTER, panel1); // 텍스트필드 북쪽에
  

  frame.setResizable(false); // 창 크기 변경 x
  frame.setSize(220, 310); // frame 의 크기
  frame.setVisible(true); // frame을 화면에 나타나도록 설정
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 활성화
 }// gui()

 
 public static void main(String[] args) {
  Calculator cal = new Calculator();
  cal.gui();
  //Ex3Button ex3 = new Ex3Button();
 }
}