package displayConsole;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import spacecraftcore.MainGame;
import spacecraftelements.SpaceShip.SpaceShip;

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
	public int rotatedegree = 0;
	public int layer = 0;
	private SpaceShip bufferShip;
	int windowsizex;
	int windowsizey;
	private int offsetx;
	private int offsety;
	protected int mapsizex, mapsizey;
	private int before = 0, after = 0;

	public Image bg = getToolkit().getImage("Images//testbg1600x1200.png");
	// public Image player = getToolkit().getImage("Images//player.png");

	public List<Element> le = new LinkedList<Element>();

	/**
	 * 
	 * ����Ϸ���ͼ�����������������Ļ����
	 * 
	 * @param name
	 * @param imagesize
	 * @param x
	 * @param y
	 * @param d
	 * @param layer
	 */
	public void add(String name, int imagesize, int x, int y, double d,
			int layer) {
		before++;
		Element element = this.computeElement(name, imagesize, x, y, d, layer);
		if (element != null) {
			element.img = getToolkit().getImage(name);
			// element.x = x;
			// element.y = y;
			element.rotatedegree = d;
			element.layer = layer;
			le.add(element);
			after++;
		}
	}

	/**
	 * 
	 * ����Ļ��ָ���ص�����������������Ļ������Ҫ����Ѫ��֮�������� ��Ļ�е�������(0,0)
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param angle
	 * @param layer
	 */
	public void add_nooffset_element(String name, int x, int y, double angle,
			int layer) {

		Element element = new Element(name, x, y, angle, layer);
		element.img = getToolkit().getImage(name);
		element.x = x;
		element.y = y;
		element.rotatedegree = angle;
		element.layer = layer;
		le.add(element);
	}

	public Repainter() {

	}

	/*
	 * public Repainter(){ Thread t = new Thread(this); t.start(); }
	 * 
	 * //Thread here,aborted
	 * 
	 * public void run() { while(true){ try{ Thread.sleep(20);
	 * }catch(InterruptedException e){} y+=2; rotatedegree+=5;
	 * 
	 * if(y>300){ y=-80; } if(rotatedegree>360){ rotatedegree=0; } repaint(); }
	 * }
	 */
	public void paint(Graphics g) {
		 System.out.println(before+" -> "+after);
		// BufferedImage bg = (BufferedImage) getToolkit().getImage("bg1.jpg");
		// BufferedImage player = (BufferedImage)
		// getToolkit().getImage("player.png");
		/*
		 * if(iBuffer==null){
		 * iBuffer=createImage(this.getSize().width,this.getSize().height);
		 * gBuffer=iBuffer.getGraphics(); } gBuffer.setColor(getBackground());
		 * gBuffer.fillRect(0, 0, this.getSize().width,this.getSize().height);
		 * gBuffer.setColor(Color.red); gBuffer.fillOval(90,y,80,80);
		 * g.drawImage(bg,0,0,this); g.drawImage(iBuffer,0,0,this);
		 */

		super.paint(g);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(bg, -offsetx - 400, offsety - 300, this);// ����ܱ�����λ��
		for (int i = 0; i < le.size(); i++) {// Need to optimize here
			g.drawImage(rotateImage(le.get(i).img, le.get(i).rotatedegree),
					le.get(i).x + (windowsizex / 2),
					(windowsizey / 2) - le.get(i).y, this);// !!!!!!
		}// !!!!!!!!!����Ҳ��ת������Ĳ���!!!!!!!!!!!!
			// g.drawImage(rotateImage(player,rotatedegree),0,y,this);
			// g.drawImage(rotateImage(player,rotatedegree),50,y,this);
			// g.drawImage(rotateImage(player,rotatedegree),100,y,this);

		// g.drawImage(bg,0,0,this);
		before = 0;
		after = 0;
	}

	public static BufferedImage rotateImage(Image bufferedimage, double degree) {
		int w = bufferedimage.getWidth(null);
		int h = bufferedimage.getHeight(null);
		// int type = ((BufferedImage)
		// bufferedimage).getColorModel().getTransparency();
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = img.createGraphics();// Key Code to implement
														// the Transparency
		img = graphics2d.getDeviceConfiguration().createCompatibleImage(w, h,
				Transparency.TRANSLUCENT);
		graphics2d.dispose();
		graphics2d = img.createGraphics();
		// (graphics2d = (img = new BufferedImage(w, h, type))
		// .createGraphics()).setRenderingHint(
		// RenderingHints.KEY_INTERPOLATION,
		// RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
		graphics2d.drawImage(bufferedimage, 0, 0, null);
		graphics2d.dispose();
		return img;
	}

	/**
	 * ��װһ�����������洢��Ԫ��
	 * 
	 * @author Hale
	 * @param name
	 * @param x
	 * @param y
	 * @param d
	 * @param layer
	 * @return ���������洢��Ԫ��
	 */
	private Element computeElement(String name, int Imagesize, int x, int y,
			double d, int layer) {
		if (((x - offsetx) < -windowsizex / 2)
				|| ((x - offsetx) > windowsizex / 2)
				|| (y - offsety) < -windowsizey / 2
				|| (y - offsety) > windowsizey / 2) {
			// System.out.println(name+"out");
			return null;
		}
		Element e = new Element(name, x - offsetx - Imagesize, y - offsety
				+ Imagesize, d, layer);
		return e;

	}

	/**
	 * ����ɴ������������ڽ������ƫ�Ϊ��һ������Ԫ����׼��
	 * 
	 * @param s
	 * @return
	 * @author Hale
	 */
	public boolean computeOffset(SpaceShip s) {
		bufferShip = MainGame.bm.getShip();
		if ((bufferShip.x < -(mapsizex / 2 - windowsizex / 8) || bufferShip.x > (mapsizex / 2 - windowsizex / 8)) != true) {// �쵽���ұ߽���
			if (bufferShip.visx > (3 * (windowsizex) / 8)) {
				bufferShip.visx = 3 * windowsizex / 8;
			} else if (bufferShip.visx < -(3 * (windowsizex) / 8)) {
				bufferShip.visx = -3 * windowsizex / 8;
			}
		}
		if ((bufferShip.y < -(mapsizey / 2 - windowsizey / 8) || bufferShip.y > (mapsizey / 2 - windowsizey / 8)) != true) {
			if (bufferShip.visy > (3 * (windowsizey) / 8)) {
				bufferShip.visy = 3 * windowsizey / 8;
			} else if (bufferShip.visy < -(3 * (windowsizey) / 8)) {
				bufferShip.visy = -3 * windowsizey / 8;
			}
		}
		MainGame.bm.SetShip(bufferShip);
		this.add_nooffset_element(bufferShip.ImageID, bufferShip.visx
				- bufferShip.Imagesize, bufferShip.visy + bufferShip.Imagesize,
				bufferShip.angle, 2);
		// ����ƫ��
		offsetx = bufferShip.x - bufferShip.visx;
		offsety = bufferShip.y - bufferShip.visy;
		if (offsetx == 0 && offsety == 0)
			return false;
		else {
			return true;
		}

	}
}
