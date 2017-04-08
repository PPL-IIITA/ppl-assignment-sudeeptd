/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package testing_utility;

/**
 * @author user
 *
 */
import java.util.*;

import boysANDgirls.*;
public abstract class GfFinder {

	/**
	 * 
	 */
	private ArrayList<Boy> boys = new ArrayList<>();
	/**
	 * Finds the girl friend, if exists, of the given boy names
	 * @param boy_names
	 */
	abstract public void who_is_his_gf(ArrayList<String> boy_names);
	
	public ArrayList<Boy> getBoys() {
		return boys;
	}
	
	public void setBoys(ArrayList<Boy> boys) {
		this.boys = boys;
	}

}
