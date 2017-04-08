/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package testing_utility;
import java.util.*;
import boysANDgirls.*;

/**
 * @author user
 *
 */
public class GfFinderArray extends GfFinder {

	/**
	 * Constructor of class which stores boys in a simple unsorted array
	 */
	public GfFinderArray(ArrayList<Couple> couples) {
		ArrayList<Boy> boys = new ArrayList<>();
		for(Couple c : couples) {
			boys.add(c.getBf());
		}
		this.setBoys(boys);
		
		// TODO Auto-generated constructor stub
		
	}

	/* (non-Javadoc)
	 * @see testing_utility.GfFinder#who_is_his_gf()
	 */
	@Override
	public void who_is_his_gf(ArrayList<String> boy_names) {
		// TODO Auto-generated method stub
		ArrayList<Boy> boys = this.getBoys();
		for(String b_name : boy_names) {
			boolean fl=true;
			for(Boy bb : boys) {
				if(Objects.equals(b_name, bb.getName())) {
					System.out.println(b_name+"'s girlfriend is "+bb.getGf().getName());
					fl=false;
				}
			}
			if(fl) {
				System.out.println(b_name+" is single..sorry");
			}
		}
	}

}
