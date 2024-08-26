import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

    public class MessagePanel extends JPanel {

        public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillRoundRect(100, 100, 100, 150, 30, 30);
        g.setColor(Color.red);
        g.fillArc(100, 50, 100, 100, 0, 180);
        g.setColor(Color.BLACK);
        g.drawString("My Bottle", 135, 190);
    }
}