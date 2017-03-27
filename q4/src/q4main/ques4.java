/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package q4main;

import java.util.ArrayList;

import boysANDgirls.Boy;
import boysANDgirls.Couple;
import boysANDgirls.Gift;
import boysANDgirls.Girl;
import testing_utility.Algos;
import testing_utility.test;

/**
 * @author user
 *
 */
public class ques4 {

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
		a.pairup_and_gift(allboys, allgirls, allgifts, couples);
		
		/**
		 * breakup and new bfs of single girls
		 */
		a.breakup_and_newBf(allboys, allgifts, couples);
	}

}
