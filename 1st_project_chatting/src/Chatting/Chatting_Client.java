package Chatting;

import java.awt.Component;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Chatting_Client implements ActionListener,Runnable{
	//백업
	public static final String SERVER_IP = "192.168.0.2";
	public static final int SERVER_PORT = 9090;
	public static Socket socket;
	public static Vector user;
	
	public Chatting_Client() {
	}
	
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String serverResponse = input.readLine();
		
		JOptionPane.showMessageDialog(null, "서버 연결 성공! (아이피 : "+SERVER_IP+")");
		
		Chatting_Client cc = new Chatting_Client();
		cc.run();
		System.out.println("서버 연결 해제"); 
	}

	public void run() {
		Chatting_Login cl = new Chatting_Login();
		cl.LoginScreen();
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}