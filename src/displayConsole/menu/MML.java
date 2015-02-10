package displayConsole.menu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import spacecraftcore.MainGame;

public class MML implements MouseMotionListener,MouseListener{
	
    public int mx,my;
    
    
	public void mouseDragged(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		MainGame.mainmenu.mousemove(mx, my);
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
		
	}

	public void mousePressed(MouseEvent e) {
	
	}

	public void mouseReleased(MouseEvent e) {
	
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}