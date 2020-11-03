package Chatting;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class Chatting_signUp implements ActionListener{
    
    
    private JFrame frame;
    private JPanel contentPane;
    private JTextField textField_id;
    private JPasswordField PasswordField_pw;
    private JButton btn_save;
    private JLabel Label_SignUp, Label_id, Label_gender, Label_pw, lblCharacter;
    private JComboBox Gender;
    private JComboBox ComChar;
    
    
    public static void SignupScreen()  {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Chatting_signUp JF = new Chatting_signUp();
                    JF.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Chatting_signUp() {
       frame = new JFrame();
        frame.setBounds(100, 100, 800, 500);
        contentPane = new ImagePanel(new ImageIcon("C:\\Mtest\\Chatting Project\\signupBack.jpg").getImage());
        //contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setLayout(null);
        frame.setResizable(false);
        
        //라벨
        Label_SignUp = new JLabel("Sign Up");
        Label_SignUp.setHorizontalAlignment(SwingConstants.CENTER);
        Label_SignUp.setForeground(new Color(255, 255, 153));
        Label_SignUp.setBounds(50, 30, 200, 50);
        Label_SignUp.setFont(new Font("Arial Black", Font.BOLD, 30));
        contentPane.add(Label_SignUp);
        
        Label_id = new JLabel("ID");
        Label_id.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        Label_id.setForeground(new Color(255, 255, 204));
        Label_id.setBounds(25, 90, 100, 30);
        contentPane.add(Label_id);
        
        Label_gender = new JLabel("Gender");
        Label_gender.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        Label_gender.setForeground(new Color(255, 255, 204));
        Label_gender.setBounds(25, 170, 100, 30);
        contentPane.add(Label_gender);
        
        Label_pw = new JLabel("Password");
        Label_pw.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        Label_pw.setForeground(new Color(255, 255, 204));
        Label_pw.setBounds(25, 130, 100, 30);
        contentPane.add(Label_pw);
        
        //ID
        textField_id = new JTextField();
        textField_id.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
        textField_id.setBounds(150, 96, 120, 20);
        contentPane.add(textField_id);
        textField_id.setColumns(10);
        //ID data saving
        String ID = textField_id.getText();
        
        
        //PW
        PasswordField_pw = new JPasswordField();
        PasswordField_pw.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
        PasswordField_pw.setBounds(150, 135, 120, 20);
        contentPane.add(PasswordField_pw);
        PasswordField_pw.setColumns(10);
        //PW data saving
        String PW = PasswordField_pw.getText();
        
        //그룹지정자=중복선택 불가능
        ButtonGroup mf = new ButtonGroup();
        
        //저장버튼
        btn_save = new JButton("Save");
        btn_save.setBackground(new Color(255, 255, 153));
        btn_save.setForeground(new Color(0, 0, 51));
        btn_save.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        btn_save.setBounds(85, 390, 120, 35);
        contentPane.add(btn_save);
        btn_save.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                btn_save.setBackground(new Color(186, 85, 211));
                btn_save.setForeground(new Color(255, 255, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                btn_save.setBackground(new Color(255, 255, 153));
                btn_save.setForeground(new Color(0, 0, 51));
            }
    });
        
        //Save를 누르면 정보 저장
        btn_save.addActionListener(this);
        
        //캐릭터선택=========================================
        selChar();
        
        lblCharacter = new JLabel("Character");
        lblCharacter.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        lblCharacter.setForeground(new Color(255, 255, 204));
        lblCharacter.setBounds(25, 210, 100, 30);
        contentPane.add(lblCharacter);
        
        Gender = new JComboBox();
        Gender.setBackground(new Color(255, 255, 204));
        Gender.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
        Gender.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male"}));
        Gender.setBounds(150, 180, 80, 20);
        contentPane.add(Gender);
        
    }
    
    
    
    public void selChar() {
        String[] Character = {"Joy","Anger","Disgust","Sadness","Fear"};
        ImageIcon[] images = {new ImageIcon("C:\\Mtest\\Chatting Project\\joi_1.jpg"), 
                                                    new ImageIcon("C:\\Mtest\\Chatting Project\\anger.jpg"),
                                                    new ImageIcon("C:\\Mtest\\Chatting Project\\disgust.jpg"),
                                                    new ImageIcon("C:\\Mtest\\Chatting Project\\sadness.jpg"),
                                                    new ImageIcon("C:\\Mtest\\Chatting Project\\fear.jpg"),};
        JLabel imgLabel = new JLabel(images[0]);
        imgLabel.setBounds(150, 260, 100, 100);
        ComChar = new JComboBox(Character);
        ComChar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
        ComChar.setBackground(new Color(255, 255, 204));
        Container c = frame.getContentPane();
        ComChar.setBounds(150, 220, 80, 20);
        c.add(ComChar);
        c.add(imgLabel);
        ComChar.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int index = cb.getSelectedIndex();
                imgLabel.setIcon(images[index]);                
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        //Object ob = e.getSource();
        
        try {
           boolean fileExists = new File("./clientData.csv").exists();
           FileWriter fw = new FileWriter("./clientData.csv", true);
           if(!fileExists){
            fw.append("ID, PASS, CHARACTER, GENDAR\n");
         }
           

                String idTxt = textField_id.getText();
                String passTxt = PasswordField_pw.getText();
                String characterTxt = (String) ComChar.getSelectedItem();
                String getderTxt    = (String) Gender.getSelectedItem();
                
                fw.append(idTxt + "," + passTxt + "," + characterTxt + "," + getderTxt + "\n");
                // 초기화
                textField_id.setText("");
                PasswordField_pw.setText("");
                ComChar.setSelectedIndex(0);
                Gender.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Data Saved Successfully");
                fw.close();

      } catch (Exception e2) {
         JOptionPane.showMessageDialog(null, "There was an error while writing the data");
      }
         // 입력 받아서 Vector에 저장
         //vector.add(new Chatting_info(idTxt, passTxt, characterTxt, getderTxt));
         JOptionPane.showMessageDialog(null, "Your data has been save successfully");
         
            frame.setVisible(false);
        }
    
    
}