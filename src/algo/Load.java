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
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			line = br.readLine();
			line = br.readLine();
			String [] temp = line.split(",");
			data = new Cord(Double.parseDouble(temp[1]),Double.parseDouble(temp[2]));
			Cord pCord = data;
			while ((line = br.readLine())!= null) {
				temp = line.split(",");
				pCord.setNext(new Cord(Double.parseDouble(temp[1]),Double.parseDouble(temp[2])));
				pCord = pCord.getNext();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
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
