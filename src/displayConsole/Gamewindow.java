package displayConsole;

import java.awt.*;

import javax.swing.*;

import spacecraftcore.KL;
import spacecraftcore.ML;
/**
 * 主要窗口，它会生成repainter<br/>
 * Main window that can generate repainter.
 * @author EveLIN
 *
 */
public class Gamewindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Repainter repainter;
	public KL kl;
	public ML ml;
	public int windowsizex;//窗口大小 //size of window
	public int windowsizey;
	/**
	 * 
	 * 这个建造方法让battleFieldManager调用，初始化视觉方面的数据<br/>
	 * This constructor can be called by BattleFieldManager to initialize the data of vision
	 * @author EveLIN
	 * @param bgloc 背景地址 background location
	 * @param mapx	实际场地大小  size of map
	 * @param mapy
	 */
	public Gamewindow(String bgloc, int mapx, int mapy,int windowsizex,int windowsizey) {
		this.windowsizex=windowsizex;
		this.windowsizey=windowsizey;
		this.setTitle("Spacecraft");
		Container c = this.getContentPane();
		repainter = new Repainter(bgloc);
		c.add(repainter);
		setMapsize(mapx,mapy);
		this.setBounds(0, 0, windowsizex, windowsizey);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true); //
		this.setVisible(true);
		// 事件部分 //Event part.
		kl = new KL();
		this.addKeyListener(kl);
		ml = new ML();
		this.addMouseMotionListener(ml);
		this.addMouseMotionListener(new ML());
		this.addMouseListener(ml);
	}
	/**
	 * 
	 * 设置repainter的相关属性，两个参数是地图实际大小<br/>
	 * To set relevant properties of repainter. 
	 * @param x The size of map.
	 * @param y
	 */
	public void setMapsize(int x, int y) {
		this.repainter.mapsizex = x;
		this.repainter.mapsizey = y;
		this.repainter.windowsizex = windowsizex;
		this.repainter.windowsizey = windowsizey;
	}
}
