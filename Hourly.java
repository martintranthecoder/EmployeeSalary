public class Hourly extends Employee {
	private double rate;
	private double hours;
	
	public Hourly(String fn, String ln, double rate, double hours) {
		super(fn, ln);
		this.rate = rate;
		this.hours = hours;
	}
	
	//Accessor Methods
	
	public double getRate() {
		return rate;
	}
	
	public double getHours() {
		return hours;
	}
	
	//Mutator Methods
	public void setRate(double wage) {
		rate = wage;
	}
	
	public void setHours(double hours) {
		if(hours >= 0.0 && hours <= 168.0) {
			this.hours = hours;
		} else {
			throw new IllegalArgumentException("Hours worked should be in between 0.0 and 168.0");
		}
	}
	
	@Override
	public double income() {
		if(hours <= 40) {
			return rate * hours;
		} else {
			return 40 * rate + (hours - 40) * rate * 2;
		}
	}
	
	@Override
	public String toString() {
		return String.format( "%sHourly\t\t%.2f\t\t$%,.2f\t$%,.2f", super.toString(), getHours(), getRate(), income());
	}
}
