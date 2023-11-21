import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class MyComponents extends Applet implements ItemListener
{
	Label mylabel=new Label("Vie ste: ");
	String myresponse="Ti si ";
	Checkbox mlad=new Checkbox("mlad");
	Checkbox simpatichen=new Checkbox("simpatichen");
	Checkbox bogat=new Checkbox("bogat");
	
	CheckboxGroup gender=new CheckboxGroup();
	Checkbox muj=new Checkbox("Muj",gender,true);
	Checkbox jena=new Checkbox("jena",gender,false);
	
	public void init()
	{
		add(mylabel);
		add(mlad);
		add(simpatichen);
		add(bogat);
		add(muj);
		add(jena);
		
		mlad.addItemListener(this);
		simpatichen.addItemListener(this);
		bogat.addItemListener(this);
		muj.addItemListener(this);
		jena.addItemListener(this);
		
		this.setFont(new Font("Serif",Font.BOLD,22));
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		myresponse="Ti si ";
		if(mlad.getState()==true)
		{
			myresponse+=" mlad ";
		}
		
		if(simpatichen.getState()==true)
		{
			myresponse+=" simpatichen ";
		}
		
		if(bogat.getState()==true)
		{
			myresponse+=" bogat ";
		}
		
		myresponse+=gender.getSelectedCheckbox().getLabel();
		repaint();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
		g.drawString(myresponse,50,150);
	}
}