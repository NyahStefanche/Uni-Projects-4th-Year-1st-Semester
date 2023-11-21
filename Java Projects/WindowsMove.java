import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class WindowsMove extends Applet implements AdjustmentListener
{
	private Scrollbar slider;
	private int sliderValue,a,b;
	Panel mypanel;
	
	public void init()
	{
		this.setLayout(new BorderLayout());
		mypanel=new Panel();
		add(mypanel,BorderLayout.WEST);
		slider=new Scrollbar(Scrollbar.VERTICAL,0,1,0,250);
		add(slider,BorderLayout.EAST);
		slider.addAdjustmentListener(this);
	}
	
	public void paint(Graphics g)
	{
		g.drawRect(40,10,60,100);
		g.drawRect(110,10,60,100);
		g.drawRect(40,120,60,100);
		g.drawRect(110,120,60,100);
		g.setColor(Color.green);
		if(slider.getValue()<100)
		{
			a=slider.getValue();
			b=0;
		}
		else
		{
			a=100;
			b=slider.getValue()-110;
		}
		
		g.fillRect(40,10,60,a);
		g.fillRect(110,10,60,a);
		g.fillRect(40,120,60,b);
		g.fillRect(110,120,60,b);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		repaint();
		
	}
}