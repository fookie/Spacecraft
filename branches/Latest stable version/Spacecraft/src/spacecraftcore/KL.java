package spacecraftcore;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'q') {
			MainGame.bm.ship.switchweapon();
		}
		if (e.getKeyChar() == 27) {//27ÊÇEscµÄascii Âë
			MainGame.test.repainter.add_nooffset_element("Images//UI//paused400x250.png",-200,75, 0, 0);
			MainGame.test.repainter.repaint();
			MainGame.bm.paused=!MainGame.bm.paused;
		}
		}
	

	@Override
	public void keyPressed(KeyEvent e) {
		MainGame.bm.Keyprocesser(true, e.getKeyChar());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		MainGame.bm.Keyprocesser(false, e.getKeyChar());

	}

}
