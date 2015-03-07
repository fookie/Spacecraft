package displayConsole;

import spacecraftcore.MainGame;
import spacecraftelements.SpaceShip.SpaceShip;

public class WeaponSlot {
	public static String emptyslot = "Images//InGameHUD//Weaponslot//emptyslot.png";
	public WeaponSlot()
	{
	}
	
	public static boolean displayweapon(SpaceShip s){
		if(s.w1 != null){
			MainGame.test.repainter.add_nooffset_element(s.w1.ImageLoc, -650, 304, 0, 2);
		}else {
			MainGame.test.repainter.add_nooffset_element(emptyslot, -650, 304, 0, 2);
		}
		if(s.w2 == null){
			MainGame.test.repainter.add_nooffset_element(emptyslot, -600, 304, 0, 2);
		}else {
			MainGame.test.repainter.add_nooffset_element(s.w2.ImageLoc, -600, 304, 0, 2);
		}
		return false;
	}
}
