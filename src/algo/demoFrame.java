package algo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

/**
 * Create a GUI to display the data calculated by the algorithms of OptimizeU 
 * @author Michael Le
 *
 */

public class demoFrame extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	private final JSplitPane split;
	private final JPanel leftPanel;
	private final JPanel rightPanel;
	
	private final JButton forward;
	private final JButton backward;

	private final drawSurface drawPanel;
	private final int compWidth;
	private final int compHeight;
	
	private int time=0;
	
	private HashMap<Integer,Cluster[]> clus; 
	private HashMap<Integer,Edge[]> edges;
	private HashMap<Integer,Edge[]> allEdge;
	HashMap<Integer,ArrayList<Cord>> cords;
	
	/**
	 * A constructor to generate the GUI of OptimizeU 
	 * @param clusters the cluster data being passed in
	 * @param e the edges for kruskal
	 * @param ae the edges connecting all the nodes
	 * @param c	the data storing all the points for a given time  
	 */
	public demoFrame(HashMap<Integer,Cluster[]> clusters,
					HashMap<Integer,Edge[]> e,
					HashMap<Integer,Edge[]> ae,
					HashMap<Integer,ArrayList<Cord>> c) {
		
		cords = c;
		allEdge = ae;
		edges = e;
		clus = clusters;
		compWidth = 200;
		compHeight = 20;
		
		drawPanel = new drawSurface(clus,edges,allEdge,time);
		split = new JSplitPane();
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		
		/* Control Buttons */
		forward = new JButton("Foward");
		backward = new JButton("Backward");
		
		setPreferredSize(new Dimension(1000,750));
		getContentPane().setLayout(new GridLayout());
		getContentPane().setBackground(Color.black);
		getContentPane().add(split);
		
		split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		split.setDividerLocation(750);                    // the initial position of the divider is 200 (our window is 400 pixels high)

	    split.setLeftComponent(leftPanel);
	    split.setRightComponent(rightPanel);
	    leftPanel.setBackground(Color.black);
	    
	    /* adding drawing surface */
		leftPanel.add(drawPanel);
		
		/* Add button */
		rightPanel.setLayout(null);
		int buttonVertical = 600;
		forward.setBounds(15, buttonVertical,compWidth,compHeight);
		backward.setBounds(15,buttonVertical+30,compWidth,compHeight);
		rightPanel.add(forward);
		rightPanel.add(backward);

		/* Text */
		JLabel timeControl = new JLabel("Time Control", SwingConstants.CENTER);
		timeControl.setBounds(15,buttonVertical-30, compWidth,compHeight);
		rightPanel.add(timeControl);
		JLabel location = new JLabel("Location:",SwingConstants.CENTER);
		location.setBounds(15,50, compWidth,compHeight);
		JLabel city = new JLabel("New York City",SwingConstants.CENTER);
		city.setBounds(15,70, compWidth,compHeight);
		rightPanel.add(location);
		rightPanel.add(city);
		
		JLabel optimize = new JLabel("Optimize",SwingConstants.CENTER);
		optimize.setBounds(15,buttonVertical-90,compWidth,compHeight);
		rightPanel.add(optimize);
		JButton showMST = new JButton("Show MST");
		showMST.setBounds(15,buttonVertical-60,compWidth,compHeight);
		rightPanel.add(showMST);
		
		JLabel currentTime = new JLabel("Current Time: ", SwingConstants.CENTER);
		currentTime.setBounds(15,100, compWidth,compHeight);
		JLabel timeText = new JLabel(String.valueOf(time) + " : 00",SwingConstants.CENTER);
		timeText.setBounds(15,120, compWidth,compHeight);
		rightPanel.add(currentTime);
		rightPanel.add(timeText);
		
		JLabel avgPickup = new JLabel ("Average Pickup: ",SwingConstants.CENTER);
		avgPickup.setBounds(15,150,compWidth,compHeight);
		rightPanel.add(avgPickup);
		

		JLabel avgValue = new JLabel ( String.valueOf(cords.get(time).size()/24.0),SwingConstants.CENTER);
		avgValue.setBounds(15,170,compWidth,compHeight);
		rightPanel.add(avgValue);
		
		
		
		
		showMST.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.toggleMST();
			}
		});
		
        forward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	time = (time +1)%24;
            	drawPanel.setTime(time);
            	timeText.setText(time + " : 00");
            	avgValue.setText( String.valueOf(cords.get(time).size()/24.0));
       
            }
        });
        
        backward.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		time -= 1;
        		if (time == -1)
        			time = 23;
        		drawPanel.setTime(time);
        		timeText.setText(time + " : 00");
        		avgValue.setText( String.valueOf(cords.get(time).size()/24.0));
        	}
        });
	    pack();
	}
	
	public static void main(String args[]) {
		
		Load data = new Load();
		
		HashMap<Integer,Cluster[]> clus = new HashMap<Integer,Cluster[]>();
		HashMap<Integer,Edge[]> edges = new HashMap<Integer,Edge[]>(); 
		HashMap<Integer,Edge[]> allEdge = new HashMap<Integer,Edge[]>();
		
		
		HashMap<Integer,ArrayList<Cord>> cords = data.getData();
		
		int numClusters = 10;
		
		System.out.println(cords.size());
		ArrayList<Cord> centroids = new ArrayList<Cord>();
		for(int i = 0;i<24;i++) {
			centroids.clear();
			ArrayList<Cord> means = KMeans.calculateMeans(numClusters,cords.get(i).size(),cords.get(i),1000000);
			Cluster[] clusters = KMeans.assignToClusters(means,cords.get(i),numClusters);
			
			
			for(Cluster c: clusters) {
				centroids.add(c.getCenter());
				
			}
			Graph G = new Graph(centroids.size(),centroids);
			KruskalMST K = new KruskalMST(G);
			allEdge.put(i, G.edges());
			edges.put(i, K.getEdges());
			clus.put(i, clusters);
		}
		
		
		
		
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new demoFrame(clus,edges,allEdge,cords).setVisible(true);
            }
        });
	}
	

}
