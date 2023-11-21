import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Doublevalue extends Applet //Rice
{
	public void paint(Graphics g)
	{
		int brK=0;
		long zurnoKv=1;
		long Zurna=0;
		int y=20;
		
		do
		{
			brK++;
			g.drawString("Kvadrat " + brK + " sudurja " + zurnoKv + " zrynca oriz.",10,y);
			Zurna=Zurna+zurnoKv;
			zurnoKv=zurnoKv*2;
			y=y+20;
		}while(Zurna<100);
		g.drawString("Neobhodimiq broi kvadrati e: " + brK,10,y+20);
		g.drawString("Neobhodimiq broi zrynca ORIZ e: " + Zurna,10,y+40);
	}
}