package domain;

public class TimeCard {
	
	private int hoursWorked;

	public TimeCard(int hours) {
		hoursWorked = hours;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

}
