package displayConsole.menu;

import java.awt.Container;
import java.util.LinkedList;

import javax.swing.JFrame;

import displayConsole.Repainter;

/**
 * 带菜单的窗口，可以放入按钮<br/>
 * This is a window with menu, we can put buttons on it.
 * @author Hale
 *
 */
public class Menuwindow extends JFrame {
	private int windowsizex, windowsizey;
	private LinkedList<SButton> bs = new LinkedList<SButton>();
	public Repainter repainter;
	public MML mml;
	//Toolkit tk = this.getToolkit();
	//Image img = tk.getImage("Images//UI//mouse//hudtry.png");
	//Cursor cu = tk.createCustomCursor(img,new Point(20,5),"hud"); 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 这部分其实是和GameMenu一样的<br/>
	 * This part is same as GameMenu
	 * @param bgloc
	 * @param windowsizex
	 * @param windowsizey
	 */
	public Menuwindow(String bgloc, int windowsizex, int windowsizey) {
		this.windowsizex = windowsizex;
		this.windowsizey = windowsizey;
		this.setTitle("Spacecraft");
		Container c = this.getContentPane();
		repainter = new Repainter(bgloc);
		c.add(repainter);
		this.setBounds(0, 0, windowsizex, windowsizey);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
		this.repainter.mapsizex = 1600;
		this.repainter.mapsizey = 1200;// 背景图尺寸  Size of background pic.(Texture of entire battlefield).   
		this.repainter.windowsizex = windowsizex;
		this.repainter.windowsizey = windowsizey;
		
		//this.setCursor(cu);
		
		mml = new MML();
		this.addMouseMotionListener(mml);
		this.addMouseMotionListener(new MML());
		this.addMouseListener(mml);

		// 按钮 //Buttons
		this.addbutton(new Button_start(-500, 300));
		this.addbutton(new Button_exit(-500, 200));
	}

	public void addbutton(SButton b) {
		bs.add(b);
	}

	public void clear() {
		bs = new LinkedList<SButton>();
	}

	public void mousemove(int mx, int my) {
		mx = (mx - windowsizex / 2);
		my = (windowsizey / 2 - my);
		for (int i = 0; i < bs.size(); i++) {
			if (bs.get(i).buttonhitbox.contains(mx
					+ (bs.get(i).buttonhitbox.width) / 2, my
					+ (bs.get(i).buttonhitbox.height) / 2)) {
				bs.get(i).setstatus(1);

			} else {
				bs.get(i).setstatus(0);
			}
		}
	}

	public void mouseclick(int mx, int my) {
		mx = (mx - windowsizex / 2);
		my = (windowsizey / 2 - my);
		for (int i = 0; i < bs.size(); i++) {
			if (bs.get(i).buttonhitbox.contains(mx
					+ (bs.get(i).buttonhitbox.width) / 2, my
					+ (bs.get(i).buttonhitbox.height) / 2)) {
				bs.get(i).click();
			}
		}
	}

	public void mousepressed(int mx, int my) {
		mx = (mx - windowsizex / 2);
		my = (windowsizey / 2 - my);
		for (int i = 0; i < bs.size(); i++) {
			if (bs.get(i).buttonhitbox.contains(mx
					+ (bs.get(i).buttonhitbox.width) / 2, my
					+ (bs.get(i).buttonhitbox.height) / 2)) {
				bs.get(i).setstatus(2);
			}
		}
	}

	public void update() {
		this.repainter.le.clear();
		for (int i = 0; i < bs.size(); i++) {
			this.repainter.add_nooffset_element(bs.get(i).getImage(),
					bs.get(i).buttonhitbox.x - (bs.get(i).buttonhitbox.width)
							/ 2, bs.get(i).buttonhitbox.y
							+ (bs.get(i).buttonhitbox.height) / 2, 0, 0);
		}
		this.repainter.repaint();
	}
}
