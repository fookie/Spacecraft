package spacecraftelements.SpecialEffect;

/**
 * »ù´¡ÊµÌå
 */
public class SmallBlast extends SpecialEffect {
	int nowid=1;
	public SmallBlast(int x, int y){
		super.x = x;
		super.y = y;
		super.imagesize = 15;
		super.imageID = "Images//SpecialEffects//SmallBlast//";
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
		
	}

	@Override
	public boolean update() {
		return false;
	}
	}

