import java.awt.*;
import java.applet.*;

public class BorderGrids extends Applet
{
	Button btnNorth=new Button("Sever");
	Button btnSouth=new Button("Uig");
	Button btnEast=new Button("Iztok");
	Button btnWest=new Button("Zapad");
	Panel mypan=new Panel();
	
	public void init()
	{
		this.setLayout(new BorderLayout());
		add(btnNorth,BorderLayout.NORTH);
		add(btnSouth,BorderLayout.SOUTH);
		add(btnEast,BorderLayout.EAST);
		add(btnWest,BorderLayout.WEST);
		
		
		mypan.setLayout(new GridLayout(2,3));
		mypan.add(new Button("1"));
		mypan.add(new Button("2"));
		mypan.add(new Button("3"));
		mypan.add(new Button("4"));
		mypan.add(new Button("5"));
		mypan.add(new Button("6"));
		add(mypan,BorderLayout.CENTER);
	}
}