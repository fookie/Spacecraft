package displayConsole;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JPanel;

import spacecraftcore.MainGame;
import spacecraftelements.SpaceShip.SpaceShip;

/**
 * ע�⣺����������Ŀ���ڵ��࣬�����ɶ��˶���޸ģ����������Ի��ң�����Ϊ�ڶദʹ�ã����������Ż���<br/>
 * Attention: As this is a class written on the initial stage of the project and have been edited by different persons later, the content may be confused. But we have used this in many parts of the program, thus it's hard to optimize this part for us now. 
 * @Initialauthor EveLIn
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
	private SpaceShip bufferShip;// ��ʱ����������ɴ� //A temporary variable to store the ship.
	public int windowsizex;
	public int windowsizey;
	private int offsetx;// ƫ�����������õ�           //The offset used to scroll the screen.
	private int offsety;
	public int mapsizex;// ��ͼʵ�ʴ�С,Ҳ�Ǳ���ͼ�Ĵ�С	//Size of background pic.
	public int mapsizey;
	public int abx, aby;// �ڵ�ͼ�ϵ�����					//Coordinate on the MAP.
	public String bgloc;// ������ַ							//Location of background.
	public Image bg;

	public LinkedList<Element> le = new LinkedList<Element>();

	/**
	 * 
	 * ����Ϸ���ͼ�����������������Ļ����<br/>
	 * This part is to add items on the map, they can scroll with screen.
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

		Element element = this.computeElement(name, imagesize, x, y, d, layer);
		if (element != null) {
			MainGame.bm.imgnum++;
			element.img = getToolkit().getImage(name);
			// element.x = x;
			// element.y = y;
			element.rotatedegree = d;
			element.layer = layer;
			le.add(element);

		}
	}

	/**
	 * 
	 * ����Ļ��ָ���ص�����������������Ļ������Ҫ����Ѫ��֮�������� ��Ļ�е�������(0,0)<br/>
	 * This part is to add items on the specify positions. They won't scroll with screen. Mostly used by HPBar and such UI elements and the midpoint of screen is the origin.<br/>
	 * ���ڴ˷����������������UI�����Ծ�û��imagesize��λ�����м��㡣ע��������ڿ�ʼ�����ȱ�ݣ�Ϊ�˷���ʹ�ã��·������ת���÷��� <br/>
	 * Due to this method is used to add UI elements, it has no imagesize parameter, and the positions should be calculated by programmer. Note: This is the drawback of early vision. For the consideration of convenience, the following part is the converting method.   
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

	/**
	 * ��������Ļ�������ڽ������ת���������꣩<br/>
	 * Used to convert coordinates of on screen to coordinates on the maps.(x-coordinate)  
	 * @param x  ��Ļ����ϵ�ϵĺ����꣨���Ͻ�Ϊ(0, 0)) <br/> The x-coordinates on screen. ��The top left corner of screen is the origin.)
	 * @return ���������ڽ�����ϵ�ϵĺ�����<br/> The x-coordinates on map.
	 */
	public int onscreenx(int x) {
		abx = x - windowsizex / 2;
		return abx;
	}

	/**
	 * ��������Ļ�������ڽ������ת���������꣩<br/>
	 * 
	 * @param y ��Ļ����ϵ�ϵ������꣨���Ͻ�Ϊ(0, 0))
	 * @return ���������ڽ�����ϵ�ϵ�������
	 */
	public int onscreeny(int y) {
		aby = y + windowsizey / 2;
		return aby;
	}

	public Repainter(String bgloc) {
		this.bgloc = bgloc;
		this.bg = getToolkit().getImage(bgloc);

	}

	public void paint(Graphics g) {

		MainGame.cansendimage = false;
		//super.paint(g);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(bg, -(mapsizex / 2 - windowsizex / 2) - offsetx,
				-(mapsizey / 2 - windowsizey / 2) + offsety, this);// ����λ�ã�offsetΪ0ʱ�������Ķ�׼��Ļ����  //Position of background texture. When the offset value is 0, it's aligned to the midpoint of screen.
		for (int i = 0; i < le.size(); i++) {
			if (le.get(i).rotatedegree != 0) {
				g.drawImage(rotateImage(le.get(i).img, le.get(i).rotatedegree),
						le.get(i).x + (windowsizex / 2),
						(windowsizey / 2) - le.get(i).y, this);
			} else {
				g.drawImage(le.get(i).img, le.get(i).x + (windowsizex / 2),
						(windowsizey / 2) - le.get(i).y, this);
			}
			// !!!!!!
		}// !!!!!!!!!����Ҳ��ת������Ĳ���!!!!!!!!!!!!  //Attention: This part contains coordinate conversion.
		
		
		print_debug_message(g);
		MainGame.cansendimage = true;
	}
	
//	public void paint(Graphics g) {
//		MainGame.cansendimage = false;
//		g.clearRect(0, 0, this.getWidth(), this.getHeight());
//		g.drawImage(bg, -(mapsizex / 2 - windowsizex / 2) - offsetx,-(mapsizey / 2 - windowsizey / 2) + offsety, this);
//		
//		
//		
//		
//		//�ⲿ�ֽ�����
//		for (int i = 0; i < le.size(); i++) {
//		if (le.get(i).rotatedegree != 0) {
//			g.drawImage(rotateImage(le.get(i).img, le.get(i).rotatedegree),
//					le.get(i).x + (windowsizex / 2),
//					(windowsizey / 2) - le.get(i).y, this);
//		} else {
//			g.drawImage(le.get(i).img, le.get(i).x + (windowsizex / 2),
//					(windowsizey / 2) - le.get(i).y, this);
//		}
//		}
//		MainGame.cansendimage=true;
//	}

	public static BufferedImage rotateImage(Image bufferedimage, double degree) {
		int w = bufferedimage.getWidth(null);
		int h = bufferedimage.getHeight(null);

		if (w == -1 || h == -1) {
			w = 1;
			h = 1;
		}

		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = img.createGraphics();// Key Code to implement the Transparency
		img = graphics2d.getDeviceConfiguration().createCompatibleImage(w, h,
				Transparency.TRANSLUCENT);
		graphics2d.dispose();
		graphics2d = img.createGraphics();
		graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
		graphics2d.drawImage(bufferedimage, 0, 0, null);
		graphics2d.dispose();
		return img;
	}

	/**
	 * ��װһ�����������洢��Ԫ��<br/>
	 * Create an element to store relative coordinates.  
	 * @author Hale
	 * @param name
	 * @param x
	 * @param y
	 * @param d
	 * @param layer
	 * @return ���������洢��Ԫ��<br/>The element stores relative coordinates.
	 */
	private Element computeElement(String name, int Imagesize, int x, int y,
			double d, int layer) {
		if (((x - offsetx) < -windowsizex / 2)
				|| ((x - offsetx) > windowsizex / 2)
				|| (y - offsety) < -windowsizey / 2
				|| (y - offsety) > windowsizey / 2) {
			return null;
		}
		Element e = new Element(name, x - offsetx - Imagesize, y - offsety
				+ Imagesize, d, layer);
		return e;

	}

	/**
	 * ����ɴ������������ڽ������ƫ�Ϊ��һ������Ԫ����׼��<br/>
	 * Compute the offset between screen coordinates and map coordinates of the SHIP.
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
		if ((bufferShip.y < -(mapsizey / 2 - windowsizey / 8) || bufferShip.y > (mapsizey / 2 - windowsizey / 8)) != true) {// �쵽���±߽���
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
		// ����ƫ�� //Compute the offset
		offsetx = bufferShip.x - bufferShip.visx;
		offsety = bufferShip.y - bufferShip.visy;
		if (offsetx == 0 && offsety == 0)
			return false;
		else {
			return true;
		}

	}
	private void print_debug_message(Graphics g)
	{
		int line=0;
		g.setFont(new Font("Tahoma", Font.PLAIN, 15));
		g.setColor(new Color(255, 255, 255));
		g.drawString("SpaceCraft - debug", windowsizex-250, 200);
		line++;
		if(MainGame.gamestatus==1)
		{
			g.drawString("shipx:"+MainGame.bm.ship.x+"shipy"+MainGame.bm.ship.y, windowsizex-250, 200+line*15);
			line++;
			g.drawString("visx:"+MainGame.bm.ship.visx+"visy"+MainGame.bm.ship.visy, windowsizex-250, 200+line*15);
			line++;
			g.drawString("mapx:"+mapsizex+"mapy"+mapsizey, windowsizex-250, 200+line*15);
			line++;
		}
	}
}
