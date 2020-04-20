package domain;

public class PayMaster {

	public double pay(Employee employee) {
		
		double gp = 0;  //gross pay
		double np = 0;  //net pay
		double ap = 0;  //annual pay
		double ft = 0;  //federal taxes
		double st = 0;  //state taxes
		
		if (employee.getEmployeeType() == employee.HOURLY_EMPLOYEE)  {
			TimeCard timeCard = employee.getTimeCard();
			
			int hoursWorked = timeCard.getHoursWorked();
			
			double hourlyRate = employee.getHourlyPay();
			
			//calculating the gross pay for an Hourly Employee
			int overtimeHours = 0;
			double overtimePay = 0.0;
			double basePay = 0.0;
			
			if (hoursWorked <= 40)  {
				basePay = hoursWorked * hourlyRate;
			}
			 
			else if (hoursWorked > 40)  {
				basePay = hourlyRate * 40;
				overtimeHours = (hoursWorked - 40);
				overtimePay = overtimeHours * hourlyRate * 1.5;
			}
			
			gp = basePay + overtimePay;
			
			//calculating federal taxes for the hourly employee
			ap = gp * 52;
			
			if (ap < 10000)  {
				ft = 0;
			}
			
			else if (ap >= 10000 && ap < 40000)  {
				double annualFedTaxes = .15*(ap - 10000);
				ft = annualFedTaxes/52;
			
			}
			
			else if (ap >= 40000 && ap < 100000)  {
				double annualFedTaxes = 4500 + .25*(ap - 40000);
				ft = annualFedTaxes/52;
			
			}
			
			else if (ap >= 100000)  {
				double annualFedTaxes = 20500 + .33*(ap - 100000);
				ft = annualFedTaxes/52;
			
			}
			
			//calculating state taxes for the hourly employee
			switch (employee.getAddress().getState() )  {
			case "CO":
				st = .03 * gp;
				break;
				
			case "CA":
				if (ap < 100000)
					st = .05 * gp;
				else
					st = (5000 + .1 * (ap - 100000)) / 52;
				
				break;
				
			case "TX":
				st = 0;
				break;
				
			case "OH":
				st = .04 * gp;
				break;
			
			case "ND":
				st = .01 * gp;
				break;
				
			default:
				st = .02*gp;
			}
			
		}
		
		//calculating the gross pay for a Weekly Employee
		else if (employee.getEmployeeType() == employee.WEEKLY_EMPLOYEE)  {
			gp = employee.getWeeklyPay();
			
			//calculating federal taxes for the weekly employee
			ap = gp * 52;
			
			if (ap < 10000)  {
				ft = 0;
			}
			
			else if (ap >= 10000 && ap < 40000)  {
				double annualFedTaxes = .15*(ap - 10000);
				ft = annualFedTaxes/52;
			
			}
			
			else if (ap >= 40000 && ap < 100000)  {
				double annualFedTaxes = 4500 + .25*(ap - 40000);
				ft = annualFedTaxes/52;
			
			}
			
			else if (ap >= 100000)  {
				double annualFedTaxes = 20500 + .33*(ap - 100000);
				ft = annualFedTaxes/52;
			
			}
			
			//calculating state taxes for the weekly employee
			switch (employee.getAddress().getState() )  {
			case "CO":
				st = .03 * gp;
				break;
				
			case "CA":
				if (ap < 100000)
					st = .05 * gp;
				else
					st = (5000 + .1 * (ap - 100000)) / 52;
				
				break;
				
			case "TX":
				st = 0;
				break;
				
			case "OH":
				st = .04 * gp;
				break;
			
			case "ND":
				st = .01 * gp;
				break;
				
			default:
				st = .02*gp;
			}
		}
		
		//calculating the gross pay for an Monthly Employee
		else if (employee.getEmployeeType() == employee.MONTHLY_EMPLOYEE)  {
			gp = employee.getMonthlyPay();
			
				//calculating federal taxes for the weekly employee
				ap = gp * 12;
				
				if (ap < 10000)  {
					ft = 0;
				}
				
				else if (ap >= 10000 && ap < 40000)  {
					double annualFedTaxes = .15*(ap - 10000);
					ft = annualFedTaxes/12;
				
				}
				
				else if (ap >= 40000 && ap < 100000)  {
					double annualFedTaxes = 4500 + .25*(ap - 40000);
					ft = annualFedTaxes/12;
				
				}
				
				else if (ap >= 100000)  {
					double annualFedTaxes = 20500 + .33*(ap - 100000);
					ft = annualFedTaxes/12;
				}
				
				//calculating state taxes for the monthly employee
				switch (employee.getAddress().getState() )  {
				case "CO":
					st = .03 * gp;
					break;
					
				case "CA":
					if (ap < 100000)
						st = .05 * gp;
					else
						st = (5000 + .1 * (ap - 100000)) / 12;
					
					break;
					
				case "TX":
					st = 0;
					break;
					
				case "OH":
					st = .04 * gp;
					break;
				
				case "ND":
					st = .01 * gp;
					break;
					
				default:
					st = .02*gp;
				}
		}
		
		np = gp - (ft + st);
		return np;
		
	}	

}
