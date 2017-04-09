/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package testing_utility;
import java.util.*;
/**class which selects a random item from best k valued items
 * @author user
 *
 */
public class Randomk {
	/**
	 * Function to return random object out of best valued objects
	 * @param data best n items to select from
	 * @return a random item from the list
	 */
	public <Temp> Temp select_random(ArrayList<Temp> data) {
		Random rand = new Random();
		int ind = rand.nextInt(data.size());
		return data.get(ind);
	}
}
