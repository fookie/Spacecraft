package displayConsole.menu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import spacecraftcore.BattleFieldManager;
import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Evasion.Kamikaze;
import spacecraftelements.Enemy.Evasion.KochiyaSanae;
import spacecraftelements.Enemy.Evasion.Stigis;
import spacecraftelements.Enemy.Evasion.horizonslider;
import spacecraftelements.Items.S_repair;
import spacecraftelements.SpaceShip.Palelin;

public class Button_evasion extends SButton{
	int overnum=3;
	int status=0;
	int f;
	public Button_evasion(int x,int y)
	{
		super.buttonhitbox.width=150;
		super.buttonhitbox.height=40;
		super.buttonhitbox.x=x;
		super.buttonhitbox.y=y;
		super.Default="Images//UI//buttons//evasion0,0.png";
		super.over="Images//UI//buttons//evasion1,";
		super.pressed="Images//UI//buttons//evasion0,0.png";
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
			return over+0+".png";
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
		MainGame.test=MainGame.bm.loadmap("Data//scmaps//spacemap1.smp");
		//加载躲子弹模式要素 //Load the elements of Evasion mode.
		MainGame.bm.add(new Palelin(0,0,0,0));
		MainGame.bm.add(new S_repair(400,400));
		MainGame.bm.add(new S_repair(400,-400));
		MainGame.bm.add(new S_repair(-400,400));
		MainGame.bm.add(new S_repair(-400,-400));		
		MainGame.bm.add(new Kamikaze(400, -200, (int) (MainGame.bm.windowsizex * 0.7),(int) (MainGame.bm.windowsizey * 0.7)));
		//MainGame.bm.add(new horizonslider(300,300,(int) (MainGame.bm.windowsizex * 0.7),(int) (MainGame.bm.windowsizey * 0.7)));
		MainGame.bm.add(new KochiyaSanae(400, -200, (int) (MainGame.bm.windowsizex * 0.7),(int) (MainGame.bm.windowsizey * 0.7)));
		MainGame.nowdiff=0;
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
