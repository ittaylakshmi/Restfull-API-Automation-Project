package practice;

public class ParentCons {
	
	public ParentCons () {
		System.out.println("Calling from Parent Class No Org Constructor");
	}

	public ParentCons (String s1) {
		System.out.println("Calling from Parent Class Single Org Constructor");
	}
	
	public ParentCons (String a1, String a2) {
		System.out.println("Calling from Parent Class Two Org Constructor");
	}
	
	public void display() {
		System.out.println("This is normal method from Parent Class");
	}
}
