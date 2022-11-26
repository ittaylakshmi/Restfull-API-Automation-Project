package practice;

public class ChildCons extends ParentCons {
	
	public ChildCons (int a) {
		System.out.println("Child Class Calling From Int-Org Constructor");
	}
	
	public ChildCons (int a, int b) {
		System.out.println("Child Class Calling From Two Int-Org Constructor");
	}
	
	public ChildCons (String s1) {
		this(9,10);
		System.out.println("Child Class Calling From String Org Constructor");
	}
	
	public void display() {
		System.out.println("This is normal method from Child Class");
	}

	public void ParentCons () {
//	public ParentCons () {
		System.out.println("Calling from Parent Class No Org Constructor");
	}
	
	public static void main(String[] args) {
		ChildCons c1 = new ChildCons("ittay");
		c1.display();
	}
}
