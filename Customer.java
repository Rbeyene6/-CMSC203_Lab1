
public class Customer {
//instance variable for name and age
private String name;
private int age;

/* Parameterized constructor  
 * @param name
 * @param age
 */
public Customer(String name, int age) {
	this.name=name;
	this.age=age;
}
/* Copy constructor
 * 
 */
public Customer(Customer customer) {
	this.name=customer.name;
	this.age=customer.age;
}
//get Method for name
public String getName() {
	return name;
}
// set Method for name
public void setName(String name) {
	this.name=name;
}
//get Method for age
public int getAge() {
	return age;
}
//set Method for age
public void setAge(int age) {
	this.age=age;
}
//an overridden toString Method
public String toString() {
	return "Customer name : "+name+"/nCustomer age: "+age;
}
}
