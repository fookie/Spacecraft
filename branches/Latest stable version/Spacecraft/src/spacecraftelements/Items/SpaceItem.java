package spacecraftelements.Items;

public abstract class SpaceItem {
	public String imageID;//贴图位置
	public int imagesize;//贴图大小
	public int x;
	public int y;//位置
	public int timeup=600;
	public abstract boolean getitem();
}
