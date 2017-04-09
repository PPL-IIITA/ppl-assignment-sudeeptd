/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package q8main;

import java.util.*;

import boysANDgirls.Boy;
import boysANDgirls.Couple;
import boysANDgirls.Gift;
import boysANDgirls.Girl;
import testing_utility.*;

/**
 * @author user
 *
 */
public class ques8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Boy> allboys = new ArrayList<>();
		ArrayList<Girl> allgirls = new ArrayList<>();
		ArrayList<Gift> allgifts = new ArrayList<>();
		ArrayList<Couple> couples = new ArrayList<>();
		
		test t = new test();
		t.generateInput();
		t.readInput(allboys, allgirls, allgifts);
		
		Algos a = new Algos();
		GiftSelector gs;
		Random rand = new Random();
		int k = rand.nextInt(2) + 1;
		// k=1 for default gift selection, k=2 for new gift selection algorithm
		if(k==1) {
			gs=new GiftSelector1();
			a.pairup_and_gift(allboys, allgirls, allgifts, couples, gs);
			System.out.println("Default gift selector was chosen");
		}
		else {
			gs=new GiftSelector2();
			a.pairup_and_gift(allboys, allgirls, allgifts, couples, gs);
			System.out.println("New gift selector was chosen");
		}
		

	}

}
