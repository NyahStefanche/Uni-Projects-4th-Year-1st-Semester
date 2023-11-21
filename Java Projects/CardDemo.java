import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class CardDemo extends Applet implements ActionListener
{
	Panel pnlControls=new Panel();
	Button btnF=new Button("|<<");
	Button btnPr=new Button("<==");
	Button btnC=new Button("C");
	Button btnNt=new Button("==>");
	Button btnL=new Button(">>|");
	
	
	Panel pnlCards=new Panel();
	CardLayout sta=new CardLayout();
	Label lblA=new Label("A");
	Label lblB=new Label("B");
	Label lblC=new Label("C");
	Label lblD=new Label("D");
	Label lblE=new Label("E");
	
	public void init()
	{
		this.setLayout(new BorderLayout());
		this.add(pnlControls,BorderLayout.SOUTH);
		this.add(pnlCards,BorderLayout.CENTER);
		
		pnlControls.setFont(new Font("Serif",Font.BOLD,25));
		pnlControls.setLayout(new FlowLayout());
		pnlControls.add(btnF);
		pnlControls.add(btnPr);
		pnlControls.add(btnC);
		pnlControls.add(btnNt);
		pnlControls.add(btnL);
		
		btnF.addActionListener(this);
		btnPr.addActionListener(this);
		btnC.addActionListener(this);
		btnNt.addActionListener(this);
		btnL.addActionListener(this);
		
		pnlCards.setLayout(sta);
		pnlCards.setFont(new Font("Serif",Font.BOLD,60));
		pnlCards.add(lblA,"cardA");
		pnlCards.add(lblB,"cardB");
		pnlCards.add(lblC,"cardC");
		pnlCards.add(lblD,"cardD");
		pnlCards.add(lblE,"cardE");
		
		lblA.setAlignment(Label.CENTER);
		lblB.setAlignment(Label.CENTER);
		lblC.setAlignment(Label.CENTER);
		lblD.setAlignment(Label.CENTER);
		lblE.setAlignment(Label.CENTER);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String theCommand=e.getActionCommand();
		if(theCommand.equals("|<<"))
		{
			sta.first(pnlCards);
		}
		else if (theCommand.equals("<=="))
		{
			sta.previous(pnlCards);
		}
		else if (theCommand.equals("C"))
		{
			sta.show(pnlCards,"cardC");
		}
		else if (theCommand.equals("==>"))
		{
			sta.next(pnlCards);
		}
		else if (theCommand.equals(">>|"))
		{
			sta.last(pnlCards);
		}
	}
}