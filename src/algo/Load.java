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
				
				//System.out.println(cp.getX() + " " +cp.getY());
				if (!data.containsKey(time))
					data.put(time, new ArrayList<Cord>());
				data.get(time).add(cp);
				
				
				//pCord.setNext(new Cord(Double.parseDouble(temp[1]),Double.parseDouble(temp[2])));
				//pCord = pCord.getNext();
				//System.out.println(pCord.toString());
				
			}
			br.close();
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
				i.setX(((i.getX()-minima.getX())/(maxima.getX() - minima.getX()))*730);
				i.setY(((i.getY()-minima.getY())/(maxima.getY() - minima.getY()))*700);
			}
		}
	}
	
	private Cord cordToPixel(double longitude, double latitude,int mapWidth,int mapHeight) {
		
		double x = (longitude + 180)*(mapWidth/360);
		double rad = latitude*Math.PI/180;
		double mat = Math.log(Math.tan(Math.PI/4)+(rad/2));
		double y = (mapHeight/2)-(mapWidth * mat/(2*Math.PI));
		return new Cord(x,y);
		
		
	}
	

		

}
