/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package boysANDgirls;

import java.util.ArrayList;

/**
 * @author user
 *
 */
public class ChoosyGirl extends Girl {

	/**
	 * @param name
	 * @param attractiveness
	 * @param maintenance
	 * @param intelligence
	 * @param selection_criteria
	 */
	public ChoosyGirl(String name, int attractiveness, int maintenance, int intelligence, int selection_criteria) {
		super(name, attractiveness, maintenance, intelligence, selection_criteria);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public double findHappiness(ArrayList<Gift> gifts) {
		// TODO Auto-generated method stub
		double total_price = 0;
		double luxury_value = 0;
		for(Gift gift : gifts) {
			total_price += gift.getPrice();
			if(gift.getType() == 1)
				luxury_value += gift.getValue();
		}
		double ans = Math.log(total_price - (double)this.getMaintenance() + 2*luxury_value);
		return ans;
	}

}
