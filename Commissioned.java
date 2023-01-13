
public class Commissioned extends Employee {
	private double sales;
	
	public Commissioned(String fname, String lname, double totalsale) {
		super(fname,lname);
		sales = totalsale;
	}
	
	public double getSales() {
		return sales;
	}
	
	public void setSales(double totalSales) {
		if(totalSales >= 0) {
			sales = totalSales;
		} else {
			throw new IllegalArgumentException("The total sales should be over 0.0");
		}
	}
	
	@Override
	public double income() {
		return sales * 0.2;
	}
	
	@Override
	public String toString() {
		return String.format( "%sCommissioned\t\t$%,.2f\t$%,.2f", super.toString(), getSales(), income() );
	}

}
