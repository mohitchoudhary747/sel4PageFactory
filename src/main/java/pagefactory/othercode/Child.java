package pagefactory.othercode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Child extends Parent{

	
	@BeforeMethod(alwaysRun = true)
	public void firstChildBefore() {
		System.out.println("Method Name is ->"
				+Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println("Method Name is ->"
				+Thread.currentThread().getStackTrace()[1]);
		
	}
	
	@Test()
	public void runingTest() {
		System.out.println("This is test block");
		
	}
}
