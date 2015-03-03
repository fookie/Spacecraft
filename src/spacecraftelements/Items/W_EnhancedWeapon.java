package spacecraftelements.Items;

import spacecraftcore.MainGame;

public class W_EnhancedWeapon extends SpaceItem{
	public W_EnhancedWeapon(int x,int y){
	super.imageID="Images//Item//EnhancedWeapon.png";
	super.imagesize=50;
	super.x=x;
	super.y=y;
	}
	@Override
	public boolean getitem() {
		return false;
	}

}
