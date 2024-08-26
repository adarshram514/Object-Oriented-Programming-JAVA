import javax.swing.*;
import java.awt.*;

public class BrowserFrame extends JFrame {
	public String enteredURL = "";
		
		BrowserFrame(){
		setTitle("Browser");
		setSize(800, 800);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		BrowserPanel browserPanel = new BrowserPanel();
		browserPanel.setFrame(this);
		add(browserPanel);
		setVisible(true);
	}
}