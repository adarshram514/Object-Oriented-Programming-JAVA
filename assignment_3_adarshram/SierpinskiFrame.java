import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class SierpinskiFrame extends JFrame {
   
   public SierpinskiFrame() {
       
       setTitle("Sierpinski Triangles");
       Toolkit kit = Toolkit.getDefaultToolkit();
       Dimension screenSize = kit.getScreenSize();
       setSize(screenSize.width, screenSize.height);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       SierpinskiPanel panel = new SierpinskiPanel();
       add(panel);
       setVisible(true);
   }
}