/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package q7main;

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
public class ques7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Boy> allboys = new ArrayList<>();
		ArrayList<Girl> allgirls = new ArrayList<>();
		ArrayList<Gift> allgifts = new ArrayList<>();
		ArrayList<Couple> couples = new ArrayList<>();
		ArrayList<String> boy_names = new ArrayList<>();
		
		test t = new test();
		t.generateInput();
		t.readInput(allboys, allgirls, allgifts,boy_names);
		Algos a = new Algos();
		a.pairup_and_gift(allboys, allgirls, allgifts, couples);
		
		GfFinder find;
		Random rand = new Random();
		int k = rand.nextInt(3) + 1;
		// k=1 for array, k=2 for sorted array, k=3 for hash
		
		switch(k) {
		case 1 : find = new GfFinderArray(couples);
				 break;
		case 2 : find = new GfFinderSorted(couples);
				 break;
		case 3 : find = new GfFinderHash(couples);
				 break;
		default : find = new GfFinderArray(couples);
		}
		
		find.who_is_his_gf(boy_names);
		
		
	}

}
