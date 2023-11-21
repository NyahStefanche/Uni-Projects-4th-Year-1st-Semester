import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class FrameDemo extends Applet implements ActionListener, WindowListener
{
	Frame frmHello=new Frame("Frame DEMO");//Ime na dokumenta
	Button btnShowFrame=new Button("Show Frame");
	Button btnHideFrame=new Button("Hide Frame");
	Button mybtn1=new Button("Molq kajete DA!");
	Button mybtn2=new Button("OK");
	Label mylabel=new Label("Zdraveite!");
	
	MenuBar mymenubar=new MenuBar();
	Menu menu1=new Menu("MENU");
	Menu submenu=new Menu("Podmenu");
	MenuItem first=new MenuItem("informaciq");
	MenuItem second=new MenuItem("sudurjanie");
	MenuItem third=new MenuItem("dopulnenie");
	MenuItem sub1=new MenuItem("izbor 1");
	MenuItem sub2=new MenuItem("izbor 2");
	Dialog di=new Dialog(frmHello,"Dialog box",true);
	
	public void init()
	{
		add(btnShowFrame);
		btnShowFrame.addActionListener(this);
		
		add(btnHideFrame);
		btnHideFrame.addActionListener(this);
		
		//menu
		frmHello.setMenuBar(mymenubar);
		mymenubar.add(menu1);
		menu1.add(first);
		first.addActionListener(this);
		menu1.add(second);
		second.addActionListener(this);
		menu1.addSeparator();
		menu1.add(third);
		third.addActionListener(this);
		
		//submenu
		menu1.add(submenu);
		submenu.add(sub1);
		submenu.add(sub2);
		
		frmHello.add(mybtn1,BorderLayout.WEST);
		mybtn1.addActionListener(this);
		frmHello.setFont(new Font("Serif",Font.BOLD,22));
		frmHello.add(mylabel,BorderLayout.CENTER);
		frmHello.addWindowListener(this);
		di.add(mybtn2);
		mybtn2.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnShowFrame)
		{
			frmHello.setVisible(true);
			frmHello.setSize(400,200);
			frmHello.setLocation(200,200);
		}
		
		if(e.getSource()==btnHideFrame)
		{
			frmHello.setVisible(false);
			frmHello.dispose();
		}
		
		if(e.getSource()==mybtn1)
		{
			mylabel.setText("DA");
			di.setSize(100,100);
			di.setLocation(200,200);
			di.show();
		}
		
		if(e.getSource()==mybtn2)
		{
			di.hide();
		}
	}
	
	public void windowClosing(WindowEvent e)
	{
		frmHello.setVisible(false);
		frmHello.dispose();
	}
	
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
}