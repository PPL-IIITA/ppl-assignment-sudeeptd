/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package testing_utility;
import java.util.*;

/**Class to implement data structure which returns k best valued items
 * @author user
 *
 */
public class KBest {
	
	/**
	 * Function to return k best valued items
	 * @param data data list of generic data type
	 * @param cmp list of values on which we have to sort
	 * @param k tells how many best items to select
	 * @return list of k best objects
	 */
	public <Temp> ArrayList<Temp> find_k_best(ArrayList<Temp> data, ArrayList<Integer> cmp, int k) {
		int i,j;
		for(i=0;i<cmp.size()-1;i++) {
			for(j=i+1;j<cmp.size();j++) {
				if(cmp.get(j) < cmp.get(i)) {
					Collections.swap(cmp, i, j);
					Collections.swap(data, i, j);
				}
			}
		}
		if(k>data.size())
			k = data.size();
		ArrayList<Temp> res = new ArrayList<Temp>(data.subList(0, k-1));
		return res;
	}
}
