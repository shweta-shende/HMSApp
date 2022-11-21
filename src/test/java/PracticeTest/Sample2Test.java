package PracticeTest;

import org.testng.annotations.Test;

public class Sample2Test {

	@Test(groups="smoke")
	public void CreateCustomer1()
	{
		System.out.println(" created successfully");
	}
	@Test
	public void UpdateCustomer2()
	{
		System.out.println(" update successfully");
	}
	@Test
	
	public void deleteCustomer3()
	{
		System.out.println(" delete successfully");
	}
}
