package displayConsole.menu;

import spacecraftcore.MainGame;

public class Button_start extends SButton{
	int overnum=3;
	int status=0;
	public Button_start(int x,int y)
	{
		super.buttonhitbox.width=150;
		super.buttonhitbox.height=40;
		super.buttonhitbox.x=x;
		super.buttonhitbox.y=y;
		super.Default="Images//UI//buttons//start0,0.png";
		super.over="Images//UI//buttons//start1,";
		super.pressed="Images//UI//buttons//start2,0.png";
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
			return over+MainGame.gametime%3+".png";
		}
		else
		{
			return pressed;
		}
	}

}
