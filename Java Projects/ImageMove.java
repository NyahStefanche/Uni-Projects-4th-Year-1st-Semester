import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ImageMove extends Applet implements ActionListener
{
	int xPos,yPos;
	Image cat;
	Button btnL,btnR;
	
	public void init()
	{
		setBackground(Color.green);
		xPos=100;
		yPos=50;
		btnL=new Button("Left");
		add(btnL);
		btnL.addActionListener(this);
		btnR=new Button("Right");
		add(btnR);
		btnR.addActionListener(this);
		cat=getImage(getDocumentBase(),"cat.png");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnL)
		{
			xPos-=10;
		}
		else
		{
			xPos+=10;
		}
		repaint();
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(cat,xPos,yPos,this);
	}
}