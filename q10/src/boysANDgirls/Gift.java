/**
 * By Sudeept Dwivedi IIT2015017
   IPPL430C Assignment ( Dr. Rahul Kala)
 */
package boysANDgirls;

/**
 * @author user
 *
 */
public class Gift {
	
	private String name;
	private int price;
	private int value;
	private int luxury_rating;
	private int difficulty;
	private int utility_class;
	private int utility_value;
	private int type; //1-essential, 2-luxury, 3-utility
	
	
	
	
	/**
	 * Constructor for essential gift
	 * @param name
	 * @param price
	 * @param value
	 * @param type
	 */
	public Gift(String name, int price, int value, int type) {
		super();
		this.name = name;
		this.price = price;
		this.value = value;
		this.type = type;
	}
	
	/**
	 * Constructor for luxury and utility gifts
	 * @param name
	 * @param price
	 * @param value
	 * @param lorclass
	 * @param doruvalue
	 * @param type
	 */
	public Gift(String name, int price, int value, int lorclass, int doruvalue, int type) {
		super();
		this.name = name;
		this.price = price;
		this.value = value;
		if(type==1) {
			this.luxury_rating = lorclass;
			this.difficulty = doruvalue;
		}
		else if(type==2) {
			this.utility_class = lorclass;
			this.utility_value = doruvalue;
		}
		this.type = type;
	}


	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}


	public int getLuxury_rating() {
		return luxury_rating;
	}


	public void setLuxury_rating(int luxury_rating) {
		this.luxury_rating = luxury_rating;
	}


	public int getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}


	public int getUtility_class() {
		return utility_class;
	}


	public void setUtility_class(int utility_class) {
		this.utility_class = utility_class;
	}


	public int getUtility_value() {
		return utility_value;
	}


	public void setUtility_value(int utility_value) {
		this.utility_value = utility_value;
	}
	
	
	
	

}
