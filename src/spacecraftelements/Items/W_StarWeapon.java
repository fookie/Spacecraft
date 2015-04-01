package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftelements.SpaceShip.SpaceShip;
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
		ChangeWeapon.change(2, SpaceShip.sw);
		MainGame.bm.score+=15;
		return false;
	}

}
