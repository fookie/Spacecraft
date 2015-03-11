package displayConsole.menu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import spacecraftcore.BattleFieldManager;
import spacecraftcore.MainGame;
import spacecraftelements.Items.H_bulletblast;
import spacecraftelements.SpaceShip.Palelin;
import spacecraftevent.RandomBigSlime;
import spacecraftevent.RandomSlime;

public class Button_survival extends SButton{
	int status=0;
	int f;
	public Button_survival(int x,int y)
	{
		super.buttonhitbox.width=150;
		super.buttonhitbox.height=40;
		super.buttonhitbox.x=x;
		super.buttonhitbox.y=y;
		super.Default="Images//UI//buttons//survival0,0.png";
		super.over="Images//UI//buttons//survival1,0.png";
		super.pressed="Images//UI//buttons//survival0,0.png";
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
			return over;
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
		//加载生存模式要素      //Load the elements of survival mode
		MainGame.bm.add(new Palelin(0,0,0,0));
		MainGame.bm.add(new RandomSlime(1600,1200));
		MainGame.bm.add(new RandomBigSlime(1600,1200));
		MainGame.bm.add(new H_bulletblast(400,400));
		MainGame.bm.add(new H_bulletblast(400,-400));
		MainGame.bm.add(new H_bulletblast(-400,400));
		MainGame.bm.add(new H_bulletblast(-400,-400));
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
