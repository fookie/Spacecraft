package spacecraftelements.Bullets;

import spacecraftcore.MainGame;
/**
 *		�����ӵ�����ʱ���ڲ��� 
 */
public class BasicBullet extends Bullet{
	public BasicBullet(Double x,Double y){
		//�趨���ӵ�����
		super.x=x;
		super.y=y;
		super.vx=(double) 10;
		super.vy=(double) 8;
		super.damage=15.0;
		super.ImageID="Images//bullet//basicbullet.png";
		//�Ƕ���ʱ���趨
	}

	@Override
	public boolean update() {
		x=x+vx;
		y=y+vy;
		if(x>(MainGame.bm.mapx)/2||y>(MainGame.bm.mapy)/2||x<-(MainGame.bm.mapx)/2||y<-(MainGame.bm.mapy)/2)
		{//�����߽�
		return false;
		}
		return true;
	}

}
