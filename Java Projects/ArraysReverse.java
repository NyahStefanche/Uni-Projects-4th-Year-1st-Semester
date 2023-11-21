import java.util.Arrays;

public class ArraysReverse
{
	public static void main(String[] args)
	{
		int[] array=new int[]{1,2,3,4,5};
		int len=array.length;
		int[] reversed=new int[len];
		for(int i=0; i<len;i++)
		{
			reversed[len-i-1]=array[i];
		}
		System.out.println(Arrays.toString(reversed));
	}
}