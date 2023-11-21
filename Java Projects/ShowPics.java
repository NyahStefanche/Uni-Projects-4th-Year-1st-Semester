import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ShowPics extends Applet implements ActionListener
{
	Canvas theCanvas=new Canvas();
	Button btn1=new Button("Show TIGER");
	Button btn2=new Button("Show CAT");
	
	public void init()
	{
		add(theCanvas);
		theCanvas.setSize(700,700);
		add(btn1);
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		Graphics g=theCanvas.getGraphics();
		if(e.getSource()==btn1)
		{
			Image tiger=getImage(getCodeBase(),"tiger.png");
			g.drawImage(tiger,0,0,this);
		}
		else
		{
			Image cat=getImage(getCodeBase(),"cat.png");
			g.drawImage(cat,0,0,this);
		}
	}
}
