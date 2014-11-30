package displayConsole;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
/**
 * 
 * @author EveLIn
 *
 */

public class Repainter extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public int x = 0;
	public int y = 0;
	public int rotatedegree=0;
	public int layer = 0;
	
	//private Image iBuffer;
	//private Graphics gBuffer;
	
	public Image bg = getToolkit().getImage("Images//bg1.jpg");
	//public Image player = getToolkit().getImage("Images//player.png");
	
	public List<Element> le = new LinkedList<Element>();
	
	
	public void add(String name,int x,int y,int degree,int layer){
		   Element element = new Element(name,x,y,degree,layer);
		   element.img = getToolkit().getImage(name);
		   element.x = x;
		   element.y = y;
		   element.rotatedegree = degree;
		   element.layer = layer;
		   le.add(element);
	   }

	
	 /*public Repainter(){
		 Thread t = new Thread(this);
		 t.start();
	 }
	 
     //Thread here,aborted
      
	 public void run() {
        while(true){
        	try{
        		Thread.sleep(20);
        	}catch(InterruptedException e){}
        	y+=2;
        	rotatedegree+=5;

        	if(y>300){
        		y=-80;
        	}
        	if(rotatedegree>360){
        		rotatedegree=0;
        	}
        	repaint();
        }
	}*/
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
		for(int i=0;i<le.size();i++){
			g.drawImage(rotateImage(le.get(i).img , le.get(i).rotatedegree) , le.get(i).x , le.get(i).y,this);
		}
		//g.drawImage(rotateImage(player,rotatedegree),0,y,this);
		//g.drawImage(rotateImage(player,rotatedegree),50,y,this);
		//g.drawImage(rotateImage(player,rotatedegree),100,y,this);
		
		
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
        Graphics2D graphics2d = img.createGraphics();//Key Code to implement the Transparency 
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
