import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Circles1 extends Applet implements ActionListener
{
	private int diametur=20;
	private Button Little,Large;
	
	public void init()
	{
		Little=new Button("Little");
		add(Little);
		Little.addActionListener(this);
		Large=new Button("Large");
		add(Large);
		Large.addActionListener(this);
	}
	
	public void paint(Graphics g)
	{
		g.drawOval(50,50,diametur,diametur);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Little)
		{
			diametur-=10;
		}
		if(e.getSource()==Large)
		{
			diametur+=10;
		}
		repaint();
	}
}