/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package q6main;

import java.util.*;

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
public class ques6 {

	/**
	 * Main function to test the working of sixth question
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Boy> allboys = new ArrayList<>();
		ArrayList<Girl> allgirls = new ArrayList<>();
		ArrayList<Gift> allgifts = new ArrayList<>();
		ArrayList<Couple> couples = new ArrayList<>();
		
		test util = new test();
		util.generateInput();
		util.readInput(allboys, allgirls, allgifts);
		Algos a = new Algos();
		a.pairup_and_gift(allboys, allgirls, allgifts, couples);
		
		/**
		 * t is used to store how many days will the gifting be done
		 */
		Random rand = new Random();
		int t = rand.nextInt(5) + 3;
		a.breakup_on_t_days(allboys, allgifts, couples, t);
		
	}

}
