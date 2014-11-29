package DisplaymentManager;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class Updater extends JPanel implements Runnable{
    public boolean inGame=true;
    
	 public Updater(){
		 Thread t = new Thread(this);
		 t.start();
	 }

	public void run() {
		while(inGame){
		  try{
		     Thread.sleep(10);	
		  }catch(InterruptedException e){}
		  //Parameters expression here
		  
		  repaint();
		 
		}
	}
	public void paint(Graphics g){
		Image player = getToolkit().getImage("player.png");
		super.paint(g);
		g.clearRect( 0, 0, this.getWidth(), this.getHeight());
		g.drawImage(player,50,50,this);
		
	}

}
