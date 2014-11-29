package spacecraftelements.Bullets;

import spacecraftcore.MainGame;

public class BasicBullet extends Bullet{
	public BasicBullet(int x,int y,int vx,int vy){
		//设定该子弹属性
		super.x=x;
		super.y=y;
		super.vx=vx;
		super.vy=vy;
		super.damage=15;
		super.volume = 10;
		super.ImageID="Images//bullet//basicbullet.png";
		super.ID = 0;
		//角度暂时不设定
	}

	@Override
	public boolean update() {
		System.out.print(this.toString()+"before: x");
		x=x+vx;
		y=y+vy;
		if(x>(MainGame.bm.mapx)/2||y>(MainGame.bm.mapy)/2||x<-(MainGame.bm.mapx)/2||y<-(MainGame.bm.mapy)/2)
		{//超出边界
		return false;
		}
		return true;
	}

}
