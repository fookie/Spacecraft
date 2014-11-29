package DisplaymentManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class BackgroundPanel extends JPanel{
  private Image bg;
  private JLabel scoreLabel;
  public BackgroundPanel(){
	  setOpaque(false);
	  setLayout(null);

  }
  public void setImage(Image i){
	  bg = i;
  }
  public void paintComponent(Graphics g){
	  if(bg!=null){
		  g.drawImage(bg,0,0,getWidth(),getHeight(),this);
		  
	  }
	  super.paintComponent(g);
  }
  
}
