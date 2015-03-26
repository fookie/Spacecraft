package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftevent.Speedup;

public class S_speedup extends SpaceItem{
	public S_speedup(int x,int y)
	{
		super.x=x;
		super.y=y;
		super.imageID="Images//Item//speedup.png";
		super.imagesize=25;
	}
	@Override
	public boolean getitem() {
		MainGame.bm.ship.maxv=MainGame.bm.ship.maxv+4;
		MainGame.bm.add(new Speedup(MainGame.gametime));
		MainGame.bm.score+=15;
		return false;
	}

}
