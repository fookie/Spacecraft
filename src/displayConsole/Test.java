package displayConsole;

import java.awt.*;

import javax.swing.*;

import spacecraftcore.KL;
import spacecraftcore.ML;
/**
 * 主要窗口，它会生成repainter
 * 
 * @author EveLIN
 *
 */
public class Test extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Repainter repainter;
	public KL kl;
	public ML ml;
	public int windowsizex = 800;//窗口大小
	public int windowsizey = 600;
	/**
	 * 
	 * 这个建造方法让battleFieldManager调用，初始化视觉方面的数据
	 * 
	 * @author EveLIN
	 * @param bgloc 背景地址
	 * @param mapx	实际场地大小
	 * @param mapy
	 */
	public Test(String bgloc, int mapx, int mapy) {
		this.setTitle("Spacecraft");
		Container c = this.getContentPane();
		repainter = new Repainter(bgloc);
		c.add(repainter);
		setMapsize(mapx,mapy);
		this.setBounds(400, 200, windowsizex, windowsizey);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		// 事件部分
		kl = new KL();
		this.addKeyListener(kl);
		ml = new ML();
		this.addMouseMotionListener(ml);
		this.addMouseMotionListener(new ML());
		this.addMouseListener(ml);
	}
	/**
	 * 
	 * 设置repainter的相关属性，两个参数是地图实际大小
	 * 
	 * @param x 
	 * @param y
	 */
	public void setMapsize(int x, int y) {
		this.repainter.mapsizex = x;
		this.repainter.mapsizey = y;
		this.repainter.windowsizex = windowsizex;
		this.repainter.windowsizey = windowsizey;
	}
}
