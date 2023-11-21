import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class MyButs extends Applet implements ActionListener
{
	Label myLabel=new Label("Koi buton e natisnat");
	Button mybtn1=new Button("Purvi");
	Button mybtn2=new Button("Vtori");
	
	public void init()
	{
		setLayout(new GridLayout(0,1));
		add(myLabel);
		add(mybtn1);
		add(mybtn2);
		
		this.setFont(new Font("SansSerif",Font.BOLD,24));
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		
		mybtn1.addActionListener(this);
		mybtn2.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		myLabel.setText(e.getActionCommand());
	}
}