package displayConsole.menu;

import spacecraftcore.MainGame;

public class Button_story extends SButton{
	int overnum=3;
	int status=0;
	int f;
	public Button_story(int x,int y)
	{
		super.buttonhitbox.width=150;
		super.buttonhitbox.height=40;
		super.buttonhitbox.x=x;
		super.buttonhitbox.y=y;
		super.Default="Images//UI//buttons//story0,0.png";
		super.over="Images//UI//buttons//story1,";
		super.pressed="Images//UI//buttons//story0,0.png";
	}
	public void setstatus(int s) {
		this.status=s;
		
	}
	@Override
	public String getImage() {
		if(status==0)
		{
			return Default;
		}
		else if(status==1)
		{
			if(MainGame.gametime%12==0)
			{
				f=0;
			}
			else if(MainGame.gametime%12==6)
			{
				f=1;
			}
			
			return over+f+".png";
		}
		else
		{
			return pressed;
		}
	}
	@Override
	public boolean click() {
		//展开另外两个按钮
		return false;
	}

}
