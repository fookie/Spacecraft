package spacecraftelements.Items;

import spacecraftcore.MainGame;

public class S_repair extends SpaceItem{
	public S_repair(double x,double y)
	{
		super.x=(int) x;
		super.y=(int) y;
		super.imageID="Images//Item//repair.png";
		super.imagesize=25;
	}
	@Override
	public boolean getitem() {
		MainGame.bm.ship.health=MainGame.bm.ship.health+1;
		MainGame.bm.score+=15;
		return false;
	}

}
