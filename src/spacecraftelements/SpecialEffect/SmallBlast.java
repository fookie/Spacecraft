package spacecraftelements.SpecialEffect;

/**
 * Ð¡±¬Õ¨ÌØÐ§
 */
public class SmallBlast extends SpecialEffect {
	int nowid=1;
	public SmallBlast(double x, double y){
		super.x = (int)x;
		super.y = (int)y;
		super.imagesize = 15;
		super.imageID = "Images//SpecialEffects//SmallBlast//";
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
		
	}

	@Override
	public boolean update() {
		return false;
	}
	}

