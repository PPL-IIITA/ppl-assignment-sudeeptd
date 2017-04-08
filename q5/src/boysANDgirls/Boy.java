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
abstract public class Boy {

	/**
	 * class containing details of a boy
	 */
	private String name;
	private int attractiveness;
	private int intelligence;
	private int budget;
	private int min_attraction_of_girl;
	private boolean is_committed;
	private Girl gf;
	private ArrayList<String> exgfs;
	private double happiness;
	private int money_spent;
	
	/**
	 * Constructor of Boy class
	 * @param name
	 * @param attractiveness
	 * @param intelligence
	 * @param budget
	 * @param min_attraction_of_girl
	 */
	public Boy(String name, int attractiveness, int intelligence, int budget, int min_attraction_of_girl) {
		super();
		this.name = name;
		this.attractiveness = attractiveness;
		this.intelligence = intelligence;
		this.budget = budget;
		this.min_attraction_of_girl = min_attraction_of_girl;
		this.is_committed = false;
		this.gf = null;
		this.exgfs = new ArrayList<>();
		this.happiness = 0;
		this.money_spent = 0;
	}
	
	/**
	 * Function which gives gifts to girlfriend
	 * @param allgifts
	 * @return
	 */
	abstract public ArrayList<Gift> Gifting(ArrayList<Gift> allgifts);
	
	/**
	 * calculates happiness
	 * @return
	 */
	abstract public double findHappiness();
	
	/**
	 * Checks if girl is eligible for relationship
	 * @param g
	 * @return
	 */
	public boolean isEligibleGF(Girl g) {
		boolean x,y = this.min_attraction_of_girl <= g.getAttractiveness();
		x = !(this.isExGF(g));
		return x&&y;
	}
	
	/**
	 * Checks if girl is not one of the ex-gfs
	 * @param g
	 * @return
	 */
	public boolean isExGF(Girl g) {
		for(String t : exgfs) {
			if(t==g.getName())
				return true;
		}
		return false;
	}
	
	/**
	 * called at the time of breakup
	 * @param g
	 */
	public void newEx(Girl g) {
		this.exgfs.add(g.getName());
		this.gf = null;
		this.is_committed = false;
		this.happiness =  0;
		this.money_spent = 0;
	}
	
	/**
	 * Select a girl suitable for the boy as per constraints
	 * @param allgirls
	 * @return
	 */
	public Girl findGF(ArrayList<Girl> allgirls) {
		Girl temp = null;
		allgirls.sort(Comparator.comparing(Girl::getAttractiveness));
		Collections.reverse(allgirls);
		for(Girl g : allgirls) {
			if(!g.isIs_committed() && this.isEligibleGF(g) && g.isEligibleBF(this)) {
				temp = g;
				break;
			}
		}
		
		return temp;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttractiveness() {
		return attractiveness;
	}

	public void setAttractiveness(int attractiveness) {
		this.attractiveness = attractiveness;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getMin_attraction_of_girl() {
		return min_attraction_of_girl;
	}

	public void setMin_attraction_of_girl(int min_attraction_of_girl) {
		this.min_attraction_of_girl = min_attraction_of_girl;
	}

	public boolean isIs_committed() {
		return is_committed;
	}

	public void setIs_committed(boolean is_committed) {
		this.is_committed = is_committed;
	}

	public Girl getGf() {
		return gf;
	}

	public void setGf(Girl gf) {
		this.gf = gf;
	}

	public ArrayList<String> getExgfs() {
		return exgfs;
	}

	public void setExgfs(ArrayList<String> exgfs) {
		this.exgfs = exgfs;
	}

	public double getHappiness() {
		return happiness;
	}

	public void setHappiness(double happiness) {
		this.happiness = happiness;
	}


	public int getMoney_spent() {
		return money_spent;
	}


	public void setMoney_spent(int money_spent) {
		this.money_spent = money_spent;
	}
	

}
