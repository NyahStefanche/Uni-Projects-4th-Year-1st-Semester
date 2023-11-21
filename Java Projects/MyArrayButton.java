import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class MyArrayButton extends Applet implements ActionListener
{
	Label mylabel=new Label("Koi buton e natisnat?");
	Button mybuttons[]=new Button[9];
	
	public void init()
	{
		for(int i=0; i<9; i++)
		{
			mybuttons[i]=new Button("Button " +i);
			add(mybuttons[i]);
			mybuttons[i].addActionListener(this);
		}
		this.setFont(new Font("SansSerif",Font.BOLD,20));
		mylabel.setAlignment(Label.CENTER);
		mylabel.setBackground(Color.yellow);
		add(mylabel);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		mylabel.setText(e.getActionCommand()+" e natisnat.");
	}
}