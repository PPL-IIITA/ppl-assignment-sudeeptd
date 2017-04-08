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

}
