/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package boysANDgirls;

import java.util.*;

/**
 * @author user
 *
 */
public class GenerousBoy extends Boy {

	/**
	 * @param name
	 * @param attractiveness
	 * @param intelligence
	 * @param budget
	 * @param min_attraction_of_girl
	 */
	public GenerousBoy(String name, int attractiveness, int intelligence, int budget, int min_attraction_of_girl) {
		super(name, attractiveness, intelligence, budget, min_attraction_of_girl);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public ArrayList<Gift> Gifting(ArrayList<Gift> allgifts, ArrayList<Gift> givengifts) {
		// TODO Auto-generated method stub
		allgifts.sort(Comparator.comparing(Gift::getPrice));
		ArrayList<Gift> gifts = givengifts;
		int tot_val = 0;
		
		for(Gift gift : allgifts) {
			if((tot_val + gift.getPrice() <= this.getBudget() ||	(tot_val < this.getGf().getMaintenance()))
					&& (!gifts.contains(gift))) {
				
				tot_val += gift.getPrice();
				gifts.add(gift);
			}
		}
		
		this.setMoney_spent(tot_val);
		if(tot_val > this.getBudget())
			this.setBudget(tot_val);
		return gifts;
	}

	
	@Override
	public double findHappiness() {
		// TODO Auto-generated method stub
		double ans = this.getGf().getHappiness();
		return ans;
	}

}
