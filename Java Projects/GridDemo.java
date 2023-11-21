import java.awt.*;
import java.applet.*;

public class GridDemo extends Applet
{
	public void init()
	{
		this.setLayout(new GridLayout(2,2));
		MyaddButtons();
		
	}
	public void MyaddButtons()
	{
		add(new Button("1"));
		add(new Button("2"));
		add(new Button("3"));
		add(new Button("4"));
		
	}
}