package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftelements.Weapon.BasicWeapon;
import spacecraftevent.ChangeWeapon;

public class W_BasicWeapon extends SpaceItem {
	public W_BasicWeapon(int x, int y) {
		super.imageID = "Images//Item//basicweapon.png";
		super.imagesize = 25;
		super.x = x;
		super.y = y;
	}

	@Override
	public boolean getitem() {
		ChangeWeapon.change(0, new BasicWeapon());
		MainGame.bm.score+=75;
		return false;
	}

}
