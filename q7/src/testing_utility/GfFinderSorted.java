/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package testing_utility;

import java.util.*;

import boysANDgirls.Boy;
import boysANDgirls.Couple;

/**
 * @author user
 *
 */
public class GfFinderSorted extends GfFinder {

	/**
	 * 
	 */
	public GfFinderSorted(ArrayList<Couple> couples) {
		ArrayList<Boy> boys = new ArrayList<>();
		for(Couple c : couples) {
			boys.add(c.getBf());
		}
		boys.sort(Comparator.comparing(Boy::getName));
		this.setBoys(boys);
		
		// TODO Auto-generated constructor stub
		
	}

	/* (non-Javadoc)
	 * @see testing_utility.GfFinder#who_is_his_gf(java.util.ArrayList)
	 */
	@Override
	public void who_is_his_gf(ArrayList<String> boy_names) {
		// TODO Auto-generated method stub
		ArrayList<Boy> boys = this.getBoys();
		for(String b_name : boy_names) {
			boolean fl=true;
			int b_num = Integer.parseInt(b_name.substring(3));
			int lo = 0, hi = boys.size() - 1;
			while(lo<=hi) {
				int m = (lo +hi)/2;
				Boy bb = boys.get(m);
				int bb_num = Integer.parseInt(bb.getName().substring(3));
				if(b_num == bb_num) {
					fl=false;
					System.out.println(b_name+"'s girlfriend is "+bb.getGf().getName());
					break;
				}
				else if(bb_num < b_num) {
					lo = m+1;
				}
				else {
					hi = m-1;
				}
					
			}
			if(fl)
				System.out.println(b_name+" is single..sorry");

		}
	}

}
