package spacecraftTest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SpaceEditor {
	final static int minsize = 10;// 区块大小 //单位大小
	static int maparea[][];
	static DataOutputStream dos;

	public static void main(String[] args) {
		writemap(800, 600, "scmaps//ditu1.cmp", "Image//bg1.png"); // 生成地图
	}

	/**
	 * 参数，实际大小x,y,输出地址,背景地址
	 * 
	 * @param x
	 * @param y
	 * @param address
	 * @param bg
	 */
	public static void writemap(int x, int y, String address, String bg) {
		int ax, ay;
		try {
			dos = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(address)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ax = x / minsize;
		ay = y / minsize;
		System.out.println(ax);
		System.out.println(ay+"开始生成地图");
		maparea = new int[ax][ay];
		for (int column = 0; column < ay; column++) {
			for (int row = 0; row < ax; row++) {
				maparea[row][column] = 0;
			}
			maparea[1][2] = 1;
			maparea[1][3] = 1;
			maparea[9][9] = 1;
			// 下面写入
			try {
				dos.writeUTF(bg);// 先写背景位置
				dos.writeInt(ax);// 格子数
				dos.writeInt(ay);
				dos.writeInt(x);// 写入实际大小
				dos.writeInt(y);
				dos.writeInt(minsize);//写入区块大小
				for (column = 0; column < ay; column++) {
					for (int row = 0; row < ax; row++) {
						dos.writeInt(maparea[row][column]);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				dos.flush();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("完成");
		}
	}
}
