package test;

import org.junit.Test;

import domain.Address;
import domain.Employee;
import domain.PayMaster;
import domain.TimeCard;
import junit.framework.Assert;

public class EmployeeWithFedAndStateTaxes {

	@Test
	public void testHourlyEmployeeWithNoHours() {
		Employee bob = new Employee("Bob", Employee.HOURLY_EMPLOYEE, 15.00);
		Address bobAddress = new Address("12 Easy St", "", "Denver", "CO");
		bob.setAddress(bobAddress);
		
		TimeCard timecard = new TimeCard(0);
		bob.setTimeCard(timecard);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(bob);
		
		Assert.assertEquals(0.0, netPay, .01);
		}
	
	@Test
	public void testHourlyEmployeeWithTenHours() {
		Employee carol = new Employee("Carol", Employee.HOURLY_EMPLOYEE, 15.00);
		Address carolAddress = new Address("1326 Aberford Ln", "", "San Jose", "CA");
		carol.setAddress(carolAddress);
		
		TimeCard timecard = new TimeCard(10);
		carol.setTimeCard(timecard);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(carol);
		
		Assert.assertEquals(142.50, netPay, .01);
		}
	
	@Test
	public void testHourlyEmployeeWithOvertimeHours() {
		Employee fred = new Employee("Fred", Employee.HOURLY_EMPLOYEE, 20.00);
		Address fredAddress = new Address("45 Echo Street", "Apartment 12", "Dallas", "TX");
		fred.setAddress(fredAddress);
		
		TimeCard timecard = new TimeCard(50);
		fred.setTimeCard(timecard);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(fred);
		
		Assert.assertEquals(930.77, netPay, 0.01);
		}
	
	@Test
	public void testWeeklyEmployee() {
		Employee ted = new Employee("TED", Employee.WEEKLY_EMPLOYEE, 750.00);
		Address tedAddress = new Address("3801 Gardenside Drive", "Apartment 2B", "Willoughby", "OH");
		ted.setAddress(tedAddress);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(ted);
		
		Assert.assertEquals(636.35, netPay, .01);
		
	}
	
	@Test
	public void testMonthlyEmployee() {
		Employee alice = new Employee("Alice", Employee.MONTHLY_EMPLOYEE, 10000.00);
		Address aliceAddress = new Address("98 Glory Road", "", "Bismarck", "ND");
		alice.setAddress(aliceAddress);
		
		PayMaster paymaster = new PayMaster();
		
		double netPay = paymaster.pay(alice);
		
		Assert.assertEquals(7641.66, netPay, .01);
		
	}
}