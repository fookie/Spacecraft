package displayConsole;

import java.awt.*;

import javax.swing.*;

import spacecraftcore.KL;
import spacecraftcore.ML;
/**
 * ��Ҫ���ڣ���������repainter<br/>
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
	public int windowsizex;//���ڴ�С //size of window
	public int windowsizey;
	/**
	 * 
	 * ������췽����battleFieldManager���ã���ʼ���Ӿ����������<br/>
	 * This constructor can be called by BattleFieldManager to initialize the data of vision
	 * @author EveLIN
	 * @param bgloc ������ַ background location
	 * @param mapx	ʵ�ʳ��ش�С  size of map
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
		// �¼����� //Event part.
		kl = new KL();
		this.addKeyListener(kl);
		ml = new ML();
		this.addMouseMotionListener(ml);
		this.addMouseMotionListener(new ML());
		this.addMouseListener(ml);
	}
	/**
	 * 
	 * ����repainter��������ԣ����������ǵ�ͼʵ�ʴ�С<br/>
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
