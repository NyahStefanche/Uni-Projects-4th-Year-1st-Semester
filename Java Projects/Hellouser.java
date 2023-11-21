import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Hellouser extends Applet implements ActionListener
{
	TextField txtInput=new TextField();
	Label lblOutput=new Label();
	Button btnOK=new Button("OK");
	
	public void init()
	{
		setLayout(new GridLayout(0,1));
		setFont(new Font("Serif",Font.BOLD,20));
		Panel pnlButton=new Panel();
		pnlButton.setLayout(new FlowLayout());
		pnlButton.add(btnOK);
		
		add(new Label("Vuvedete imeto si i natisnete butona OK"));
		add(txtInput);
		add(pnlButton);
		add(lblOutput);
		btnOK.addActionListener(this);
	}
	
	public void  actionPerformed(ActionEvent e)
	{
		String output="Hello, ";
		output+=txtInput.getText();
		output+="!";
		lblOutput.setText(output);
	}
}