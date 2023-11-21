import java.util.Random;
public class Random649
{
	public static void main(String[] args)
	{
		Random ran=new Random();
		for (int i=0; i<6; i++)
		{
			int number=ran.nextInt(49);
			System.out.printf(number+" ");
		}
	}
}