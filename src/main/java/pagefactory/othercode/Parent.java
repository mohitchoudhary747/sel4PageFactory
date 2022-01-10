package pagefactory.othercode;

import org.testng.annotations.BeforeMethod;

public class Parent {
	
	@BeforeMethod
	public void firstParentBefore() {
		System.out.println("Method Name is ->"
				+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	@BeforeMethod
	public void secondtParentBefore() {
		System.out.println("Method Name is ->"
				+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	

}
