import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class MyComponents1 extends Applet implements ItemListener
{
	Label mylabel=new Label("Vie ste: ");
	String myresponse="Ti si ";
	Checkbox mlad=new Checkbox("mlad");
	Checkbox simpatichen=new Checkbox("simpatichen");
	Checkbox bogat=new Checkbox("bogat");
	
	CheckboxGroup gender=new CheckboxGroup();
	Checkbox muj=new Checkbox("Muj",gender,true);
	Checkbox jena=new Checkbox("jena",gender,false);
	
	Panel mypanel1=new Panel();
	Panel mypanel2=new Panel();
	Panel mypanel3=new Panel();
	Panel mypanel4=new Panel();
	
	Choice myrelax=new Choice();
	
	public void init()
	{
		mypanel2.add(mylabel);
		mypanel2.add(mlad);
		mypanel2.add(simpatichen);
		mypanel2.add(bogat);
		
		mypanel1.add(mypanel2);
		
		mypanel3.add(muj);
		mypanel3.add(jena);
		
		mypanel1.add(mypanel3);
		
		mypanel4.add(new Label("Haresvate li da "));
		myrelax.add("se hranite");
		myrelax.add("piete kafe");
		myrelax.add("slushate muzica");
		myrelax.add("uchite java");
		mypanel4.add(myrelax);
		mypanel1.add(mypanel4);
		
		add(mypanel1);
		mypanel1.setLayout(new GridLayout(3,1));
		
		mlad.addItemListener(this);
		simpatichen.addItemListener(this);
		bogat.addItemListener(this);
		muj.addItemListener(this);
		jena.addItemListener(this);
		myrelax.addItemListener(this);
		
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
		
		myresponse+=" i haresvash ";
		myresponse+=myrelax.getSelectedItem();
		
		repaint();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
		g.drawString(myresponse,50,150);
	}
}