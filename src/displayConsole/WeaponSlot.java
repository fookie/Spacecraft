package displayConsole;

import spacecraftcore.MainGame;
import spacecraftelements.SpaceShip.SpaceShip;
/**
 * @author Paulay
 *
 */
public class WeaponSlot {
	public static String emptyslot = "Images//InGameHUD//Weaponslot//emptyslot.png";
	
	public static boolean displayweapon(SpaceShip s){
		
		if(s.w1.weaponID == 0){
			MainGame.test.repainter.add_nooffset_element("Images//InGameHUD//Weaponslot//hightech.png",MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-MainGame.test.windowsizey+270), 0, 2);
			//MainGame.test.repainter.add_nooffset_element(s.w1.ImageLoc, MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-110), 0, 2);
		}else if(s.w1.weaponID == 3){
			MainGame.test.repainter.add_nooffset_element("Images//InGameHUD//Weaponslot//rocket.png",MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-MainGame.test.windowsizey+270), 0, 2);
			//MainGame.test.repainter.add_nooffset_element(emptyslot, MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-110), 0, 2);
		}else if(s.w1.weaponID == 2){
			MainGame.test.repainter.add_nooffset_element("Images//InGameHUD//Weaponslot//burst.png",MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-MainGame.test.windowsizey+270), 0, 2);
			//MainGame.test.repainter.add_nooffset_element(emptyslot, MainGame.test.repainter.onscreenx(100), MainGame.test.repainter.onscreeny(-110), 0, 2);
		}else if(s.w1.weaponID == 1){
			MainGame.test.repainter.add_nooffset_element("Images//InGameHUD//Weaponslot//mass.png",MainGame.test.repainter.onscreenx(0), MainGame.test.repainter.onscreeny(-MainGame.test.windowsizey+270), 0, 2);
			//MainGame.test.repainter.add_nooffset_element(s.w2.ImageLoc, MainGame.test.repainter.onscreenx(100), MainGame.test.repainter.onscreeny(-110), 0, 2);
		}
		return false;
	}
}
 