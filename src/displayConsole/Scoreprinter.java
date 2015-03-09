package displayConsole;

import spacecraftcore.MainGame;

public class Scoreprinter {
	public static void printscore(int s)
	{
		int posx=54;
		int now_num = 0;
		int i=0;
		while(s>0)
		{
			now_num=s%10;
			s=(s-now_num)/10;
			MainGame.test.repainter.add_nooffset_element("Images//UI//num//default-"+now_num+".png", MainGame.test.repainter.onscreenx(MainGame.bm.windowsizex-(i+1)*posx), MainGame.test.repainter.onscreeny(-50), 0, 2);
			i++;
		}
	}
}
