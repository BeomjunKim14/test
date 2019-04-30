package java_graphicui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java_graphicui.*; //본인 클래스 import 사용 권장.

public class Calculator implements ActionListener {
 JFrame frame; // JFrame 변수 선언
 JTextField textField;
 JPanel panel1; // Border
 JPanel panelUpper; // Border
 GridLayout grid;
 JButton button;
 String[] strGrid = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "+", "=" };

 ArrayList<Integer> value = new ArrayList<Integer>(); // 값들 누적으로 받기.
 ArrayList<String> store = new ArrayList<String>(); // 연산자 누적으로 저장.

 String first="";
 String result = "";
 public Calculator() {
  frame = new JFrame("Calculator");
  panel1 = new JPanel();
  panelUpper = new JPanel();
  textField = new JTextField("0"); // 초기값 아무것도 안보이게
 }// 생성자 calc()

 public void gui() {
  textField.setHorizontalAlignment(JTextField.RIGHT); // 우측정렬
  textField.setEditable(false); // 텍스트필드창에 텍스트쓰지못하게 잠금

  panelUpper.setLayout(new BorderLayout()); // 레이아웃 설정.
  panelUpper.add(BorderLayout.CENTER, textField); // 윗패널에 필드하나 생성
  panelUpper.setSize(80,100); // 작동을 안합니다..

  panel1.setLayout(new GridLayout(4, 3, 6, 6)); // 그리드 레이아웃 속성설정
  panel1.setBackground(Color.white); // 패널색상

  for (int i = 0; i < strGrid.length; i++) {
   button = new JButton(strGrid[i]); // 버튼 생성
   button.addActionListener(this);// 각 버튼마다 리스너 붙이기
   button.setBackground(Color.GRAY); // 버튼 색상
   button.setFont(new Font("Sans-serif",3,15)); //폰트설정,굵기,크기
   panel1.add(button); // 패널에 각각의 버튼들 붙이기
  }

  frame.add(BorderLayout.NORTH, panelUpper);// 텍스트필드 북쪽에
  frame.add(BorderLayout.CENTER, panel1);   

  frame.setResizable(false); // 창 크기 변경 x
  frame.setSize(210, 310); // frame 의 크기
  frame.setVisible(true); // frame을 화면에 나타나도록 설정
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 활성화
 }// gui()
public void actionPerformed(ActionEvent e){
  String str = e.getActionCommand(); // 문자열로 이벤트불러옴
  String read; // 텍스트필드에 있는 텍스트 읽기용도

  try {

   if (str != "/" && str != "*" && str != "-" && str != "+" && str != "C" && str != "=") { //숫자일 경우
    textField.setText(first); // 0을지우고 숫자누적하기위해 필요.
    textField.getText(); // 누적 출력

    read = textField.getText(); // 텍스트에 있는값 불러옴.
    first = read + str; // 스트링은 더하면 뒤에 붙어서 2자리 이상도 가능해진다.
    textField.setText(first); // 누적 저장
    textField.getText(); // 누적 출력
   }

   if (str == "/" || str == "*" || str == "-" || str == "+" || str == "=") { //연산자일 경우
    textField.setText(str); // 연산자 기호 저장
    textField.getText(); // 연산자 기호 출력

    value.add(Integer.parseInt(first)); // 연산하려는 값 하나씩 ArrayList에 저장
    first = ""; // 다시 누적하도록 초기화

    store.add(str); // 연산자 ArrayList에 저장
   }

   // 연산기호 "=" 결과값 눌렀을때.
   if (str == "=") {
    int sumV = 0; //변수 선언
    sumV = value.get(0); // value ArrayList의 최초 시작값을 받고 시작

    for (int a = 0, next = 1; a < value.size(); a++, next++) { // ArrayList 크기만큼 반복, 현재순서와 다음순서 변수 선언
     int operatorN = store.size(); // 연산자 누적 횟수 저장
     if (operatorN > 0) { // 연산자 누적 모두 사용할때까지 반복.
      operatorN--;

      if (store.get(a) == "+") { // 연산자 + 일때
       sumV = sumV + value.get(next); //다음순서 더하기
      } else if (store.get(a) == "-") { 
       sumV = sumV - value.get(next);
      } else if (store.get(a) == "*") {
       sumV = sumV * value.get(next);
      } else if (store.get(a) == "/") {
       try {
        sumV = sumV / value.get(next);
       } catch (Exception ex) { // 나눗셈은 0으로 나눌때 예외발생한다.
        sumV = 0; // 에러발생시 0으로 출력.
       }
      }
     }
    } 
    result = sumV + ""; // 총 결과값
    textField.setText(result); // 결과값 저장
    textField.getText(); // 결과출력
   } // if

   // 모든 값 초기화 시키고 다시 연산.
   if (str == "C") {
    first = "";
    textField.setText("0"); // 텍스트창 내용 지우고 0출력
    textField.getText();

    value.clear(); // 모든 요소들 제거
    store.clear(); // 모든 요소들 제거
   }

  } catch (Exception ex) {
   textField.setText("Error"); // 텍스트창 내용 전부 지우기
   textField.getText();
  }

 }// actionPerformed()

 
 public static void main(String[] args) {
  Calculator cal = new Calculator();
  cal.gui();
  
 }
}