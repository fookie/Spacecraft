package displayConsole.menu;

import java.awt.Rectangle;

/**
 * 就是按钮，名字叫这个是怕和系统自带的重复
 * @author Hale
 */
public abstract class SButton {
	String Default;//未按上去时的状态
	String over;//鼠标在其之上
	String pressed;//按下去了
	int status=0;//状态,0未按上,1之上,2按下去了
	Rectangle buttonhitbox=new Rectangle();
	public abstract void setstatus(int s);
	public abstract String getImage();
	public abstract boolean click();
}
