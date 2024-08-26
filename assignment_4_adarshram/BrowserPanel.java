import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class BrowserPanel extends JPanel {
	BrowserFrame frame;

	JTextArea textArea;
	JTextField urlTextField;
	JScrollPane scrollPane;
		public BrowserPanel() {
		
		super();
		setLayout(new BorderLayout());
		urlTextField = new JTextField();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane = new JScrollPane(textArea);
		urlTextField.addActionListener(e -> urlHandle());
		add(urlTextField, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);
	
	}

	public void urlHandle(){
		String line;
		String total = "";
	try {
            Socket socket = new Socket(urlTextField.getText(), 80);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.print("GET / HTTP/1.1\r\n");
            out.print("host: "+urlTextField.getText()+"\r\n\r\n");
            out.flush();
            while((line = in.readLine()) != null ){
                total = total+"\n"+line;
            }
            textArea.setText(render(total));
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	public String render(String line){
		String[] str = line.split("<body>");
		String[] str1 = str[1].split("</body>");
		return str1[0];
	}
	public void setFrame(BrowserFrame frame) {
	this.frame = frame;
	}
}