package displayConsole.menu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import spacecraftcore.BattleFieldManager;
import spacecraftcore.MainGame;
import spacecraftelements.Items.S_repair;
import spacecraftelements.SpaceShip.Palelin;
import spacecraftevent.RandomSlime;

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
		Dimension srcDim = Toolkit.getDefaultToolkit().getScreenSize();
		MainGame.bm = new BattleFieldManager(srcDim.width,srcDim.height);
		MainGame.test=MainGame.bm.loadmap("Data//scmaps//testmap1600x1200.smp");
		//加载躲子弹模式要素
		MainGame.bm.add(new Palelin(0,0,0,0));
		MainGame.bm.add(new S_repair(400,400));
		MainGame.bm.add(new S_repair(400,-400));
		MainGame.bm.add(new S_repair(-400,400));
		MainGame.bm.add(new S_repair(-400,-400));
		
		MainGame.bm.paused=!MainGame.bm.paused;
		MainGame.bm.paused=!MainGame.bm.paused;
		MainGame.test.repainter.add_nooffset_element("Images//UI//paused400x250.png",-200,75, 0, 0);
		MainGame.test.repainter.repaint();
		MainGame.test.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		MainGame.gamestatus=1;
		MainGame.mainmenu.setVisible(false);
		return true;
	}

}
