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

import com.sun.org.apache.xpath.internal.operations.Bool;

class Surface extends JPanel implements ActionListener {

	/*Enviroment Variables*/
	private Cluster [] clusters;
	
	/*Draw Variables*/
	private int dispCurr;
	private int maxSize=0;

	
	
    public Surface(Cluster[] c) {
    	clusters = c;
    	for(int i=0; i< clusters.length;i++) {
    		maxSize += clusters[i].getSize();
    	}
    	dispCurr = 1;
    	
    }
    private void doDrawing(Graphics g) {
    	Random rand = new Random();
        Graphics2D g2d = (Graphics2D) g;

       boolean done = false;
       int count = 0;
        for(int i =0; i < clusters.length;i++) {
        	
        	g2d.setPaint(clusters[i].getColor());
        	Cord tempCord = clusters[i].getCenter();
        	while (tempCord != null) {
        		g2d.fillOval((int)tempCord.getX(), (int)tempCord.getY(), 6, 6);
        		tempCord = tempCord.getNext();
        		if (++count == dispCurr) {
        			done = true;
        			break;
        		}
        	}
        	if (done) break;
        }
       
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (dispCurr < maxSize) dispCurr ++;
        repaint();
    }
    
    
    


}

public class DisplayClusters extends JFrame {
	private Timer time;
	private int REFRESH = 100; 
	
	Cluster [] clusters;
    public DisplayClusters(Cluster[] c) {
    	clusters = c;
    	initUI();
        
    }

    private void initUI() {

        final Surface surface = new Surface(clusters);
        add(surface);
        
        time = new Timer(REFRESH, surface);
        time.start();


        setTitle("Clusters");
        setSize(750, 750);
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