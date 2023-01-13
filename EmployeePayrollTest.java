import java.util.*;

public class EmployeePayrollTest {
	public static void main(String[] args) {
		String fname;
		String lname;
		String type;
		double hourlyRate;
		double weeklySalary;
		double workHour;
		double totalSale;
		boolean bonus = false;
		
		int numEmployee =0;
		int numSalaried = 0;
		int numHourly = 0;
		int numCommissioned = 0;
		
		Employee[] employees = new Employee[50];
		Salary[] salariedEmp = new Salary[50];
		Hourly[] hourlyEmp = new Hourly[50];
		Commissioned[] comEmp = new Commissioned[50];
		
		Scanner in = new Scanner(System.in);
		String choice = "c";
		
		while(choice.equals("c")) {
			
			System.out.print("Enter employee's first name: ");
			fname = in.next();
			
			System.out.print("Enter employee's last name: ");
			lname = in.next();
			
			System.out.print("Enter employee's type (Salaried/Hourly/Commissioned): ");
			type = in.next();
			
			if (type.equalsIgnoreCase("Salaried")) {
				System.out.print("Enter employee's weekly pay: ");
				weeklySalary = in.nextDouble();
				salariedEmp[numSalaried] = new Salary(fname, lname, weeklySalary);
				employees[numEmployee] = salariedEmp[numSalaried];
				
				
				
				numSalaried++;
				numEmployee++;
			} else if(type.equalsIgnoreCase("Hourly")) {
				System.out.print("Enter employee's hourly rate: ");
				hourlyRate = in.nextDouble();
				System.out.print("Enter employee's worked hours: ");
				workHour = in.nextDouble();
				hourlyEmp[numHourly] = new Hourly(fname, lname, hourlyRate, workHour);
				employees[numEmployee] = hourlyEmp[numHourly];
				
				numHourly++;
				numEmployee++;
					
			} else if(type.equalsIgnoreCase("Commissioned")) {
				System.out.print("Enter employee's total weekly sales: ");
				totalSale = in.nextDouble();
				comEmp[numCommissioned] = new Commissioned(fname, lname, totalSale);
				employees[numEmployee] =  comEmp[numCommissioned];
				
				numCommissioned++;
				numEmployee++;
				
			} else {
				System.out.println("Invalid Employee Type");
			}
			
			System.out.print("Enter \"c\" to continue type in new employee's information or \"e\" for exit: ");
			choice = in.next();
			System.out.println();
		}
		double total = 0.0;
		System.out.println( "\nName\t\tClass\t\tHours\tSales\tRate\tWeekely Pay" );
		System.out.println("===============================================================================");
		
		for(int i = 0; i < numEmployee; i++) {
			fname = employees[i].getFirstName();
			lname = employees[i].getLastName();
			
			if (bonusApplies(fname, lname)) {
				bonus = true;
			} else {
				bonus = false;
			}
			
			if(employees[i].getClass().getName().equals("Salary") && bonus == true) {
				System.out.print(employees[i]);
				System.out.println("*");
				total+= employees[i].income();
			} else {
				System.out.println(employees[i]);
				total+= employees[i].income();
			}
		}
		
		
		System.out.println("===============================================================================");
		
		System.out.printf("Total: $%,.2f\n",total);


		System.out.println("*A 10% bonus is awarded");
		
	
		
		in.close();
	}
	
	public static boolean bonusApplies(String fname, String lname) {
		String name = "";
		name += fname + " " + lname;
	    String[] employeesWithBonus = {"James Hogan"};
	    for (String employee : employeesWithBonus) {
	        if (name.equalsIgnoreCase(employee)) {
	            return true;
	        }
	    }
	    return false;
	}


}
