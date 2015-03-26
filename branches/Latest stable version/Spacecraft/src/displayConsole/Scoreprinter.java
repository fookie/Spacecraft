package displayConsole;

import spacecraftcore.MainGame;
/**
 * show score
 * @author hale
 *
 */
public class Scoreprinter {
	public static void printscore(int s)
	{
		int posx=40;
		int now_num = 0;
		int i=0;
		MainGame.test.repainter.add_nooffset_element("Images//UI//score.png", MainGame.test.repainter.onscreenx(MainGame.bm.windowsizex-180), MainGame.test.repainter.onscreeny(0), 0, 2);
		while(s>0)
		{
			now_num=s%10;
			s=(s-now_num)/10;
			MainGame.test.repainter.add_nooffset_element("Images//UI//num//default-"+now_num+".png", MainGame.test.repainter.onscreenx(MainGame.bm.windowsizex-15-(i+1)*posx), MainGame.test.repainter.onscreeny(-55), 0, 2);
			i++;
		}
		if(MainGame.gametime%300<150){
		MainGame.test.repainter.add_nooffset_element("Images//UI//target.png", MainGame.test.repainter.onscreenx(MainGame.bm.windowsizex-250), MainGame.test.repainter.onscreeny(-110), 0, 2);
		}
		else
		{
			s=10000;
			i=0;
			while(s>0)
			{
				now_num=s%10;
				s=(s-now_num)/10;
				MainGame.test.repainter.add_nooffset_element("Images//UI//num//default-"+now_num+".png", MainGame.test.repainter.onscreenx(MainGame.bm.windowsizex-15-(i+1)*45), MainGame.test.repainter.onscreeny(-110), 0, 2);
				i++;
			}
		}
	}
}
