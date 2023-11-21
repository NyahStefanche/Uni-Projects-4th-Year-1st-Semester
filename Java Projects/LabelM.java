import java.awt.*;
import java.applet.*;

public class LabelM extends Applet
{
	Button btnNorth=new Button("Sever");
	Button btnSouth=new Button("Uig");
	Button btnEast=new Button("Iztok");
	Button btnWest=new Button("Zapad");
	
	public void init()
	{
		Label firstL=new Label();
		Label secondL=new Label("Tova e etiket 2.");
		Label thirdL=new Label("Tova e treti etiket",Label.CENTER);
		add(firstL);
		add(secondL);
		add(thirdL);
		
		Label myLabel=new Label("Hello, friends!!!");
		Font myFont=new Font("Serif",22,Font.PLAIN);
		myLabel.setFont(myFont);
		myLabel.setBackground(Color.green);
		myLabel.setForeground(Color.yellow);
		myLabel.setAlignment(Label.CENTER);
		add(myLabel);
		
		this.setLayout(new BorderLayout());
		add(btnNorth,BorderLayout.NORTH);
		add(btnSouth,BorderLayout.SOUTH);
		add(btnEast,BorderLayout.EAST);
		add(btnWest,BorderLayout.WEST);
		
		
	}
}