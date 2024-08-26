import javax.swing.JFrame;

    public class MessageFrame {
    public MessageFrame() {

    MessagePanel messagePanel = new MessagePanel();
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Message in a Bottle");
    frame.setSize(300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(messagePanel);
    frame.setVisible(true);
    }
}