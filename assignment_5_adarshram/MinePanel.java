import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class MinePanel extends JPanel {
    
    private MineFrame mineFrame;
    public MinePanel(MineFrame mF) 
    {
        mineFrame = mF;
        int rows = mineFrame.getModel().R;
        int cols = mineFrame.getModel().C;

        setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                add(new MineButton(i, j, mineFrame));
            }
        }
    }
}