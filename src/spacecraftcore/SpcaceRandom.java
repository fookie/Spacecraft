package spacecraftcore;

import java.util.Random;

public class SpcaceRandom {
	private static Random ran=null ;
	public SpcaceRandom(int r)
	{
		SpcaceRandom.ran=new Random(r);
	}
	public static double  getRandom()
	{
		return ran.nextDouble();
	}

}
