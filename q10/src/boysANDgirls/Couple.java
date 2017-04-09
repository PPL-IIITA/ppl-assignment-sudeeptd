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
public class Couple {

	private Boy bf;
	private Girl gf;
	private ArrayList<Gift> gifts;
	private double happiness;
	private int compatibility;
	
	
	/**
	 * Constructor for Couple class
	 * @param bf
	 * @param gf
	 * @param allgifts
	 */
	public Couple(Boy bf, Girl gf, ArrayList<Gift> allgifts, KBest kbest) {
		super();
		this.bf = bf;
		this.gf = gf;
		this.bf.setGf(gf);
		this.gf.setBf(bf);
		this.bf.setIs_committed(true);
		this.gf.setIs_committed(true);
		this.gifts = this.bf.Gifting(allgifts, kbest);
		this.gf.setHappiness(this.gf.findHappiness(gifts));
		this.bf.setHappiness(this.bf.findHappiness());
		this.happiness = this.bf.getHappiness() + this.gf.getHappiness();
		this.compatibility = Math.abs(this.bf.getBudget() - this.gf.getMaintenance()) +
			    		Math.abs(this.bf.getAttractiveness() - this.gf.getAttractiveness()) +
			    		Math.abs(this.bf.getIntelligence() - this.gf.getIntelligence());
		
	}
	
	/**
	 * Prints the gifts exchanged
	 */
	public void print_gifts() {
		System.out.println("\nGifts given are\n");
		for(Gift gift : this.gifts)
			System.out.println(gift.getName());
		System.out.println("**********\n");
	}
	
	/**
	 * Prints the name of boy and girl in relationship
	 */
	public void printCouple() {
		System.out.println(this.gf.getName()+"  "+this.bf.getName());
	}
	
	/**
	 * For breakup
	 */
	public void breakup() {
		this.bf.newEx(this.gf);
		this.gf.newEx(this.bf);
	}

	public Boy getBf() {
		return bf;
	}

	public void setBf(Boy bf) {
		this.bf = bf;
	}

	public Girl getGf() {
		return gf;
	}

	public void setGf(Girl gf) {
		this.gf = gf;
	}

	public ArrayList<Gift> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<Gift> gifts) {
		this.gifts = gifts;
	}

	public double getHappiness() {
		return happiness;
	}

	public void setHappiness(double happiness) {
		this.happiness = happiness;
	}

	public int getCompatibility() {
		return compatibility;
	}

	public void setCompatibility(int compatibility) {
		this.compatibility = compatibility;
	}
	
	

}
