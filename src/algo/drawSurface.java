package algo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class drawSurface extends JComponent {
	private final int WIDTH;
	private final int HEIGHT;


	drawSurface(){
		WIDTH = 730;
		HEIGHT = 700;
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}
	
    @Override
    public void paintComponent(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
        /* Check dimensions  */
    	//g.setColor(Color.white);
    	//g2.fillRect(0, 0, WIDTH, HEIGHT);

        
        super.paintComponent(g);
    }

    
    
}
