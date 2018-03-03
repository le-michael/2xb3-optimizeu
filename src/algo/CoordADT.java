package algo;

import java.io.File;
import java.util.Scanner;

public class CoordADT {

	private double points[][];
	private static final int N = 2;
	
	/**
	 * Takes an input file of coordinates in the form of
	 * "x, y" on each line and places them in an array.
	 * NOTE: FOR NOW NUMBER OF LINES MUST BE GIVEN
	 * @param filename The filename
	 * @param lines The number of coordinates in the file
	 * @throws Exception The file is not found
	 */
	CoordADT(String filename, int lines) throws Exception{
		File f = new File(filename);
		Scanner s = new Scanner(f);
		
		String[] l;
		points = new double[lines][N];
		for (int i = 0; i < lines; i++) {
			l = s.next().split(",");
			for (int j = 0; j < N; j++)
				points[i][j] = Double.parseDouble(l[j]);
		}
		
		s.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
