package spacecraftelements.Bullets;

import spacecraftcore.MainGame;
/**
 *		基础子弹，暂时用于测试 
 */
public class BasicBullet extends Bullet{
	public BasicBullet(Double x,Double y){
		//设定该子弹属性
		super.x=x;
		super.y=y;
		super.vx=(double) 10;
		super.vy=(double) 8;
		super.damage=15.0;
		super.ImageID="Images//bullet//basicbullet.png";
		//角度暂时不设定
	}

	@Override
	public boolean update() {
		x=x+vx;
		y=y+vy;
		if(x>(MainGame.bm.mapx)/2||y>(MainGame.bm.mapy)/2||x<-(MainGame.bm.mapx)/2||y<-(MainGame.bm.mapy)/2)
		{//超出边界
		return false;
		}
		return true;
	}

}
