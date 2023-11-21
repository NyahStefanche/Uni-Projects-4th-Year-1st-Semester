import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class TelNums extends Applet implements ActionListener
{
	Label myLabel=new Label("Natisni cifra");
	Button mybtn1=new Button("1");
	Button mybtn2=new Button("2");
	Button mybtn3=new Button("3");
	Button mybtn4=new Button("4");
	Button mybtn5=new Button("5");
	Button mybtn6=new Button("6");
	Button mybtn7=new Button("7");
	Button mybtn8=new Button("8");
	Button mybtn9=new Button("9");
	Button mybtn10=new Button("*");
	Button mybtn11=new Button("0");
	Button mybtn12=new Button("#");
	
	Panel mypan=new Panel();
	public void init()
	{
		setLayout(new GridLayout(0,1));
		add(myLabel);
		
		this.setFont(new Font("SansSerif",Font.BOLD,24));
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		
		mypan.setLayout(new GridLayout(4,3));
		mypan.add(mybtn1);
		mypan.add(mybtn2);
		mypan.add(mybtn3);
		mypan.add(mybtn4);
		mypan.add(mybtn5);
		mypan.add(mybtn6);
		mypan.add(mybtn7);
		mypan.add(mybtn8);
		mypan.add(mybtn9);
		mypan.add(mybtn10);
		mypan.add(mybtn11);
		mypan.add(mybtn12);
		add(mypan,BorderLayout.CENTER);
		
		mybtn1.addActionListener(this);
		mybtn2.addActionListener(this);
		mybtn3.addActionListener(this);
		mybtn4.addActionListener(this);
		mybtn5.addActionListener(this);
		mybtn6.addActionListener(this);
		mybtn7.addActionListener(this);
		mybtn8.addActionListener(this);
		mybtn9.addActionListener(this);
		mybtn10.addActionListener(this);
		mybtn11.addActionListener(this);
		mybtn12.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		myLabel.setText(e.getActionCommand());
	}
}