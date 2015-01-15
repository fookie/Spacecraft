/**
 * 
 */
package displayConsole;

import java.awt.Container;

import javax.swing.JFrame;

/**
 * 带菜单的窗口，可以放入按钮
 * @author Hale
 *
 */
public class Menuwindow extends JFrame{
	private int windowsizex,windowsizey;
	public Repainter repainter;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Menuwindow(String bgloc,int windowsizex,int windowsizey)
	{
		this.windowsizex=windowsizex;
		this.windowsizey=windowsizey;
		this.setTitle("Spacecraft");
		Container c = this.getContentPane();
		repainter = new Repainter(bgloc);
		c.add(repainter);
		this.setBounds(0, 0, windowsizex, windowsizey);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true); //
		this.setVisible(true);
	}
	public void addbutton()
	{
		
	}

}
