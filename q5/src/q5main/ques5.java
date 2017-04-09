/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package q5main;

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
public class ques5 {

	
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
		
		Random rand = new Random();
		int k = rand.nextInt(2) + 1;
		// if k=1, then algorithm of ques1 else k=2, then algorithm of ques5
		
		Algos a = new Algos();
		
		if(k==1) {
			a.pairup_and_gift(allboys, allgirls, allgifts, couples);

			System.out.println("Allocating according to q1 Algo\n");
		}
		
		else {
			a.pair_1girl_then_1boy(allboys, allgirls, allgifts, couples);

			System.out.println("Allocating according to q5 Algo\n");
		}
		
		a.happiest_couples(couples);
	}

}
