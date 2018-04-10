package algo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.HashMap;

import javax.swing.JComponent;
/**
 * The draw component for the GUI
 * @author Michael Le
 *
 */
public class drawSurface extends JComponent {
	private final int WIDTH;
	private final int HEIGHT;
	
	private  final HashMap<Integer,Cluster[]> clus;
	private final HashMap<Integer,Edge[]> edges;
	private HashMap<Integer,Edge[]> allEdge;
	private  int time;
	
	private boolean showMST = false;
	
	/**
	 * Create the draw surface where all data is drawn
	 * @param clusters the cluster data being passed in
	 * @param e the edges for kruskal
	 * @param ae the edges connecting all the nodes
	 * @param t the current time being drawn
	 */
	public drawSurface(HashMap<Integer,Cluster[]> clusters,HashMap<Integer,Edge[]> e,HashMap<Integer,Edge[]> ae,int t){
		allEdge = ae;
		edges = e;
		clus = clusters;
		time = t;
		WIDTH = 730;
		HEIGHT = 700;
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}
	
	/**
	 * Draw the component
	 */
    @Override
    public void paintComponent(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
        /* Check dimensions  */
    	//g.setColor(Color.white);
    	//g2.fillRect(0, 0, WIDTH, HEIGHT);

        Cluster[] current = clus.get(time);
        for(Cluster c : current) {
        	g2.setColor(c.getColor());
        	g2.draw(new Ellipse2D.Double(c.getCenter().getX(), c.getCenter().getY(), 5, 5));
        	for(Cord p : c.getPoints()) {
        		g2.draw(new Ellipse2D.Double(p.getX(), p.getY() , 5, 5));
        	}
        }
        
        g2.setColor(Color.WHITE);
        Edge[] currentEdge;
        
        if (showMST) 
	        currentEdge = edges.get(time);
        else
        	currentEdge = allEdge.get(time);
        
	        for(Edge e : currentEdge) {
	        	g2.draw(new Line2D.Double(e.first().getX(), e.first().getY(), e.second(e.first()).getX(), e.second(e.first()).getY()));
	        
        }
    	
        super.paintComponent(g);
    }
    
    public void setTime(int t) {
    	time = t;
    	repaint();
    }
    
    public void toggleMST() {
    	showMST = !showMST;
    	repaint();
    }

    
    
}
