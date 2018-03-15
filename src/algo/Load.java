package algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Load {
	
	Cord data;
	
	public Load() {
		String f = "./data/uber-raw-data-may14.csv";
		String line;
		Cord minima = new Cord(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Cord maxima = new Cord(Integer.MIN_VALUE, Integer.MIN_VALUE);
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			line = br.readLine();
			line = br.readLine();
			String [] temp = line.split(",");
			data = new Cord(Double.parseDouble(temp[1]),Double.parseDouble(temp[2]));
			Cord pCord = data;
			if (pCord.getY() > pCord.getY())
				maxima.setY(pCord.getY());
			if (pCord.getX() > maxima.getX())
				maxima.setX(pCord.getX());
			if (pCord.getY() < minima.getY())
				minima.setY(pCord.getY());
			if (pCord.getX() < minima.getX())
				minima.setX(pCord.getX());
			while ((line = br.readLine())!= null) {
				temp = line.split(",");
				pCord.setNext(new Cord(Double.parseDouble(temp[1]),Double.parseDouble(temp[2])));
				pCord = pCord.getNext();
				if (pCord.getY() > pCord.getY())
					maxima.setY(pCord.getY());
				if (pCord.getX() > maxima.getX())
					maxima.setX(pCord.getX());
				if (pCord.getY() < minima.getY())
					minima.setY(pCord.getY());
				if (pCord.getX() < minima.getX())
					minima.setX(pCord.getX());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Cord pCord = data;
		for (Cord i = pCord; i != null; i = i.getNext()) {
			i.setX((i.getX()- minima.getX())/(maxima.getX()-minima.getX()));
			i.setY((i.getY()- minima.getY())/(maxima.getY()-minima.getY()));
		}
	}
		
	
	public Cord getData() {
		return data;
	}
	/*
	public static void main(String[] args) {
		Load data = new Load();
		Cord c = data.getData();
		Cord temp = c;
		for(int i = 0;i < 100; i++) {
			System.out.println(temp.toString());
			temp = temp.getNext();
		}
		
	}*/
		

}
