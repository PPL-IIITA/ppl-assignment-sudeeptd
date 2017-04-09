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
public abstract class Girl {

	
	private String name;
	private int attractiveness;
	private int maintenance;
	private int intelligence;
	private int selection_criteria;
	private boolean is_committed;
	private Boy bf;
	private ArrayList<Boy> exbfs;
	private double happiness;
	
	/* selection_criteria = 1 - most attractive boy,
	2 - richest boy and 3 - most intelligent boy */
	
	/**
	 * Constructor of Girl class
	 * @param name
	 * @param attractiveness
	 * @param maintenance
	 * @param intelligence
	 * @param selection_criteria
	 */
	public Girl(String name, int attractiveness, int maintenance, int intelligence, int selection_criteria) {
		super();
		this.name = name;
		this.attractiveness = attractiveness;
		this.maintenance = maintenance;
		this.intelligence = intelligence;
		this.selection_criteria = selection_criteria;
		this.is_committed = false;
		this.bf = null;
		this.exbfs = new ArrayList<>();
		this.happiness = 0;
	}
	
	/**
	 * finds a suitable boyfriend for the girl
	 * @param allboys
	 * @return
	 */
	public Boy findBF(ArrayList<Boy> allboys, KBest kbest) {
		int s = this.selection_criteria;
		Random rand = new Random();
		int k = rand.nextInt(30) + 20;
		ArrayList<Boy> kboys = new ArrayList<>();
		ArrayList<Integer> cmp = new ArrayList<>();
		if(s==1) {
			for(Boy b : allboys) {
				if(!b.isIs_committed())
					cmp.add(b.getAttractiveness());
			}
			kboys = kbest.find_k_best(allboys, cmp, k);
			kboys.sort(Comparator.comparing(Boy::getBudget));
		}
		else if(s==2) {
			for(Boy b : allboys) {
				if(!b.isIs_committed())
					cmp.add(b.getBudget());
			}
			kboys = kbest.find_k_best(allboys, cmp, k);
			kboys.sort(Comparator.comparing(Boy::getIntelligence));
		}
		else {
			for(Boy b : allboys) {
				if(!b.isIs_committed())
					cmp.add(b.getIntelligence());
			}
			kboys = kbest.find_k_best(allboys, cmp, k);
			kboys.sort(Comparator.comparing(Boy::getAttractiveness));
		}
		Collections.reverse(kboys);
		Boy temp = null;
		Randomk rk = new Randomk();
		while(true) {
			Boy b = rk.select_random(kboys);
			if(!b.isIs_committed() && this.isEligibleBF(b) && b.isEligibleGF(this)) {
				temp = b;
				break;
			}
		}
		return temp;
	}
	
	/**
	 * calculates happiness
	 * @param gifts
	 * @return
	 */
	abstract public double findHappiness(ArrayList<Gift> gifts);
	
	/**
	 * Checks if boy is eligible
	 * @param b
	 * @return
	 */
	public boolean isEligibleBF(Boy b) {
		boolean x,y =  this.maintenance <= b.getBudget();
		x = !(this.isExBF(b));
		return x&&y;
	}
	
	/**
	 * Checks if boy is one of ex-bfs
	 * @param b
	 * @return
	 */
	public boolean isExBF(Boy b) {
		for(Boy t : exbfs) {
			if(t==b)
				return true;
		}
		return false;
	}
	
	/**
	 * Called at the time of breakup
	 * @param b
	 */
	public void newEx(Boy b) {
		this.exbfs.add(b);
		this.bf = null;
		this.is_committed = false;
		this.happiness = 0;
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

	public int getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getSelection_criteria() {
		return selection_criteria;
	}

	public void setSelection_criteria(int selection_criteria) {
		this.selection_criteria = selection_criteria;
	}

	public boolean isIs_committed() {
		return is_committed;
	}

	public void setIs_committed(boolean is_committed) {
		this.is_committed = is_committed;
	}

	public Boy getBf() {
		return bf;
	}

	public void setBf(Boy bf) {
		this.bf = bf;
	}

	public ArrayList<Boy> getExbfs() {
		return exbfs;
	}

	public void setExbfs(ArrayList<Boy> exbfs) {
		this.exbfs = exbfs;
	}

	public double getHappiness() {
		return happiness;
	}

	public void setHappiness(double happiness) {
		this.happiness = happiness;
	}
	
	

}
