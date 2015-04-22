package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftelements.Weapon.RocketLauncher;
import spacecraftevent.ChangeWeapon;

public class W_rocketlauncher extends SpaceItem {
	public W_rocketlauncher(double x, double y) {
		super.imageID = "Images//Item//rocketlauncher.png";
		super.imagesize = 25;
		super.x = (int) x;
		super.y = (int) y;
	}

	@Override
	public boolean getitem() {
		ChangeWeapon.change(2, new RocketLauncher());
		MainGame.bm.score+=15;
		return false;
	}

}
