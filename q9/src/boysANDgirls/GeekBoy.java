/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package boysANDgirls;

import java.util.*;
import testing_utility.*;

/**
 * @author user
 *
 */
public class GeekBoy extends Boy {

	/**
	 * @param name
	 * @param attractiveness
	 * @param intelligence
	 * @param budget
	 * @param min_attraction_of_girl
	 */
	public GeekBoy(String name, int attractiveness, int intelligence, int budget, int min_attraction_of_girl) {
		super(name, attractiveness, intelligence, budget, min_attraction_of_girl);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public ArrayList<Gift> Gifting(ArrayList<Gift> allgifts, KBest kbest) {
		// TODO Auto-generated method stub
		ArrayList<Gift> kgifts = new ArrayList<>();
		ArrayList<Integer> cmp = new ArrayList<>();
		Random rand = new Random();
		int k = rand.nextInt(30) + 20;
		for(Gift gift : allgifts)
			cmp.add(-gift.getPrice());
		kgifts = kbest.find_k_best(allgifts, cmp, k);
		kgifts.sort(Comparator.comparing(Gift::getValue));
		Collections.reverse(kgifts);
		
			
		ArrayList<Gift> gifts = new ArrayList<>();
		int tot_val = 0;
		
		for(Gift gift : kgifts) {
			if(tot_val < this.getGf().getMaintenance()) {
				
				tot_val += gift.getPrice();
				gifts.add(gift);
			}
		}
		
		for(Gift gift : kgifts) {
			if(!gifts.contains(gift) && gift.getType() == 1) {
				if(tot_val + gift.getPrice() <= this.getBudget()) {
					
					tot_val += gift.getPrice();
					gifts.add(gift);
					break;
				}
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
		double ans = this.getGf().getIntelligence();
		return ans;
	}

}
