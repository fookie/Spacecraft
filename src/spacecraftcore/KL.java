package spacecraftcore;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'q') {
			MainGame.bm.ship.switchweapon();
		}
		if (e.getKeyChar() == 'e') {
			System.exit(0);
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
