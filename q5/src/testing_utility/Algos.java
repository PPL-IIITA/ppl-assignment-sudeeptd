/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package testing_utility;
import java.util.*;
import java.io.*;
import java.time.*;

import boysANDgirls.*;
/**
 * @author user
 *
 */
public class Algos {

	/**
	 * Function to make couples and decide gift exchanges
	 * @param allboys
	 * @param allgirls
	 * @param allgifts
	 * @param couples
	 */
	public void pairup_and_gift(ArrayList<Boy> allboys, ArrayList<Girl> allgirls,
			ArrayList<Gift> allgifts, ArrayList<Couple> couples) {
		File f = new File("Log.txt");
		f.delete();
		
		for(Girl g : allgirls) {
		
			Boy b = g.findBF(allboys);
			if(b!=null)
				couples.add(new Couple(b,g,allgifts));
		}
		
		String FILENAME = "Log.txt";
		for(Couple c : couples) {
			String st = "Committment of "+c.getGf().getName()+" and "+c.getBf().getName()+
					" on date "+LocalDate.now()+" at time "+LocalTime.now();
			System.out.println(st);
			c.print_gifts();
			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				String data = st + "\r\n";
				data = data + "\r\nGifting Starts\r\n\r\n";
				for(Gift gift : c.getGifts()) {
					data = data + gift.getName() + "\r\n";
				}
				data = data + "\r\n\r\n\r\n";
				File file = new File(FILENAME);

				// if file doesn't exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// true = append file
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);

				bw.write(data);


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
	}
	
	/**
	 * Pairs up 1 girl then 1 boy alternatively
	 * @param allboys
	 * @param allgirls
	 * @param allgifts
	 * @param couples
	 */
	
	public void pair_1girl_then_1boy(ArrayList<Boy> allboys, ArrayList<Girl> allgirls,
			ArrayList<Gift> allgifts, ArrayList<Couple> couples) {
		int g_cnt=0,b_cnt=0,i=0;
		
		while(true) {
			
			if(g_cnt >= allgirls.size() && b_cnt >= allboys.size())
				break;
			if(i%2==0) {
				int gi=0;
				allgirls.sort(Comparator.comparing(Girl::getMaintenance));
				for(Girl g : allgirls) {
					if(gi>=g_cnt && !g.isIs_committed()) {
						Boy b = g.findBF(allboys);
						if(b!=null)
							couples.add(new Couple(b,g,allgifts));
					}
					gi++;
				}
				g_cnt++;
			}
			else {
				int bi = 0;
				allboys.sort(Comparator.comparing(Boy::getAttractiveness));
				for(Boy b : allboys) {
					if(bi>=b_cnt && !b.isIs_committed()) {
						Girl g = b.findGF(allgirls);
						if(g!=null)
							couples.add(new Couple(b,g,allgifts));
					}
					bi++;
				}
				b_cnt++;
			}
			i++;
		}
		
		File f = new File("Log.txt");
		f.delete();
		i=0;
		String data = "Allocating a BOY and then a GIRL one by one\r\n\r\n ";
		String FILENAME = "Log.txt";
		for(Couple c : couples) {
			String st;
			if(i%2==0)
				st = "Girl chose the boy\r\n";
			else
				st = "Boy chose the girl\r\n";
			i++;
			st += "Committment of "+c.getGf().getName()+" and "+c.getBf().getName()+
					" on date "+LocalDate.now()+" at time "+LocalTime.now();
			System.out.println(st);
			c.print_gifts();
			BufferedWriter bw = null;
			FileWriter fw = null;

			try {
				
				
				data = st + "\r\n";
				data = data + "\r\nGifting Starts\r\n\r\n";
				for(Gift gift : c.getGifts()) {
					data = data + gift.getName() + "\r\n";
				}
				data = data + "\r\n\r\n\r\n";
				File file = new File(FILENAME);

				// if file doesn't exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// true = append file
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				
				
				bw.write(data);


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
		
	}
	
}
