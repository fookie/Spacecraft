package displayConsole;

import spacecraftcore.MainGame;
import spacecraftelements.SpaceShip.SpaceShip;

public class WeaponSlot {
	public static String emptyslot = "Images//InGameHUD//Weaponslot//emptyslot.png";
	
	public static boolean displayweapon(SpaceShip s){
		MainGame.test.repainter.add_nooffset_element("Images//InGameHUD//Weaponslot//weaponslot.png",MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-60), 0, 2);
		if(s.w1 != null){
			MainGame.test.repainter.add_nooffset_element(s.w1.ImageLoc, MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-60), 0, 2);
		}else {
			MainGame.test.repainter.add_nooffset_element(emptyslot, MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-60), 0, 2);
		}
		if(s.w2 == null){
			MainGame.test.repainter.add_nooffset_element(emptyslot, MainGame.test.repainter.onscreenx(100), MainGame.test.repainter.onscreeny(-60), 0, 2);
		}else {
			MainGame.test.repainter.add_nooffset_element(s.w2.ImageLoc, MainGame.test.repainter.onscreenx(100), MainGame.test.repainter.onscreeny(-60), 0, 2);
		}
		return false;
	}
}
 