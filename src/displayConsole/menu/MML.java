package displayConsole.menu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import spacecraftcore.MainGame;
import spacecraftcore.SoundController;
/**
 * Mouselistener for menu
 * @author Hale
 *
 */
public class MML implements MouseMotionListener,MouseListener{
	
    public int mx,my;
    
    
	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		MainGame.mainmenu.mousemove(mx, my);
	}

	public void mouseClicked(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		MainGame.mainmenu.mouseclick(mx, my);
		Thread t = new Thread(new SoundController("Sounds//click1.wav"));
		t.start();
		
	}

	public void mousePressed(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		MainGame.mainmenu.mousepressed(mx, my);
	}

	public void mouseReleased(MouseEvent e) {
	
	}

	public void mouseEntered(MouseEvent e) {
	}	

	public void mouseExited(MouseEvent e) {
		
	}

}