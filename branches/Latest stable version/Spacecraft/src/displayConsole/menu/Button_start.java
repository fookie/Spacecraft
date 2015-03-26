package displayConsole.menu;

import spacecraftcore.MainGame;

public class Button_start extends SButton {
	int overnum = 3;
	int status = 0;
	int f;

	public Button_start(int x, int y) {
		super.buttonhitbox.width = 150;
		super.buttonhitbox.height = 50;
		super.buttonhitbox.x = x;
		super.buttonhitbox.y = y;
		super.Default = "Images//UI//buttons//start0,0.png";
		super.over = "Images//UI//buttons//start1,";
		super.pressed = "Images//UI//buttons//start2,0.png";
	}

	public void setstatus(int s) {
		this.status = s;

	}

	@Override
	public String getImage() {
		if (status == 0) {
			return Default;
		} else if (status == 1) {
			f = (int) Math.abs((MainGame.gametime % 21) / 3 - 3);
			return over + f + ".png";
		} else {
			return pressed;
		}
	}

	@Override
	public boolean click() {
		// 展开另外两个按钮  //Expand the list of other two buttons
		MainGame.mainmenu.addbutton(new Button_survival(-320, 300));
		MainGame.mainmenu.addbutton(new Button_evasion(-320, 230));
		return false;
	}

}
