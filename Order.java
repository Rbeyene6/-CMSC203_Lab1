import java.util.*;
public class Order implements OrderInterface, Comparable{

	private int order_Number;
	private int order_Time;
	private DAY order_Day;
	Customer customer;
	private ArrayList<Beverage>beverageList;
	
	
	//getters and setters
	public int getOrder_Number() {
		return order_Number;
	}
	public void setOrder_Number(int orderNumber) {
		order_Number=orderNumber;
	}
	public int getOrder_Time() {
		return order_Time;
	}
	public void setOrder_Time(int orderTime) {
		order_Time=orderTime;
	}
	public DAY getOrder_Day() {
		return order_Day;
	}
	public void setOrder_Day(DAY orderDay) {
		order_Day=orderDay;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer cust) {
		customer= new Customer(cust);
	}
	public ArrayList<Beverage>getBeverageList(){
		return beverageList;
	}
	
		
	//random number generator method from 10,000 to 90,000
	//@param lowerRange, @param upperRange, @param randGen
	public int randGenerator() {
        int lowerRange = 10000;
        int upperRange = 90000;

        Random rand = new Random();
        int randGen = rand.nextInt(upperRange - lowerRange) + lowerRange;

        return randGen;
     }
	
	//A parameterized constructor 
	public Order(int orderTime, DAY orderDay, Customer newCustomer) {
		order_Time=orderTime;
		order_Day=orderDay;
		customer=newCustomer;
		this.beverageList=new ArrayList<Beverage>();
		
		
	}
	
	//An overloaded method called addNewBeverage that adds a beverage to the order
	@Override
	public void addNewBeverage(String beverageName, SIZE beverageSize,
			boolean additionalShot, boolean additionalSyrup) {
		Coffee coffee=new Coffee(beverageName,beverageSize,additionalShot,additionalSyrup);
		this.beverageList.add(coffee);
		
	}
	@Override
	public void addNewBeverage(String beverageName, SIZE beverageSize) {
		boolean onWeekend=false;
		if(order_Day==DAY.SATURDAY||order_Day==DAY.SUNDAY) {
			onWeekend=true;
		}
		Alcohol alcohol=new Alcohol(beverageName, beverageSize, onWeekend);
		this.beverageList.add(alcohol);
		
	}
	@Override
	public void addNewBeverage(String beverageName, SIZE beverageSize, int fruits, boolean pP) {
		Smoothie smoothie=new Smoothie(beverageName, beverageSize, fruits, pP);
		this.beverageList.add(smoothie);
	}

	//An Overridden toString method
	public String toString() {
		String string="Order Number: "+order_Number+"/nOrder Time: "+order_Time+
				"Order Date: "+order_Day+"Customer: "+customer+"Age: ";
		for (Beverage drink:beverageList) {
			string+="\n"+drink.toString();
		}
		string+="\n Total Cost: "+calcOrderTotal();
		return string;
	}
	
	//Override the compareTo method to compare this order with another order based on the order number
	@Override
	public int compareTo(Order order) {
		//Returns 0 if this order number is same as another order's order number
		if (order_Number==order.getOrder_Number()) {
			return 0;
		}
		//1 if it is greater than another order's order number
		else if (order_Number>order.getOrder_Number()) {
			return 1;
		}
		//-1 if it smaller than another order's order number
		else 
			return -1;
	}

	
	//additional methods
	@Override
	public int compareTo(Object order) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public boolean isWeekend() {
		if(order_Day==DAY.SATURDAY||order_Day==DAY.SUNDAY) {
			return true;
		}
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverageList.get(itemNo);
	}

	
	@Override
	public double calcOrderTotal() {
		double totalCost=0;
		for(Beverage drinks:beverageList) {
			totalCost+=drinks.calcPrice();
		}
		return totalCost;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int numOfDrinkType=0;
		for (Beverage drink:beverageList) {
			if (drink.getBeverageType()==type) {
				numOfDrinkType++;
			}
		}
		return numOfDrinkType;
	}

	public int getTotalItems() {
		return beverageList.size();
	}
	
	
	}


