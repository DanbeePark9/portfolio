package Chatting;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;



public class Grim extends JPanel{
   
    private Image img;
   public Grim(Image img) {
      ImagePanel(img);
   }
    
     
     public void ImagePanel( Image img ) {
        this.img = img;
        setSize( new Dimension(img.getWidth(null), img.getHeight(null)));
        setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setLayout(null);
     }
     // 이미지의 가로 넓이를 구한다.
     public int getWidth() {
        return img.getWidth(null);
     }
     // 이미지의 높이 길이를 구한다.
     public int getHeight() {
        return img.getHeight(null);
     }
     
     public void paintComponent( Graphics g ) {
        g.drawImage( img, 0, 0, null);
     }
   
}