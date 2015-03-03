package spacecraftelements.Items;

public class H_bulletrain extends SpaceItem{
	public H_bulletrain(int x,int y){
	super.imageID="Images//Item//bulletrain.png";
	super.imagesize=50;
	super.x=x;
	super.y=y;
	}
	@Override
	public boolean getitem() {
		return false;
	}

}
