package displayConsole;

import spacecraftcore.MainGame;

public class Mousehud {
	public static void showHud(int x, int y) {

		//int f =(int) Math.floor((MainGame.gametime % 207)/3 );


		//MainGame.test.repainter.add_nooffset_element("Images//UI//mouse//hud ("
		//		+ f + ").png", MainGame.test.repainter.onscreenx(x - 320),
		//		MainGame.test.repainter.onscreeny(-y + 180), 0, 2);
		if(MainGame.bm.isshooting){
			MainGame.test.repainter.add_nooffset_element("Images//UI//mouse//hud2.png", MainGame.test.repainter.onscreenx(x - 320),
					MainGame.test.repainter.onscreeny(-y + 180), 0, 2);
		}
		else{
		MainGame.test.repainter.add_nooffset_element("Images//UI//mouse//hud1.png", MainGame.test.repainter.onscreenx(x - 320),
				MainGame.test.repainter.onscreeny(-y + 180), 0, 2);
		}

	}
}
