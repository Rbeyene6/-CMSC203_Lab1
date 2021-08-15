
public class Smoothie extends Beverage {
	
	//instance variables for number of fruits and boolean variable to indicate 
	//if protein powder is added to the beverage
	private int numberOfFruits;
	private boolean protienPowder;
	//The cost of adding protein 
	private final double costOfPP=1.50;
	//additional fruit cost
	private final double additionalFruits=0.50;

	
	//getters and setters
	public int getNumberOfFruits() {
		return numberOfFruits;
	}
	public void setNumberOfFruits(int fruits) {
		numberOfFruits=fruits;
	}
	public boolean getAddProtienPowder() {
		return protienPowder;
	}
	public void setProtienPowder(boolean pP) {
		protienPowder=pP;
	}
	public double getCostofPP() {
		return costOfPP;
	}
	public double getAdditionalFruits() {
		return additionalFruits;
	}
	
	//A parameterized constructor
	public Smoothie(String beverageName, SIZE beverageSize, int fruits, boolean pP) {
		super(beverageName, TYPE.SMOOTHIE, beverageSize);
		protienPowder=pP;
		numberOfFruits=fruits;
		
		
	}
	
	//An Overridden  toString method
		public String toString() {
		//String representation of a Smoothie drink including the name , size
			String representation= "Beverage name : "+getBeverageName()+"/nBeverage size: "
		+getBeverageSize()+"Number of fruits: "+(numberOfFruits*getNumberOfFruits());
		//whether it contains Protein Powder
		if (protienPowder) {
			
			representation+="/nProtien Powder: "+getAddProtienPowder();
		}
		//the price of the smoothie
		representation+="/nCost: $"+calcPrice();
		return representation;
		}

	@Override
	public double calcPrice() {
				//size small, no protein powder, no extra fruits
				double totalPrice=super.getBaseSizePrice();
				
				//size medium
				if(super.getBeverageSize()==SIZE.MEDIUM) {
					totalPrice+=super.getLargerSizePrice();
				}
				//size large
				if(super.getBeverageSize()==SIZE.LARGE) {
					totalPrice+=(2*super.getLargerSizePrice());
				}
				//added protein powder
				if (protienPowder) {
					totalPrice+=getCostofPP();
				}
				//added fruit
				totalPrice+=getNumberOfFruits()*getAdditionalFruits();
				
				return totalPrice;
			}

	//An Overridden  equals method
		public boolean equals(Smoothie smoothie) {
			//checks equality based on the Beverage class equals method 
			if (super.equals(smoothie) 
					//and additional instance variables for this class.
					&& protienPowder==smoothie.getAddProtienPowder() 
					&& additionalFruits==smoothie.getAdditionalFruits())
			{
				return true;
			}
			else {
				return false;
			}
		}
}