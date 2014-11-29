package spacecraftelements.Bullets;

import spacecraftTest.BattleFieldTest;

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
		System.out.print(this.toString()+"\n x:"+x+"y:"+y);
		x=x+vx;
		y=y+vy;
		System.out.println("-> x:"+x+"y:"+y);
		if(x>((BattleFieldTest.bfm.mapx)))
		{//超出边界
		return false;
		}
		return true;
	}

}
