
public class Salary extends Employee {
	private double weeklyPay;
	
	public Salary(String fname, String lname, double pay) {
		super(fname, lname);
		this.weeklyPay = pay;
	}
	
	public void setWeeklyPay(double salary){
		if (salary >= 0.0) {
			weeklyPay = salary;
		} else {
			throw new IllegalArgumentException("Weekly salary should be over 0.0");
		}
	}
	
	public double getWeeklyPay() {
		return weeklyPay;
	}
	
	@Override
	public double income() {
		return getWeeklyPay();
	}
	
	@Override
	public String toString() {
		return String.format( "%sSalaried\t\t\t\t$%,.2f", super.toString(), income() );
	}

}
