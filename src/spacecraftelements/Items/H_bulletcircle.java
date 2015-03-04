package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftelements.Bullets.BlueBullet;

public class H_bulletcircle extends SpaceItem{
	public H_bulletcircle(int x,int y){
	super.imageID="Images//Item//bulletcircle.png";
	super.imagesize=25;
	super.x=x;
	super.y=y;
	}
	@Override
	public boolean getitem() {
		for(int i=-5;i<6;i++)
		{
			MainGame.bm.add(new BlueBullet(x, y, i,(int) Math.sqrt(20-i*i), 1));
			MainGame.bm.add(new BlueBullet(x, y, i,-(int) Math.sqrt(20-i*i), 1));
		}
		return true;
	}

}
