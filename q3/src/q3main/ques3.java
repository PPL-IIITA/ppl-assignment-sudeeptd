/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package q3main;
import boysANDgirls.*;
import testing_utility.*;
import java.util.*;
/**
 * @author user
 *
 */
public class ques3 {


	
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
		
		// k is randomly generated in the function definition
		a.most_compatible_and_happy(couples);
		
	}

}
