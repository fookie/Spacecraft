package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftelements.Weapon.Shotgun;
import spacecraftevent.ChangeWeapon;

public class W_Shotgun extends SpaceItem {
	public W_Shotgun(int x, int y) {
		super.imageID = "Images//Item//shotgun.png";
		super.imagesize = 25;
		super.x = x;
		super.y = y;
	}

	@Override
	public boolean getitem() {
		ChangeWeapon.change(1, new Shotgun());
		MainGame.bm.score+=15;
		return false;
	}

}
