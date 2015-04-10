package spacecraftelements.SpecialEffect;

/**
 * ´ó±¬Õ¨ÌØÐ§
 */
public class BigBlast extends SpecialEffect {
	int nowid=1;
	public BigBlast(double x, double y){
		super.x = (int) x;
		super.y = (int) y;
		super.imagesize = 50;
		super.imageID = "Images//SpecialEffects//BigBlast//";
		super.over=false;
	}

	@Override
	public String getImage() {
		if(nowid<26)
		{
			nowid++;
			return imageID+nowid/2+".png";
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

