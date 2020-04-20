package test;

import org.junit.Test;

import domain.Employee;
import domain.PayMaster;
import domain.TimeCard;
import junit.framework.Assert;

public class EmployeeWithoutTaxes {


	@Test
	public void testHourlyEmployeeWithNoHours() {
		Employee bob = new Employee("Bob", Employee.HOURLY_EMPLOYEE, 15.00);
		TimeCard timecard = new TimeCard(0);
		bob.setTimeCard(timecard);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(bob);
		
		Assert.assertEquals(0.0, netPay, .01);
			}
	
	@Test
	public void testHourlyEmployeeWithTenHours() {
		Employee carol = new Employee("Carol", Employee.HOURLY_EMPLOYEE, 15.00);
		TimeCard timecard = new TimeCard(10);
		carol.setTimeCard(timecard);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(carol);
		
		Assert.assertEquals(150.0, netPay, .01);
			}
	
	@Test
	public void testHourlyEmployeeWithOvertimeHours() {
		Employee fred = new Employee("Fred", Employee.HOURLY_EMPLOYEE, 20.00);
		TimeCard timecard = new TimeCard(50);
		fred.setTimeCard(timecard);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(fred);
		
		Assert.assertEquals(1100.0, netPay, .01);
			}
	
	@Test
	public void testWeeklyEmployee() {
		Employee ted = new Employee("TED", Employee.WEEKLY_EMPLOYEE, 750.00);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(ted);
		
		Assert.assertEquals(750.0, netPay, .01);
		
	}
	
	@Test
	public void testMonthlyEmployee() {
		Employee ted = new Employee("Alice", Employee.MONTHLY_EMPLOYEE, 7500.00);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(ted);
		
		Assert.assertEquals(7500.0, netPay, .01);
		
	}

}