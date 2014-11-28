package DisplaymentManager;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
  private Image bg;
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
