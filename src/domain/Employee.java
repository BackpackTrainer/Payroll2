package domain;

public class Employee {
	
	public static final int HOURLY_EMPLOYEE = 1;
	public static final int WEEKLY_EMPLOYEE = 2;
	public static final int MONTHLY_EMPLOYEE = 3;
	
	private String name;
	private int employeeType;
	private TimeCard timeCard;
	private Address address;
	

	double hourlyPay = 0.0;
	double weeklyPay = 0.0;
	double monthlyPay = 0.0;
	

	public Employee(String name, int employeeType, double payRate) {
		this.name = name;
		this.employeeType = employeeType;
		
		if (employeeType == HOURLY_EMPLOYEE)  
			hourlyPay = payRate;
		
		else if (employeeType == WEEKLY_EMPLOYEE )  {
			weeklyPay = payRate;
		}
		
		else if (employeeType == MONTHLY_EMPLOYEE)  {
			monthlyPay = payRate;
		}
		
	}
	
	public Employee(String name, int employeeType, Address address, double payRate) {
		this.name = name;
		this.employeeType = employeeType;
		this.address = address;
		
		if (employeeType == HOURLY_EMPLOYEE)  
			hourlyPay = payRate;
		
		else if (employeeType == WEEKLY_EMPLOYEE )  {
			weeklyPay = payRate;
		}
		
		else if (employeeType == MONTHLY_EMPLOYEE)  {
			monthlyPay = payRate;
		}
		
	}

	public void setTimeCard(TimeCard timecard) {
		this.timeCard = timecard;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public double getWeeklyPay() {
		return weeklyPay;
	}

	public void setWeeklyPay(double weeklyPay) {
		this.weeklyPay = weeklyPay;
	}

	public double getMonthlyPay() {
		return monthlyPay;
	}

	public void setMonthlyPay(double monthlyPay) {
		this.monthlyPay = monthlyPay;
	}

	public TimeCard getTimeCard() {
		return timeCard;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
