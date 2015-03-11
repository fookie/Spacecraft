package displayConsole.menu;

import java.awt.Rectangle;

/**
 * 就是按钮，名字叫这个是怕和系统自带的重复<br/>
 * It's the button class. The name of it is to avoid conflict.
 * @author Hale
 */
public abstract class SButton {
	String Default;//未按上去时的状态           //The default status of button.
	String over;//鼠标在其之上                  //The cursor is over it.
	String pressed;//按下去了                   //pressed
	int status=0;//状态,0未按上,1之上,2按下去了 //Status: 0: default 1: over 2: pressed
	Rectangle buttonhitbox=new Rectangle();
	public abstract void setstatus(int s);
	public abstract String getImage();
	public abstract boolean click();
}
