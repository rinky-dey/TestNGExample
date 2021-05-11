package demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dummy {
	
	@BeforeSuite
	private void before_suit() {
		System.out.println("BS");
	}
	
	@BeforeTest
	private void before_test() {
		System.out.println("Before Test");

	}
	@BeforeClass
	private void before_class() {
		System.out.println("Before Class");

	}
	
	@BeforeMethod
	public void before_method() {
		System.out.println("Before Method");

	}
	
	@Test(priority=8 , groups = {"smoke"})
	public void test1() {
		
		System.out.println("Test 1");
	}
	
	@Test(priority = 2)
	public void test2() {
		
		int i=20;
		int j=100;
		int sum = i+j;
		System.out.println(i);
		System.out.println(j);
		System.out.println(sum);
		System.out.println("Test 2");
	}
	
	@AfterMethod
	private void after_method() {
		int a =100;
		System.out.println(a+20);
		System.out.println("After Method");

	}
	
	@AfterClass
	private void after_class() {
		System.out.println("After Class");

	}
	
	@AfterTest
	private void after_test() {
		System.out.println("After Test");
	}
	
	@AfterSuite
	private void after_suit() {
		System.out.println("AS");

	}
	
	
}
