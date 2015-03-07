package spacecraftelements.Items;

public class W_EnhancedWeapon extends SpaceItem{
	public W_EnhancedWeapon(int x,int y){
	super.imageID="Images//Item//starweapon.png";
	super.imagesize=25;
	super.x=x;
	super.y=y;
	}
	@Override
	public boolean getitem() {
		return false;
	}

}
