
abstract class Beverage {
	
//Instance variables for beverage name, beverage type, size
	
private String beverageName;
private TYPE beverageType;
private SIZE beverageSize;

//constant attributes for the base price ($2.0) and size price (additional $1 to go a size up)

private final double baseSizePrice=2.0;
private final double largerSizePrice=1.0;

//getters and setters

public String getBeverageName() {
	return beverageName;
}
public TYPE getBeverageType() {
	return beverageType;
}
public SIZE getBeverageSize() {
	return beverageSize;
}
public double getBaseSizePrice() {
	return baseSizePrice;
}
public double getLargerSizePrice() {
	return largerSizePrice;
}
public void setBeverageName(String newbeverageName) {
	beverageName=newbeverageName;
}
public void setBeverageType(TYPE newbeverageType) {
	beverageType=newbeverageType;
}
public void setBeverageSize(SIZE newbeverageSize) {
	beverageSize=newbeverageSize;
}


/*A parameterized constructor to create a Beverage object given its name, type and  size
 * @param beverageName
 * @param beverageType
 * @param beverageSize
 */

public Beverage(String beverageName1, TYPE beverageType1, SIZE beverageSize1) {
	beverageName=beverageName1;
	beverageType=beverageType1;
	beverageSize=beverageSize1;
}

//An abstract methods called calcPrice that calculates and returns the beverage price

public abstract double calcPrice(); 

//An Overridden  toString method: String representation for Beverage including the name and size

public String toString() {
	return "Beverage name : "+beverageName+"/nBeverage size: "+beverageSize;
}

//An Overridden  equals method: checks equality based on name, type, size of the beverage
public boolean equals(Beverage beverage) {
	
	if (this.beverageName.equals(beverage.beverageName) 
			&& this.beverageType.equals(beverage.beverageType) 
			&& this.beverageSize.equals(beverage.beverageSize))
	{
		return true;
	}
	else {
		return false;
	}
	
}

}
