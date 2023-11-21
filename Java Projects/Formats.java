import java.awt.*;
import java.applet.*;
import java.text.*;
import java.util.*;

public class Formats extends Applet
{
	Label show=new Label("		");
	
	public void init()
	{
		add(show);
		NumberFormat P=NumberFormat.getCurrencyInstance(Locale.US);
		String num=P.format(3.7894*1.65);
		show.setText(num);
	}
}