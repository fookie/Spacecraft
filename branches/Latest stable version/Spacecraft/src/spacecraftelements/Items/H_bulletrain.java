package spacecraftelements.Items;

import spacecraftcore.MainGame;
import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.Bullet;
import spacecraftevent.BulletRain;

public class H_bulletrain extends SpaceItem{
	public H_bulletrain(int x,int y){
	super.imageID="Images//Item//bulletrain.png";
	super.imagesize=50;
	super.x=x;
	super.y=y;
	}
	@Override
	public boolean getitem() {
		MainGame.bm.add(new BulletRain());
		return true;
	}

}
