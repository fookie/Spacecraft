package spacecraftcore;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'q'&&!MainGame.bm.paused) {
			MainGame.bm.ship.switchweapon();
		}
		if (e.getKeyChar() == 27&&MainGame.bm.ship.health>=0) {//27ÊÇEscµÄASCIIÂë   '27' stands for ESC in the ASCII . 
			MainGame.bm.paused=!MainGame.bm.paused;
			MainGame.test.repainter.add_nooffset_element("Images//UI//paused400x250.png",-200,75, 0, 0);
			MainGame.test.repainter.repaint();
		}
		if(e.getKeyChar() == 'q'&&(MainGame.bm.paused||MainGame.bm.ship.health<=0))
		{
			System.exit(0);
		}
		if(e.getKeyChar() == 'r'&&MainGame.bm.paused)
		{
			MainGame.bm.paused=!MainGame.bm.paused;
		}
		if(e.getKeyChar() == 'b'&&(MainGame.bm.paused||MainGame.bm.ship.health<=0))
		{
			MainGame.test.setVisible(false);
			MainGame.test.dispose();
			MainGame.mainmenu.setVisible(true);
			MainGame.gamestatus=0;
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
