import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class mathActions extends Applet implements ActionListener
{
	TextField x=new TextField();
	TextField y=new TextField();
	Button result=new Button("Resultat");
	Label lblAnswer1=new Label();
	Label lblAnswer2=new Label();
	Panel pnlSouth=new Panel();
	Panel pnlCenter=new Panel();
	
	public void init()
	{
		setLayout(new BorderLayout());
		add(pnlCenter,BorderLayout.CENTER);
		add(pnlSouth,BorderLayout.SOUTH);
		setFont(new Font("SansSerif",Font.BOLD,20));
		
		pnlCenter.setLayout(new GridLayout(4,2));
		pnlCenter.add(new Label("X = "));
		pnlCenter.add(x);
		pnlCenter.add(new Label("Y = "));
		pnlCenter.add(y);
		pnlCenter.add(new Label("X + Y = "));
		pnlCenter.add(lblAnswer1);
		pnlCenter.add(new Label("X * Y = "));
		pnlCenter.add(lblAnswer2);
		
		pnlSouth.setLayout(new FlowLayout());
		pnlSouth.add(result);
		result.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int x1=Integer.parseInt(x.getText()); //transforms text to int
		int y1=Integer.parseInt(y.getText()); //transforms text to int
		String result1=String.valueOf(x1+y1);
		String result2=String.valueOf(x1*y1);
		lblAnswer1.setText(result1);
		lblAnswer2.setText(result2);
	}
}