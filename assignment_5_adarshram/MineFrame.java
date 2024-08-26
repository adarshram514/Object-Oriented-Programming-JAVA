import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class MineFrame extends JFrame {
    private MineModel model;
    private MinePanel panel;

    public MineFrame() {
        setSize(1000,1000);
        setTitle("Minesweeper");

        model = new MineModel();
        add(new MinePanel(this));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu newMenu = new JMenu("New");
        menuBar.add(fileMenu);
        fileMenu.add(newMenu);


        JMenuItem easy = new JMenuItem("Reg Mines");
        JMenuItem med = new JMenuItem("More Mines");
        JMenuItem impos = new JMenuItem("A Lot of Mines");
        
		newMenu.add(easy);
        newMenu.add(med);
        newMenu.add(impos);
        
		easy.addActionListener(new ActionHandler("Easy"));
        med.addActionListener(new ActionHandler("Medium"));
        impos.addActionListener(new ActionHandler("Hard"));


        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem quitItem = new JMenuItem("Leave/Quit");
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(quitItem);
        saveItem.addActionListener(new ActionHandler("Save"));
        loadItem.addActionListener(new ActionHandler("Load"));
        quitItem.addActionListener(new ActionHandler("Leave/Quit"));

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class ActionHandler implements ActionListener {
        String state;
        ActionHandler(String s)
        {
            state = s;
        }

        public void actionPerformed(ActionEvent e) {
            if (state.equals("Easy"))
            {
                getModel().bombs = 10;
                model = new MineModel();
                getModel().setSquares();
            }
            if (state.equals("Medium"))
            {
                getModel().bombs = 30;
                model = new MineModel();
                getModel().setSquares();
            }
            if (state.equals("Hard"))
            {
                getModel().bombs = 99;
                model = new MineModel();
                getModel().setSquares();
            }

            if (state.equals("Save"))
            {
                JFileChooser save = new JFileChooser();
                int response = save.showSaveDialog(null);

                if (response == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        String path = save.getSelectedFile().getAbsolutePath();
                        String saveFile = path + ".ser";
                        System.out.println(saveFile);
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
                        out.writeObject(getModel());
                        out.flush();
                        out.close();
                    }
                    catch (IOException f)
                    {
                        System.out.println("File error.");
                        f.printStackTrace();
                    }
                }
            }

            if (state.equals("Load"))
            {
                JFileChooser load = new JFileChooser();
                int response = load.showOpenDialog(null);

                if (response == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        String path = load.getSelectedFile().getAbsolutePath();
                        System.out.println(path);
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
                        model = (MineModel) in.readObject();
                        repaint();
                        in.close();
                    }
                    catch (IOException f)
                    {
                        System.out.println("File error.");
                    }
                    catch (ClassNotFoundException g)
                    {
                        System.out.println("Not found");
                    }
                }
            }

            if (state.equals("Leave/Quit"))
            {
                System.exit(0);
            }

            repaint();
        }
    }
    
    public MineModel getModel()
    {
        return model;
    }
}