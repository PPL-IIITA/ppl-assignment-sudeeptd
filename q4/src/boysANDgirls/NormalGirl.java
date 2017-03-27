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
public class NormalGirl extends Girl {

	/**
	 * @param name
	 * @param attractiveness
	 * @param maintenance
	 * @param intelligence
	 * @param selection_criteria
	 */
	public NormalGirl(String name, int attractiveness, int maintenance, int intelligence, int selection_criteria) {
		super(name, attractiveness, maintenance, intelligence, selection_criteria);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public double findHappiness(ArrayList<Gift> gifts) {
		// TODO Auto-generated method stub
		int total = 0;
		for(Gift gift : gifts) {
			total += (gift.getPrice() + gift.getValue());
		}
		double ans;
		ans = total - this.getMaintenance();
		return ans;
	}

}
