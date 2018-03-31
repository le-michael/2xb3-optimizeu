package algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Load {
	
	//Cord data;
	//Cord maxima;
	//Cord minima;
	int size;
	
	HashMap<String,Cord> data;
	
	
	public Load() {
		String f = "./data/uber-raw-data-may14.csv";
		String line;

		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			line = br.readLine();
			line = br.readLine();
			String [] temp = line.split(",");

			
			//data = new Cord(Double.parseDouble(temp[1]),Double.parseDouble(temp[2]));
			//Cord pCord = data;
			size =1;
			
			while ((line = br.readLine())!= null) {
				temp = line.split(",");
				//System.out.println(Arrays.toString(temp));
				double x = Double.parseDouble(temp[1]);
				double y = Double.parseDouble(temp[2]);
				System.out.println(temp[0].split(" ")[1].split(":")[0]);
				//pCord.setNext(new Cord(Double.parseDouble(temp[1]),Double.parseDouble(temp[2])));
				//pCord = pCord.getNext();
				//System.out.println(pCord.toString());
				size ++;
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
		
	/*
	
	public Cord getData() {

		System.out.println(cordToPixel(data.getX(),data.getY(),500,500).toString());
		
		
		return data;
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
	}
	
	
	public int getSize() {
		return size;
	}
	
	private Cord cordToPixel(double longitude, double latitude,int mapWidth,int mapHeight) {
		
		double x = (longitude + 180)*(mapWidth/360);
		double rad = latitude*Math.PI/180;
		double mat = Math.log(Math.tan(Math.PI/4)+(rad/2));
		double y = (mapHeight/2)-(mapWidth * mat/(2*Math.PI));
		return new Cord(x,y);
		
		
	}
	*/

	
	public static void main(String[] args) {
		Load data = new Load();
		//Cord c = data.getData();
		//Cord p = data.getPixelData(500, 500);
		//Cord means = KMeans.calculateMeans(100, data.getSize(), p, 100000);
		//Cluster[]  clus = KMeans.assignToClusters(means, p, 100);
		
   //     DisplayClusters ex = new DisplayClusters(clus);
   //     ex.setVisible(true);
		

		
		
	}
		

}
