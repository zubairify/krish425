
public class Citizen extends Person {
	private String aadhaar;

	public Citizen() {
		super();
	}

	public Citizen(String name, int age, String aadhaar) {
		super(name, age);	// Constructor chaining, to parent class
		this.aadhaar = aadhaar;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Aadhaar: " + aadhaar);
	}

	public static void main(String[] args) {
		Citizen c1 = new Citizen("Rao", 22, "123-2456");
		c1.print();
		
		Person pc = c1;
		pc.print();
		
	}
}
