
public class Alcohol extends Beverage{
	//additional instance variable for weather or not it is offered in the weekend
	private boolean onWeekend;
	//additional cost for drinks offered in the weekend
	private final double weekendCharge=0.6;

	//A parameterized constructor  
	public Alcohol(String beverageName, SIZE beverageSize, boolean weekend) {
		super(beverageName,TYPE.ALCOHOL, beverageSize);
		onWeekend=weekend;
	}

	//getters and setters
	public boolean getOnWeekend() {
		return onWeekend;
	}
	public void setOnWeekend(boolean weekend) {
		onWeekend=weekend;
	}
	public double getWeekendCharge() {
		return weekendCharge;
	}
	
	//An Overridden  toString method
			public String toString() {
			//String representation of an alcohol drink including the name , size
				String representation= "Beverage name : "+getBeverageName()+"/nBeverage size: "
			+getBeverageSize();
			//whether it is served on weekends
			if (onWeekend) {
				
				representation+="/nWeekend drink";
			}
			//the price of the drink
			representation+="/nCost: $"+calcPrice();
			return representation;
			}
	
	
	@Override
	public double calcPrice() {
		//size small, not served on weekends
		double totalPrice=super.getBaseSizePrice();
		
		//size medium
		if(super.getBeverageSize()==SIZE.MEDIUM) {
			totalPrice+=super.getLargerSizePrice();
		}
		//size large
		if(super.getBeverageSize()==SIZE.LARGE) {
			totalPrice+=(2*super.getLargerSizePrice());
		}
		//weekend charge
		if (onWeekend) {
			totalPrice+=getWeekendCharge();
		}
				
		return totalPrice;
	}

	//An Overridden  equals method
		public boolean equals(Alcohol alcohol) {
			//checks equality based on the Beverage class equals method 
			if (super.equals(alcohol) 
					//and additional instance variables for this class.
					&& onWeekend==alcohol.getOnWeekend())
			{
				return true;
			}
			else {
				return false;
			}
		}
}