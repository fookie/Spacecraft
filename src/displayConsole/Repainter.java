package displayConsole;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Repainter extends JPanel implements Runnable{
	
	public int y = -80;
	public int rotatedegree=60;
	private Image iBuffer;
	private Graphics gBuffer;
	public Image bg = getToolkit().getImage("bg1.jpg");
	public Image player = getToolkit().getImage("player.png");
	public List<Element> le = new ArrayList<Element>();
	
	//try{BufferedImage bg1 = ImageIO.read(new File("bg1.jpg"));}
	//catch(IOException e){}
	
	public void add(String name,int x,int y,int degree,int layer){
		   Element img = (Element) getToolkit().getImage(name);
		   img.x = x;
		   img.y = y;
		   img.rotatedegree = degree;
		   img.layer = layer;
		   le.add(img);
	   }

	
	 public Repainter(){
		 Thread t = new Thread(this);
		 t.start();
	 }

	public void run() {
        while(true){
        	try{
        		Thread.sleep(20);
        	}catch(InterruptedException e){}
        	y+=2;
        	rotatedegree+=5;
            /* for(int i =0;i<le.length();i++)
             * 
             * 
             * 
             * 
             * */
        	if(y>300){
        		y=-80;
        	}
        	if(rotatedegree>420){
        		rotatedegree=60;
        	}
        	repaint();
        }
	}
	public void paint(Graphics g){
		
		//BufferedImage bg = (BufferedImage) getToolkit().getImage("bg1.jpg"); 
		//BufferedImage player = (BufferedImage) getToolkit().getImage("player.png");
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
		g.drawImage(rotateImage(player,rotatedegree),0,y,this);
		g.drawImage(rotateImage(player,rotatedegree),50,y,this);
		g.drawImage(rotateImage(player,rotatedegree),100,y,this);
		
		
		//g.drawImage(bg,0,0,this);
	}
	//public void update(Graphics g){
		//paint(g);
	//}
	public static BufferedImage rotateImage( Image bufferedimage,
             int degree) {
        int w = bufferedimage.getWidth(null);
        int h = bufferedimage.getHeight(null);
        //int type = ((BufferedImage) bufferedimage).getColorModel().getTransparency();
        BufferedImage img = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d = img.createGraphics();
        img = graphics2d.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);
        graphics2d.dispose();
        graphics2d = img.createGraphics();
        //(graphics2d = (img = new BufferedImage(w, h, type))
               // .createGraphics()).setRenderingHint(
               // RenderingHints.KEY_INTERPOLATION,
                //RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2+5);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }
	
	
}
