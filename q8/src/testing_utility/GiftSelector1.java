/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package testing_utility;

import java.util.ArrayList;

import boysANDgirls.Couple;
import boysANDgirls.Gift;

/**
 * @author user
 *
 */
public class GiftSelector1 extends GiftSelector {

	/* (non-Javadoc)
	 * @see testing_utility.GiftSelector#gifting(boysANDgirls.Couple, java.util.ArrayList)
	 */
	@Override
	public ArrayList<Gift> gifting(Couple c, ArrayList<Gift> allgifts) {
		// TODO Auto-generated method stub
		ArrayList<Gift> givengifts = new ArrayList<>();
		return c.getBf().Gifting(allgifts, givengifts);
		
	}

}
