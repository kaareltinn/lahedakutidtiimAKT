import javax.swing.JFrame;

public class IDE extends JFrame{
	
	public IDE(){		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Content());
		pack();
		setVisible(true);
	}
}