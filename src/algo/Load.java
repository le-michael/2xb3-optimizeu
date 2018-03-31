package algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Load {
	
	//Cord data;
	//Cord maxima;
	//Cord minima;

	private Cord maxima;
	private Cord minima;
	
	HashMap<Integer,ArrayList<Cord>> data;
	
	
	public Load() {
		maxima = new Cord(Double.MIN_VALUE,Double.MIN_VALUE);
		minima = new Cord(Double.MAX_VALUE,Double.MAX_VALUE);
		
		String f = "./data/uber-raw-data-may14.csv";
		String line;
		data = new HashMap<Integer,ArrayList<Cord>>();
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			line = br.readLine();
			String[] temp;
			while ((line = br.readLine())!= null) {
				temp = line.split(",");
		
				double x = Double.parseDouble(temp[1]);
				double y = Double.parseDouble(temp[2]);
				int time = Integer.parseInt(temp[0].split(" ")[1].split(":")[0]);
				
				Cord cp = cordToPixel(x,y,750,750);
				maxima.setX(Double.max(cp.getX(), maxima.getX()));
				maxima.setY(Double.max(cp.getY(), maxima.getY()));
				minima.setX(Double.min(cp.getX(), minima.getX()));
				minima.setY(Double.min(cp.getY(), minima.getY()));
				
				System.out.println(cp.getX() + " " +cp.getY());
				if (!data.containsKey(time))
					data.put(time, new ArrayList<Cord>());
				data.get(time).add(cp);
				
				
				//pCord.setNext(new Cord(Double.parseDouble(temp[1]),Double.parseDouble(temp[2])));
				//pCord = pCord.getNext();
				//System.out.println(pCord.toString());
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		normalizeData();
	}
	
	public HashMap<Integer,ArrayList<Cord>> getData(){
		return data;
	}
	
	private void normalizeData() {
		for (int time : data.keySet()) {
			for (Cord i : data.get(time)) {
				i.setX(((i.getX()-minima.getX())/(maxima.getX() - minima.getX()))*750);
				i.setY(((i.getY()-minima.getY())/(maxima.getY() - minima.getY()))*750);
			}
		}
	}
	
	/*

	public Cord getPixelData(int w,int h) {
		Cord head = cordToPixel(data.getX(),data.getY(),w,h);
		Cord prev = head;
		
		maxima = new Cord(head.getX(),head.getY());
		minima = new Cord(head.getX(),head.getY());
		
		for (Cord i = data.getNext(); i != null ; i = i.getNext()) {
			prev.setNext(cordToPixel(i.getX(),i.getY(),w,h));
			maxima.setX(Double.max(maxima.getX(),prev.getX()));
			minima.setX(Double.min(minima.getX(),prev.getX()));
			maxima.setY(Double.max(maxima.getY(),prev.getY()));
			minima.setY(Double.min(minima.getY(),prev.getY()));
			prev = prev.getNext();
		}
		//System.out.println("MAXIMMA MINIMA");
		//System.out.println(maxima.toString());
		//System.out.println(minima.toString());
		
		
		minima.setX(minima.getX()+minima.getX()*0.0005);
		minima.setY(minima.getY()+minima.getY()*0.0005);
		maxima.setX(maxima.getX()-maxima.getX()*0.0015);
		maxima.setY(maxima.getY()-maxima.getY()*0.0015);
		
		for (Cord i = head; i != null ; i = i.getNext()) {
			
			i.setX(((i.getX()-minima.getX())/(maxima.getX() - minima.getX()))*w);
			i.setY(((i.getY()-minima.getY())/(maxima.getY() - minima.getY()))*h);
			//System.out.println(i.toString());
		}
		
		
		return head;		
	}*/
	
	private Cord cordToPixel(double longitude, double latitude,int mapWidth,int mapHeight) {
		
		double x = (longitude + 180)*(mapWidth/360);
		double rad = latitude*Math.PI/180;
		double mat = Math.log(Math.tan(Math.PI/4)+(rad/2));
		double y = (mapHeight/2)-(mapWidth * mat/(2*Math.PI));
		return new Cord(x,y);
		
		
	}
	

	
	public static void main(String[] args) {
		Load data = new Load();
		HashMap<Integer,ArrayList<Cord>> cords = data.getData();
		for(int i = 0; i < 24; i ++) {
			System.out.println(cords.get(i).size());
		}
		ArrayList<Cord> means = KMeans.calculateMeans(10,cords.get(2).size(),cords.get(2),1000000);
		Cluster[] clusters = KMeans.assignToClusters(means,cords.get(2),10);

        DisplayClusters ex = new DisplayClusters(clusters);
        ex.setVisible(true); 
		
		
	}
		

}
