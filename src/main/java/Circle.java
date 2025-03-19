import gui.Paintable;

import java.awt.*;

public class Circle implements Paintable {

    @Override
    public void paint(Graphics g) {
        g.drawOval(30,30,40,40);
    }
}
