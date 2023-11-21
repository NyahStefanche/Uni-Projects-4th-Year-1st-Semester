import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;

public class MyShop extends Applet implements ActionListener
{
	ArrayList basket=new ArrayList();
	TextArea myWants=new TextArea(6, 20);
	Button mybuttons[]=new Button[6];
	Panel mypanels[]=new Panel[6];
	Label myItems[]=new Label[6];
	String descriptions[]=new String[6];
	String contents=new String();
	Button show=new Button("Kolichka:");
	
	public void init()
	{
		for (int i=0; i<6; i++)
		{
			mybuttons[i]=new Button("Dobavi");
			myItems[i]=new Label();
			mypanels[i]=new Panel();
			descriptions[i]=new String();
			
			mypanels[i].add(myItems[i]);
			mypanels[i].add(mybuttons[i]);
			add(mypanels[i]);
			mybuttons[i].addActionListener(this);
		}
		show.addActionListener(this);
		
		descriptions[0]="Kafe Lavaca $2.99";
		descriptions[1]="Chasha voda $2.00";
		descriptions[2]="Fresh $5.10";
		descriptions[3]="Frenski kroasan $11.50";
		descriptions[4]="Angliiska zakuska $33.75";
		descriptions[5]="Dimple 50ml $50.00";
		
		for(int i=0; i<6;i++)
		{
			myItems[i].setText(descriptions[i]);
		}
		add(show);
		
		this.setFont(new Font("SansSerif",Font.BOLD,20));
		add(myWants);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Button clicked=(Button)(e.getSource());
		for(int i=0;i<6; i++)
		{
			if(mybuttons[i].equals(clicked))
			{
				basket.add(descriptions[i]);
			}
		}
		
		if (clicked.equals(show))
		{
			for(int j=0; j<basket.size();j++)
			{
				contents+=(String)basket.get(j);
				contents+="\n";
			}
		}
		myWants.setText(contents);
	}
}