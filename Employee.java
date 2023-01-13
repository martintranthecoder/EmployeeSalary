
public abstract class Employee {
	private String firstName;
	private String lastName;

	// Create a parameter constructor.
	public Employee(String first, String last) {
		firstName = first;
		lastName = last;
	}

	// Create the Mutator for first name
	public void setFirstName(String first) {
		firstName = first;
	}

	// Create the Accessor for first name
	public String getFirstName() {
		return firstName;
	}

	// Create the Mutator for last name
	public void setLastName(String last) {
		lastName = last;
	}

	// Create the Accessor for last name
	public String getLastName() {
		return lastName;
	}

	// Create the toString() method
	@Override
	public String toString() {
		return String.format("%s %s\t", getFirstName(), getLastName());
	}

	public abstract double income();

}
