package loop;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Repainter extends JPanel implements Runnable{
	public int y = -80;
	private Image iBuffer;
	private Graphics gBuffer;
	public Image bg = getToolkit().getImage("bg1.jpg");
	public Image player = getToolkit().getImage("player.jpg");
	public class background extends JPanel{
		public background(){
		setOpaque(false);
		setLayout(null);
		}
	}
	
	 public Repainter(){
		 Thread t = new Thread(this);
		 t.start();
	 }

	public void run() {
        while(true){
        	try{
        		Thread.sleep(5);
        	}catch(InterruptedException e){}
        	y+=2;
        	if(y>300){
        		y=-80;
        	}
        	repaint();
        }
	}
	public void paint(Graphics g){
		Image bg = getToolkit().getImage("bg1.jpg"); 
		Image player = getToolkit().getImage("player.png");
		/*if(iBuffer==null){
			iBuffer=createImage(this.getSize().width,this.getSize().height);
			gBuffer=iBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0, 0, this.getSize().width,this.getSize().height);
		gBuffer.setColor(Color.red);
		gBuffer.fillOval(90,y,80,80);
		g.drawImage(bg,0,0,this);
		g.drawImage(iBuffer,0,0,this);*/
		super.paint(g);
		g.clearRect( 0, 0, this.getWidth(), this.getHeight());
		g.drawImage(bg,0,0,this);
		g.drawImage(player,0,y,this);
		//g.drawImage(bg,0,0,this);
	}
	//public void update(Graphics g){
		//paint(g);
	//}
	
	
}
