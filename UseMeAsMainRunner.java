//package yourPackage;


import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import med.*;

public class MainRunner {

	public static void main(String[] args) {
		boolean debug = true; 
		ArrayList<Integer> pass = new ArrayList<Integer>();
		ArrayList<Integer> fail = new ArrayList<Integer>();
		for (int i = 1; i <= 30; i++ ) {
			String fil = "tests"+System.getProperty("file.separator")+"input"+i+".txt";
			File f = new File(fil);
			try {
				FileInputStream is = new FileInputStream(f);
				MedParser parser = new MedParser(is);
				if(debug) {
					try {
						parser.MedCenter();
						pass.add(i);
					} catch (TokenMgrError e) {
						System.err.print(f.getName()+" failed in the Scanner: ");
						System.err.println(e.getMessage());;
						System.err.println("------------------------------------");
						fail.add(i);
					} catch (ParseException e) {
						System.err.print(f.getName()+" failed in the Parser: ");
						System.err.println(e.getMessage());;
						System.err.println("------------------------------------");
						fail.add(i);
					}
				} else {

				}
			} catch (FileNotFoundException e) {
				System.err.println("Cannot find "+f.getName());
				System.err.println("------------------------------------");
			}
		}
		System.out.println("Passed: " + pass.toString());
		System.out.println("Failed: " + fail.toString());
	}
}