
public class Coffee extends Beverage {
	//additional instance variables of type boolean to indicate extra shot of coffee and extra syrup 
	private boolean extraShot=true;
	private boolean extraSyrup=true;
	// for each scenario additional cost of 50 cents
	private final double additionalCost=0.5;
	
	//getters and setters
	public boolean getExtraShot() {
		return extraShot;
	}
	public void setExtraShot(boolean additionalShot) {
		extraShot=additionalShot;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	public void setExtraSyrup(boolean additionalSyrup) {
		extraSyrup=additionalSyrup;
	}
	public double getAdditionalCost() {
		return additionalCost;
	}
	
	//A parameterized constructor  
	public Coffee(String beverageName, SIZE beverageSize,
			boolean additionalShot, boolean additionalSyrup) {
		
		super(beverageName,TYPE.COFFEE,beverageSize);
		extraShot=additionalShot;
		extraSyrup=additionalSyrup;

	}
	//An Overridden  toString method
	public String toString() {
	//String representation of Coffee beverage, including the name , size
		String representation= "Beverage name : "+getBeverageName()+"/nBeverage size: "+getBeverageSize();
	//whether it contains extra shot
	if (extraShot) {
		
		representation+="/nExtra Shots: "+getExtraShot();
	}
	//whether it contains extra syrup
	if (extraSyrup) {
		representation+="/nExtra Syrup: "+getExtraSyrup();
	}
	//the price of the coffee
	representation+="/nCost: $"+calcPrice();
	return representation;
	}

	@Override
	public double calcPrice() {
		//size small, no extra shot, no extra syrup
		double totalPrice=super.getBaseSizePrice();
		
		//size medium
		if(super.getBeverageSize()==SIZE.MEDIUM) {
			totalPrice+=super.getLargerSizePrice();
		}
		//size large
		if(super.getBeverageSize()==SIZE.LARGE) {
			totalPrice+=(2*super.getLargerSizePrice());
		}
		//extra shot
		if (extraShot) {
			totalPrice+=additionalCost;
		}
		//extra syrup
		if (extraSyrup) {
			totalPrice+=additionalCost;
		}
		return totalPrice;
	}
	//An Overridden  equals method
	public boolean equals(Coffee coffee) {
		//checks equality based on the Beverage class equals method 
		if (super.equals(coffee) 
				//and additional instance variables for this class.
				&& extraShot==coffee.getExtraShot() 
				&& extraSyrup==coffee.getExtraSyrup())
		{
			return true;
		}
		else {
			return false;
		}
	
	}
}