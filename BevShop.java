import java.util.*;
public class BevShop implements BevShopInterfce {
	//Instance variable for the number of Alcohol drinks ordered for the current order
	private int alcoholPerOrder;
	//Maximum number of alcohol beverage that can be ordered within an order
	private int orderNumbers;
	//An instance  list to keep track of orders
	private ArrayList<Order>ordersThusFar=new ArrayList<Order>();
	
	
	//Checks if the time is valid (between 8 and 23 )
	public boolean validTime(int time) {
			if(MIN_TIME<=time && time<=MAX_TIME)
				return true;
			else
				return false;
	}
	// checks if the number of alcohol beverages for the current order has reached the maximum
	public boolean eligibleForMore() {
		if(alcoholPerOrder>=MAX_ORDER_FOR_ALCOHOL)
			return false;
		else
			return true;
	}
	//check the valid age for the alcohol drink
	public boolean validAge(int age) {
		if(age <= MIN_AGE_FOR_ALCOHOL)
			return false;
		else
			return true;
	}
	//Creates a new order ,  NO BEVERAGE is added to the order yet 
	public void startNewOrder(int time, DAY day, String customerName, 
			int customerAge) 
	{
		Customer newCustomer=new Customer(customerName,customerAge);
		Order newOrder= new Order(time, day, newCustomer);
		ordersThusFar.add(newOrder);
		orderNumbers=ordersThusFar.indexOf(newOrder);
		alcoholPerOrder=0;
		
	}

	//process the Coffee order for the current order by adding it to the current order
	public void processCoffeeOrder(String beverageName, SIZE beverageSize,
			boolean additionalShot, boolean additionalSyrup) 
	{
		ordersThusFar.get(orderNumbers).addNewBeverage(beverageName,
				beverageSize, additionalShot, additionalSyrup);
		
	}

	//process the Smoothie order for the current order  by adding it to the current order
	public void processSmoothieOrder(String beverageName, SIZE beverageSize, 
			int fruits, boolean protienPowder) 
	{
		ordersThusFar.get(orderNumbers).addNewBeverage(beverageName,
				beverageSize, fruits, protienPowder);
		
	}
	
	//process the Alcohol order for the current order by adding it to the current order
	public void processAlcoholOrder(String beverageName, SIZE beverageSize)
	{
		ordersThusFar.get(orderNumbers).addNewBeverage(beverageName, beverageSize);
		alcoholPerOrder++;
	}
	// locate an order based on  the order number
	public int findOrder(int orderNumber) 
	{

		for (int index=0; index<ordersThusFar.size();index++) 
		{
			if (ordersThusFar.get(index).getOrder_Number()==orderNumber)
				return index;
			
		}	
		return -1;
	}
	
	//locates an order in the list of orders and returns the total value on the order
	public double totalOrderPrice(int orderNumber)
	{
	double total=0;
	
	for (Order currentOrder:ordersThusFar) 
	{
		if(currentOrder.getOrder_Number()==orderNumber) 
		{
			
			for(Beverage bev:currentOrder.getBeverageList())
			{
				total+=bev.calcPrice();
			
			}
		}
	}
		return total;
	}
	
	//Calculates the total sale of all the orders for this beverage shop
	public double totalMonthlySale() {
		double totalMonthly=0;
		for (int i=0;i<ordersThusFar.size();i++)
		{
			
			totalMonthly+=totalOrderPrice(i);
		}
		return totalMonthly;
	}
	
	//sorts the orders within this bevShop using the Selection sort algorithm
	public void sortOrders() {
		int indexedOrder=ordersThusFar.get(0).getOrder_Number();
				for(int j=1;j<ordersThusFar.size();j++)
				{
					if((ordersThusFar.get(indexedOrder).getOrder_Number())>
						(ordersThusFar.get(j).getOrder_Number())) 
						indexedOrder=j;
				}
				
			Order first=ordersThusFar.get(indexedOrder);
			ordersThusFar.set(indexedOrder, ordersThusFar.get(indexedOrder));
			ordersThusFar.set(indexedOrder, first);
			}
	
	//returns Order in the list of orders at the index
	public Order getOrderAtIndex(int i) {
		return ordersThusFar.get(i);
	}
	
	public Order getCurrentOrder() {
		return ordersThusFar.get(orderNumbers);
	}

	//getter for alcohols ordered thus far
	public Object getNumOfAlcoholDrink() {
		return alcoholPerOrder;
	}

	public Object totalNumOfMonthlyOrders() {
		return ordersThusFar.size();
	}
	//Maximum number of fruits that this shop offers for SMOOTHIE beverage
	public boolean isMaxFruit(int i) {
		if(i>MAX_FRUIT)
			return true;
		else
			return false;
	}
	//an overridden toString method to display all the orders and the total monthly sale.  
	public String toString() {
		String str = "Monthly sale report\n";
		  
		for (Order order : ordersThusFar) 
		{
			str += order.toString();
		}
		
		str += "Total Sale for the month: " +totalMonthlySale();
		  
		return str;
		}
	//getter for maximum order for alcohol
	public int getMaxOrderForAlcohol() {
		
		return MAX_ORDER_FOR_ALCOHOL;
	}
	//getter for minimum age for alcohol
	public int getMinAgeForAlcohol() {
		
		return MIN_AGE_FOR_ALCOHOL;
	}
	}


