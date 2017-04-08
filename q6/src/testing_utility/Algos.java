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
	 * Perform breakup on t days of calendar
	 * @param allboys arraylist to store boys
	 * @param allgifts arraylist to store girls
	 * @param couples arraylist to store couples
	 * @param t number of days
	 */
	public void breakup_on_t_days(ArrayList<Boy> allboys,
			ArrayList<Gift> allgifts, ArrayList<Couple> couples, int t)
	{
		int temp = t;
		while(temp>0) {
			temp--;
			breakup_and_newBf(allboys, allgifts, couples, t);
		}
	}
	
	/**
	 * Breakup of couples with happiness less than t which is generated in main function
	 * @param allboys arraylist to store boys
	 * @param allgifts arraylist to store girls
	 * @param couples arraylist to store couples
	 * @param t minimum happiness required for no breakup
	 */
	
	public void breakup_and_newBf(ArrayList<Boy> allboys,
			ArrayList<Gift> allgifts, ArrayList<Couple> couples, int t) {
		
		ArrayList<Couple> brokeup_couples = new ArrayList<>();
		
		String st = "\r\n**********\r\nBreak up of " + " least happy couples\n";
		System.out.println(st);
		couples.sort(Comparator.comparing(Couple::getHappiness));
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			String FILENAME = "Log.txt";
			String data = st + "\r\n";
			File file = new File(FILENAME);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(),true);
			bw = new BufferedWriter(fw);
			
			for(Couple c : couples) {
				
				String temp = c.getGf().getName()+" and "+c.getBf().getName()+" broke up on date "
						+LocalDate.now()+" at time "+LocalTime.now()+"\r\n";
				c.breakup();
				System.out.println(temp);
				data += temp;
				brokeup_couples.add(c);
				if(c.getHappiness() > t)
					break;
			}
			

			for(Couple c : brokeup_couples) {
				
				Boy b = c.getGf().findBF(allboys);
				if(b!=null)
					couples.add(new Couple(b,c.getGf(),allgifts));
			}
			
			
			
			for(Couple c : brokeup_couples) {
				couples.remove(c);
			}
			
			Collections.reverse(couples);
			for(Couple c : couples) {
				
				st = "\r\nCommittment of "+c.getGf().getName()+" and "+c.getBf().getName()+
						" on date "+LocalDate.now()+" at time "+LocalTime.now()+"\r\n";
				System.out.println(st);
				data += st;
				c.print_gifts();
				data = data + "\r\nGifting Starts\r\n\r\n";
				for(Gift gift : c.getGifts()) {
					data = data + gift.getName() + "\r\n";
				}
				data = data + "\r\n\r\n";
				if(c.getHappiness() > t)
					break;
			}
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
