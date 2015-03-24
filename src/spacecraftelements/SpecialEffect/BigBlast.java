package spacecraftelements.SpecialEffect;

/**
 * »ù´¡ÊµÌå
 */
public class BigBlast extends SpecialEffect {
	int nowid=1;
	public BigBlast(int x, int y){
		super.x = x;
		super.y = y;
		super.imagesize = 50;
		super.imageID = "Images//SpecialEffects//BigBlast//";
		super.over=false;
	}

	@Override
	public String getImage() {
		if(nowid<13)
		{
			nowid++;
			return imageID+nowid+".png";
		}
		else
		{
			super.over=true;
			return imageID+"13.png";
		}
		//upadating the imageID to regenerate different images in a row to show a blowing effect
	}

	@Override
	public boolean update() {
		return false;
	}
	}

