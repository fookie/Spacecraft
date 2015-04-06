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
 * 注意：由于这是项目初期的类，后来由多人多次修改，因此内容相对混乱，但因为在多处使用，难以下手优化。<br/>
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
	private SpaceShip bufferShip;// 临时变量用来存飞船 //A temporary variable to store the ship.
	public int windowsizex;
	public int windowsizey;
	private int offsetx;// 偏移量，滚屏用的           //The offset used to scroll the screen.
	private int offsety;
	public int mapsizex;// 地图实际大小,也是背景图的大小	//Size of background pic.
	public int mapsizey;
	public int abx, aby;// 在地图上的坐标					//Coordinate on the MAP.
	public String bgloc;// 背景地址							//Location of background.
	public Image bg;

	public LinkedList<Element> le = new LinkedList<Element>();

	/**
	 * 
	 * 在游戏大地图上添加物件，会跟随屏幕卷动。<br/>
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
	 * 在屏幕的指定地点添加物件，不会随屏幕卷动，主要用于血条之类的物件。 屏幕中点坐标是(0,0)<br/>
	 * This part is to add items on the specify positions. They won't scroll with screen. Mostly used by HPBar and such UI elements and the midpoint of screen is the origin.<br/>
	 * 由于此方法基本上用来添加UI，所以就没有imagesize，位置自行计算。注：这点属于开始的设计缺陷，为了方便使用，下方已添加转换用方法 <br/>
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
	 * 用于在屏幕坐标与内建坐标间转换（横坐标）<br/>
	 * Used to convert coordinates of on screen to coordinates on the maps.(x-coordinate)  
	 * @param x  屏幕坐标系上的横坐标（左上角为(0, 0)) <br/> The x-coordinates on screen. （The top left corner of screen is the origin.)
	 * @return 换算后的在内建坐标系上的横坐标<br/> The x-coordinates on map.
	 */
	public int onscreenx(int x) {
		abx = x - windowsizex / 2;
		return abx;
	}

	/**
	 * 用于在屏幕坐标与内建坐标间转换（纵坐标）<br/>
	 * 
	 * @param y 屏幕坐标系上的纵坐标（左上角为(0, 0))
	 * @return 换算后的在内建坐标系上的纵坐标
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
				-(mapsizey / 2 - windowsizey / 2) + offsety, this);// 背景位置，offset为0时背景中心对准屏幕中心  //Position of background texture. When the offset value is 0, it's aligned to the midpoint of screen.
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
		}// !!!!!!!!!这里也有转换坐标的部分!!!!!!!!!!!!  //Attention: This part contains coordinate conversion.
		
		
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
//		//这部分将处理
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
	 * 组装一个以相对坐标存储的元素<br/>
	 * Create an element to store relative coordinates.  
	 * @author Hale
	 * @param name
	 * @param x
	 * @param y
	 * @param d
	 * @param layer
	 * @return 以相对坐标存储的元素<br/>The element stores relative coordinates.
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
	 * 计算飞船可视坐标与内建坐标的偏差，为下一步生成元素做准备<br/>
	 * Compute the offset between screen coordinates and map coordinates of the SHIP.
	 * @param s
	 * @return
	 * @author Hale
	 */
	public boolean computeOffset(SpaceShip s) {
		bufferShip = MainGame.bm.getShip();
		if ((bufferShip.x < -(mapsizex / 2 - windowsizex / 8) || bufferShip.x > (mapsizex / 2 - windowsizex / 8)) != true) {// 快到左右边界了
			if (bufferShip.visx > (3 * (windowsizex) / 8)) {
				bufferShip.visx = 3 * windowsizex / 8;
			} else if (bufferShip.visx < -(3 * (windowsizex) / 8)) {
				bufferShip.visx = -3 * windowsizex / 8;
			}
		}
		if ((bufferShip.y < -(mapsizey / 2 - windowsizey / 8) || bufferShip.y > (mapsizey / 2 - windowsizey / 8)) != true) {// 快到上下边界了
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
		// 计算偏差 //Compute the offset
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
