import java.awt.*;
import java.applet.*;

public class ShowPic extends Applet
{
	public void paint(Graphics g)
	{
		Image tiger=getImage(getCodeBase(),"tiger.png");
		g.drawImage(tiger,0,0,this);
		g.drawImage(tiger,700,500,300,50,this);
	}
}