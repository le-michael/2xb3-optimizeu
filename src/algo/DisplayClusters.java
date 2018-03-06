package algo;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Surface extends JPanel implements ActionListener {

	Cluster [] clusters;
	

    public Surface(Cluster[] c) {
    	clusters = c;
    }
    private void doDrawing(Graphics g) {
    	Random rand = new Random();
        Graphics2D g2d = (Graphics2D) g;

       
        
        for(int i =0; i < clusters.length;i++) {
        	
        	g2d.setPaint(new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat()));
        	Cord tempCord = clusters[i].getCenter();
        	while (tempCord != null) {
        		g2d.fillOval((int)tempCord.getX(), (int)tempCord.getY(), 10, 10);
        		tempCord = tempCord.getNext();
        	}
        }
       
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class DisplayClusters extends JFrame {

	Cluster [] clusters;
    public DisplayClusters(Cluster[] c) {
    	clusters = c;
        initUI();
    }

    private void initUI() {

        final Surface surface = new Surface(clusters);
        add(surface);


        setTitle("Clusters");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    	
    	
    	Cluster c0 = new Cluster(100,100);
    	for (int i = 0; i < 10; i ++) {
    		c0.insertCord(new Cord(100+i*10,100+i*10));
    	}
    	
    	Cluster c1 = new Cluster(200,200);
    	for (int i = 0; i < 10; i ++) {
    		c1.insertCord(new Cord(200-i*10,200+i*10));
    	}
    	
    	Cluster[] cArr = new Cluster[2];
    	cArr[0] = c0; 
    	cArr[1] = c1;

        DisplayClusters ex = new DisplayClusters(cArr);
        ex.setVisible(true);

    }
}