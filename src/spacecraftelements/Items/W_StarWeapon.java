package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftelements.Weapon.StarWeapon;
import spacecraftevent.ChangeWeapon;

public class W_StarWeapon extends SpaceItem {
	public W_StarWeapon(double x, double y) {
		super.imageID = "Images//Item//starweapon.png";
		super.imagesize = 25;
		super.x = (int) x;
		super.y = (int) y;
	}

	@Override
	public boolean getitem() {
		ChangeWeapon.change(2, new StarWeapon());
		MainGame.bm.score+=15;
		return false;
	}

}
