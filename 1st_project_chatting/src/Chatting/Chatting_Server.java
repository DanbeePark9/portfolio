package Chatting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chatting_Server extends JFrame implements ActionListener{
	private static final int PORT = 9090;
	JTextArea jta = new JTextArea();
	JTextField jtf = new JTextField();
	
	public static void main(String[] args) throws IOException{
		//기본생성자 호출
		Chatting_Server server = new Chatting_Server();
	}
	
	public Chatting_Server() {
		while(true){
		try {
		//서버 화면 GUI
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("서버 화면");
		
		//소켓 연결
		ServerSocket listener = new ServerSocket(PORT);
		jta.append("[SERVER] Waiting for client connection ... \n");
		Socket client = listener.accept();
		jta.append("[SERVER] Connected to client! \n");
		
		PrintWriter out = new PrintWriter(client.getOutputStream());
		out.println( (new Date()).toString());
		
		System.out.println("[SERVER] Sent date. Closing.");
		client.close();
		listener.close();
		
		} catch (IOException e) {}
		} // while end
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText()+"\n";
		jta.append(msg);
		System.out.println(msg);
		jtf.setText("");
	}
}




