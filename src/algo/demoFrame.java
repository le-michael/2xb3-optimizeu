package algo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class demoFrame extends javax.swing.JFrame{
	private final JSplitPane split;
	private final JPanel leftPanel;
	private final JPanel rightPanel;
	
	private final JButton forward;
	private final JButton backward;

	private final drawSurface drawPanel;
	private final int compWidth;
	private final int compHeight;
	
	private int time=0;
	
	public demoFrame() {
		
		
		compWidth = 200;
		compHeight = 20;
		
		drawPanel = new drawSurface();
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
		
		JLabel currentTime = new JLabel("Current Time: ", SwingConstants.CENTER);
		currentTime.setBounds(15,100, compWidth,compHeight);
		JLabel timeText = new JLabel(String.valueOf(time) + " : 00",SwingConstants.CENTER);
		timeText.setBounds(15,120, compWidth,compHeight);
		rightPanel.add(currentTime);
		rightPanel.add(timeText);
		
		
        forward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	time = (time +1)%24;
            	timeText.setText(time + " : 00");
            	System.out.println(time);
            }
        });
        
        backward.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		time -= 1;
        		if (time == -1)
        			time = 23;
        		timeText.setText(time + " : 00");
        	}
        });
	    pack();
	}
	
	public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new demoFrame().setVisible(true);
            }
        });
	}
	

}
