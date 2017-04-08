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
public class GfFinderHash extends GfFinder {

	/**
	 * 
	 */
	Boy[] boyss = new Boy[100];
	

	public GfFinderHash(ArrayList<Couple> couples) {
		// TODO Auto-generated constructor stub
		Boy[] boyss = new Boy[100];
		for(Couple c : couples) {
			int b_num = Integer.parseInt(c.getBf().getName().replaceAll("[^0-9]", ""));
			boyss[b_num-1] = c.getBf();
		}
		this.setBoyss(boyss);
	}

	/* (non-Javadoc)
	 * @see testing_utility.GfFinder#who_is_his_gf(java.util.ArrayList)
	 */
	@Override
	public void who_is_his_gf(ArrayList<String> boy_names) {
		// TODO Auto-generated method stub
		Boy[] boyss = this.getBoyss();
		for(String b_name : boy_names) {
			int b_num = Integer.parseInt(b_name.substring(3));
			if(boyss[b_num-1]!=null) {
				System.out.println(b_name+"'s girlfriend is "+boyss[b_num-1].getGf().getName());
			}
			else {
				System.out.println(b_name+" is single..sorry");

			}
		}

	}
	
	
	
	public Boy[] getBoyss() {
		return boyss;
	}

	public void setBoyss(Boy[] boyss) {
		this.boyss = boyss;
	}

}
