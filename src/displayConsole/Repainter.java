package displayConsole;

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
	private SpaceShip bufferShip;// 临时变量用来存飞船
	public int windowsizex;
	public int windowsizey;
	private int offsetx;// 偏移量，滚屏用的
	private int offsety;
	public int mapsizex;// 地图实际大小,也是背景图的大小
	public int mapsizey;
	public int abx, aby;// 在地图上的坐标
	public String bgloc;// 背景地址
	public Image bg;

	public LinkedList<Element> le = new LinkedList<Element>();

	/**
	 * 
	 * 在游戏大地图上添加物件，会跟随屏幕卷动。
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
	 * 在屏幕的指定地点添加物件，不会随屏幕卷动，主要用于血条之类的物件。 屏幕中点坐标是(0,0)
	 * 
	 * 由于此方法基本上用来添加UI，所以就没有imagesize，位置自行计算
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

	/**
	 * 用于在屏幕坐标与内建坐标间转换
	 * 
	 * @param x
	 *            屏幕坐标系上的横坐标（左上角为(0, 0))
	 * @return 换算后的在内建坐标系上的横坐标
	 */
	public int onscreenx(int x) {
		abx = x - windowsizex / 2;
		return abx;
	}

	/**
	 * 用于在屏幕坐标与内建坐标间转换
	 * 
	 * @param y
	 *            屏幕坐标系上的纵坐标（左上角为(0, 0))
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
		super.paint(g);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(bg, -(mapsizex / 2 - windowsizex / 2) - offsetx,
				-(mapsizey / 2 - windowsizey / 2) + offsety, this);// 背景位置，offset为0时背景中心对准屏幕中心
		for (int i = 0; i < le.size(); i++) {// Need to optimize here
			if (le.get(i).rotatedegree != 0) {
				g.drawImage(rotateImage(le.get(i).img, le.get(i).rotatedegree),
						le.get(i).x + (windowsizex / 2),
						(windowsizey / 2) - le.get(i).y, this);
			} else {
				g.drawImage(le.get(i).img, le.get(i).x + (windowsizex / 2),
						(windowsizey / 2) - le.get(i).y, this);
			}
			// !!!!!!
		}// !!!!!!!!!这里也有转换坐标的部分!!!!!!!!!!!!
		MainGame.cansendimage = true;
	}

	public static BufferedImage rotateImage(Image bufferedimage, double degree) {
		int w = bufferedimage.getWidth(null);
		int h = bufferedimage.getHeight(null);

		// int type = ((BufferedImage)
		// bufferedimage).getColorModel().getTransparency();
		if (w == -1 || h == -1) {
			w = 1;
			h = 1;
		//	System.out.println("ERROR:can't get size degree="+degree);
		}

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
	 * 组装一个以相对坐标存储的元素
	 * 
	 * @author Hale
	 * @param name
	 * @param x
	 * @param y
	 * @param d
	 * @param layer
	 * @return 以相对坐标存储的元素
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
	 * 计算飞船可视坐标与内建坐标的偏差，为下一步生成元素做准备
	 * 
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
		// 计算偏差
		offsetx = bufferShip.x - bufferShip.visx;
		offsety = bufferShip.y - bufferShip.visy;
		if (offsetx == 0 && offsety == 0)
			return false;
		else {
			return true;
		}

	}

}
