package spacecraftelements.Items;

import spacecraftelements.Weapon.StarWeapon;
import spacecraftevent.ChangeWeapon;

public class W_StarWeapon extends SpaceItem {
	public W_StarWeapon(int x, int y) {
		super.imageID = "Images//Item//starweapon.png";
		super.imagesize = 25;
		super.x = x;
		super.y = y;
	}

	@Override
	public boolean getitem() {
		ChangeWeapon.change(2, new StarWeapon());
		return false;
	}

}
