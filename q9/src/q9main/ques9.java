/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package q9main;

import java.util.ArrayList;

import boysANDgirls.Boy;
import boysANDgirls.Couple;
import boysANDgirls.Gift;
import boysANDgirls.Girl;
import testing_utility.Algos;
import testing_utility.*;

/**
 * @author user
 *
 */
public class ques9 {

	/**
	 * @param args list of arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Boy> allboys = new ArrayList<>();
		ArrayList<Girl> allgirls = new ArrayList<>();
		ArrayList<Gift> allgifts = new ArrayList<>();
		ArrayList<Couple> couples = new ArrayList<>();
		
		KBest kbest = new KBest();
		
		test t = new test();
		t.generateInput();
		t.readInput(allboys, allgirls, allgifts);
		
		Algos a = new Algos();
		a.pairup_and_gift(allboys, allgirls, allgifts, couples, kbest);

	}

}
