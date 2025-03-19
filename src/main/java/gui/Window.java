package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Window
{
    JFrame frame = new JFrame();
    MyCanvas canvas = new MyCanvas();

    public Window()
    {
        canvas.setPreferredSize(new Dimension(800, 600));
        canvas.setMaximumSize(new Dimension(800, 600));
        frame.add(canvas);

        frame.setSize(800, 600);
        frame.setMaximumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void add(Paintable paintable)
    {
        this.canvas.add(paintable);
    }

    public void remove(Paintable paintable)
    {
        this.canvas.remove(paintable);
    }
}

class MyCanvas extends Canvas
{
    Set<Paintable> paintables = new HashSet<>();

    public void add(Paintable paintable)
    {
        paintables.add(paintable);
    }

    public void remove(Paintable paintable)
    {
        paintables.remove(paintable);
    }

    @Override
    public void paint(Graphics g)
    {
        synchronized (g)
        {
            for(Paintable paintable : paintables)
                paintable.paint(g);
        }
    }
}
