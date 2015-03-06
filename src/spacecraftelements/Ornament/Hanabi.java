package spacecraftelements.Ornament;

/**
 * »ù´¡ÊµÌå
 */
public class Hanabi extends Ornament {
	int nowid=1;
	public Hanabi(int x, int y){
		super.x = x;
		super.y = y;
		super.imagesize = 202;
		super.imageID = "Images//hp//";
		super.over=false;
	}

	@Override
	public String getImage() {
		if(nowid<14)
		{
			nowid++;
			return imageID+nowid+".png";
		}
		else
		{
			super.over=true;
			return imageID+"13.png";
		}
		
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
	}

