package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftevent.BulletRain;

public class H_bulletrain extends SpaceItem{
	public H_bulletrain(int x,int y){
	super.imageID="Images//Item//bulletrain.png";
	super.imagesize=25;
	super.x=x;
	super.y=y;
	}
	@Override
	public boolean getitem() {
		MainGame.bm.add(new BulletRain());
		MainGame.bm.score+=15;
		return true;
	}

}