package testing_utility;

import java.util.ArrayList;
import java.util.Comparator;

import boysANDgirls.Couple;
import boysANDgirls.Gift;

public class GiftSelector2 extends GiftSelector {

	@Override
	public ArrayList<Gift> gifting(Couple c, ArrayList<Gift> allgifts) {
		// TODO Auto-generated method stub
		ArrayList<Gift> givengifts = new ArrayList<>();
		allgifts.sort(Comparator.comparing(Gift::getPrice));
		int tot_val = 0;
		boolean t1,t2,t3;
		t1=t2=t3=false;
		for(Gift gift : allgifts) {
			if(t1&&t2&&t3)
				break;
			if(!t1 && gift.getType()==1) {
				givengifts.add(gift);
				tot_val += gift.getPrice();
				t1 = true;
			}
			else if(!t2 && gift.getType()==2) {
				givengifts.add(gift);
				tot_val += gift.getPrice();
				t2 = true;
			}
			else if(!t3 && gift.getType()==3) {
				givengifts.add(gift);
				tot_val += gift.getPrice();
				t3 = true;
			}
		}
		if(tot_val > c.getBf().getBudget())
			c.getBf().setBudget(tot_val);
		return c.getBf().Gifting(allgifts, givengifts);
	}

}
