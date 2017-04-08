/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package testing_utility;
import java.util.*;

import boysANDgirls.*;

import java.io.*;
/**
 * @author user
 *
 */
public class test {

	/**
	 * To generate random input for girls, boys and gifts and store in text files
	 */
	public void generateInput() {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			String FILENAME = "BoysData.txt";
			String data;
			Random rand = new Random();
			File file = new File(FILENAME);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			
			int t,a,b,c,d,j,n = rand.nextInt(59) + 30;
			for(j=1;j<=n;j++) {
				t = rand.nextInt(3) + 1;
				// t=1 for miser,2 for generous,3 for geeky boys
				a = rand.nextInt(211) + 35; // attractiveness
				b = rand.nextInt(129) + 24; // intelligence
				c = rand.nextInt(59) + 35; // budget
				d = rand.nextInt(157) + 40; // minimum attraction requirement

				//writing to file
				if(j<n)
					data = "BOY" +j+" "+t+" "+a+" "+b+" "+c+" "+d+"\r\n";
				else
					data = "BOY" +j+" "+t+" "+a+" "+b+" "+c+" "+d;
				bw.write(data);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
		// Generating Girls data
		
		try {
			String FILENAME = "GirlsData.txt";
			String data;
			Random rand = new Random();
			File file = new File(FILENAME);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			
			int j,t,a,b,c,d,n;
			n = rand.nextInt(19) + 20;
			for(j=1;j<=n;j++) {
				t = rand.nextInt(3) + 1;
				// t=1 for choosy,2 for normal,3 for desperate girls
				a = rand.nextInt(617) + 200; // attractiveness
				b = rand.nextInt(23) + 10; // maintenance cost
				c = rand.nextInt(111) + 20; // intelligence
				d = rand.nextInt(3) + 1; // selection criteria
				// d=1 for most attractive, d=2 for richest, d=3 for most intelligent

				//writing to file
				if(j<n)
					data = "GIRL" +j+" "+t+" "+a+" "+b+" "+c+" "+d+"\r\n";
				else
					data = "GIRL" +j+" "+t+" "+a+" "+b+" "+c+" "+d;
				bw.write(data);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
		//writing gift data to file
		
		
		try {
			String FILENAME = "GiftsData.txt";
			String data;
			Random rand = new Random();
			File file = new File(FILENAME);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			
			int j,t,a,b,c,d,n;
			n = rand.nextInt(19) + 20;
			for(j=1;j<=n;j++) {
				t = rand.nextInt(3) + 1;
				// t=1 for essential, 2 for luxury, 3 for utility
				a = rand.nextInt(5) + 2; // price of gift
				b = rand.nextInt(17) + 3; // value of gift
				c = rand.nextInt(5) + 1; // luxury rating or the utility class
				d = rand.nextInt(9) + 1; // difficulty to obtain or the utility value

				if(t==1) {
					if(j<n)
						data = "GIFT" +j+" "+t+" "+a+" "+b+"\r\n";
					else
						data = "GIFT" +j+" "+t+" "+a+" "+b;
				}
				else {
					a = rand.nextInt(12) + 3;
					b = rand.nextInt(35) + 9;
					if(j<n)
						data = "GIFT" +j+" "+t+" "+a+" "+b+" "+c+" "+d+"\r\n";
					else
						data = "GIRL" +j+" "+t+" "+a+" "+b+" "+c+" "+d+"\r\n";
				}
		
				//writing to file
				bw.write(data);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
	}
	
	
	/**
	 * To read input from text files
	 */
	public void readInput(ArrayList<Boy> allboys, ArrayList<Girl> allgirls, ArrayList<Gift> allgifts) {
		
		Scanner sc;
		String st;
		int t,a,b,c,d;
		/*
		 * reading boys
		 */
		try {
			sc = new Scanner(new File("BoysData.txt"));
			while(sc.hasNext()) {
				st = sc.next();
				t = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				d = sc.nextInt();
				//t=1 for miser,2 for generous,3 for geeky boys
				
				switch(t) {
				case 1 : allboys.add(new MiserBoy(st,a,b,c,d));
						break;
				case 2 : allboys.add(new GenerousBoy(st,a,b,c,d));
						break;
				case 3 : allboys.add(new GeekBoy(st,a,b,c,d));
						break;
				default : break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * reading girls data
		 */
		
		try {
			sc = new Scanner(new File("GirlsData.txt"));
			while(sc.hasNext()) {
				st = sc.next();
				t = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				d = sc.nextInt();
				// t=1 for choosy,2 for normal,3 for desperate girls
				
				switch(t) {
				case 1 : allgirls.add(new ChoosyGirl(st,a,b,c,d));
						break;
				case 2 : allgirls.add(new NormalGirl(st,a,b,c,d));
						break;
				case 3 : allgirls.add(new DesperateGirl(st,a,b,c,d));
						break;
				default : break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * reading gifts data
		 */
		try {
			sc = new Scanner(new File("GiftsData.txt"));
			while(sc.hasNext()) {
				st = sc.next();
				t = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				// t=1 for essential, 2 for luxury, 3 for utility
				
				if(t==1) {
					allgifts.add(new Gift(st,a,b,t));
				}
				else {
					c = sc.nextInt();
					d = sc.nextInt();
					allgifts.add(new Gift(st,a,b,c,d,t));
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
