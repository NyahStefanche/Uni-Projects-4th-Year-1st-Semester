import java.util.Random;
public class RandomFor
{
	public static void main(String[] args)
	{
		Random ran=new Random();
		float sum=0;
		for (int i=0; i<5; i++)
		{
			float x=ran.nextFloat();
			sum+=x;
			System.out.println("\tx = "+x + "\t\tsum= "+sum);
		}
	}
}