package Chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;

public class Chatting_ChatBox extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JScrollPane Scroll;
	private JTextField textField_input;
	private JTextArea textArea;
	private JButton bt_Send,bt_Exit, bt_Export;
	private PrintWriter pw=null;
	private String userName = "Guest"; //접속한 유저이름
	int usernum; //현재 접속자수
	public static final String SERVER_IP = "192.168.0.2";
	public static final int SERVER_PORT = 9090;
	BufferedReader in;
	OutputStream out;
   
	public static void ChatBoxScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
					Chatting_ChatBox frame = new Chatting_ChatBox();
					Socket socket = new Socket(SERVER_IP, SERVER_PORT);
					frame.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					frame.out=socket.getOutputStream();
					frame.setVisible(true);
					frame.textArea.append(frame.userName + " 가 입장했습니다.\n");
					
					} catch (IOException e) {e.printStackTrace();}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

   public Chatting_ChatBox() {
      setResizable(false);
      setFont(new Font("Arial Black", Font.BOLD, 12));
      setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Desktop\\%B9%AB%C1%F6%B0%B3.jpg"));
      setTitle("InsideOut");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 415, 595);
      
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      textArea = new JTextArea();
      Scroll = new JScrollPane(textArea);
      Scroll.setBounds(0, 0, 409, 512);
      textArea.setFont(new Font("돋움", Font.BOLD, 20));
      textArea.setBackground(new Color(255, 235, 205));
      textArea.setBounds(0, 0, 409, 509);
      contentPane.add(textArea);
      contentPane.add(Scroll);
      
      textField_input = new JTextField();
      textField_input.setFont(new Font("돋움", Font.BOLD, 20));
      textField_input.setBounds(0, 510, 252, 59);
      contentPane.add(textField_input);
      textField_input.setColumns(10);
      
      bt_Send = new JButton("Send");
      bt_Send.setBackground(new Color(245, 255, 250));
      bt_Send.setFont(new Font("Arial Black", Font.PLAIN, 12));
      bt_Send.setBounds(252, 510, 80, 57);
      contentPane.add(bt_Send);
      
      bt_Export = new JButton("Export");
      bt_Export.setFont(new Font("Arial Black", Font.PLAIN, 12));
      bt_Export.setForeground(new Color(0, 0, 0));
      bt_Export.setBackground(new Color(245, 255, 250));
      bt_Export.setBounds(329, 510, 80, 29);
      contentPane.add(bt_Export);
      
      bt_Exit = new JButton("Exit");
      bt_Exit.setBackground(new Color(245, 255, 250));
      bt_Exit.setFont(new Font("Arial Black", Font.PLAIN, 12));
      bt_Exit.setBounds(329, 539, 80, 28);
      contentPane.add(bt_Exit);
      
      textField_input.addActionListener(this);
      bt_Send.addActionListener(this);
      bt_Export.addActionListener(this);
      bt_Exit.addActionListener(this);
      
   }
   
   public void sendMessage() {
		   String data = textField_input.getText();
		   this.textArea.append("Guest : " + data + "\n");
		   this.textField_input.setText("");
		   this.textField_input.requestFocus();

	   }//end
   
   public void export() {
	      String chat = textArea.getText();
	      String path = "C:/Mtest/Chatting.txt";
	      try {
	         File file = new File(path);
	         FileWriter fw = new FileWriter(file, true);
	         BufferedWriter bw = new BufferedWriter(fw);
	         bw.write(chat);
	         textArea.append("        #대화내용이 저장되었어요#\n");
	         System.out.println(path + "파일저장 성공");
	         bw.close(); // 필수 
	      } catch (Exception ex) {
	         System.out.println("저장실패" + ex);
	        }
	   }//end

public void sendExit() {
    System.exit(1);
 }//end


@Override
public void actionPerformed(ActionEvent e) {
   Object ob = e.getSource();
   if(ob==this.textField_input) {
      this.sendMessage();
   }else if(ob==this.bt_Send) {
      this.sendMessage();
   }else if(ob==this.bt_Export) {
      this.export();         
   }else if(ob==this.bt_Exit) {
      this.sendExit();
   }else {}

}//end

}



