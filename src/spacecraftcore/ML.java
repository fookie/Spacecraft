package spacecraftcore;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ML implements MouseMotionListener,MouseListener{
	
    public int mx,my;
    
    
	public void mouseDragged(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		MainGame.bm.ml=true;
		//System.out.println(mx+" "+my);
		MainGame.bm.autotarx=mx;
		MainGame.bm.autotary=my;
		MainGame.bm.Mouseprocessor(mx,my);
	}

	public void mouseMoved(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		MainGame.bm.Mouseprocessor(mx,my);
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		//MainGame.bm.currentWeapon.shoot();
		//System.out.println("x");
		mx=e.getX();
		my=e.getY();
		MainGame.bm.autotarx=mx;
		MainGame.bm.autotary=my;
		MainGame.bm.ml=true;
		MainGame.bm.shootprocessor(mx, my);
		MainGame.bm.pressedtime=MainGame.gametime;
		
	}

	public void mouseReleased(MouseEvent e) {
		MainGame.bm.ml=false;
		MainGame.bm.pressedtime=0;
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}