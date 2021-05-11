package demo;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.DataReader;

public class Dummy2 {
	
	@BeforeClass
	private void before_class() {
		System.out.println("Before Class Dummy2");

	}
	
	@BeforeMethod()
	public void before_method() {
		System.out.println("Before Method");

	}
	
	
	@Test(priority = 9 , groups = {"smoke"})
	private void test6() {
		System.out.println("Test6");

	}
	
	@Test(groups = {"smoke" , "regression","sanity"})
	@Parameters("param")
	public void test1(String param) {
		
		System.out.println("Test 1 parameters :" +param);
	}
	
	@DataProvider(name = "testdata")
	public static Object[][] our_dataProvider() throws IOException{
		return DataReader.dataExcelReader("DummySheet");
		
	}
	
	@Test(dataProvider = "testdata" , priority = 6 , groups = {"sanity" , "regression" , "suravi"})
	public void parametrizedtest(String username , String password) {
		System.out.println(username +" : "+password);
	}
	
	
	@DataProvider(name = "testdata2")
	public static Object[][] our_dataProvider2() throws IOException{
		return new Object[][] {{"Ravi" , 5000 , 4}, {"Shyam" , 8000 , 46} , {"Ram" , 800, 45}};
		
	}
	
	@Test(dataProvider = "testdata2" , groups = {"regression"})
	public void parametrizedtest2(String username , int slary) {
		System.out.println(username +" : "+slary);
	}
	
	@Test(priority = 1)
	public void test2() {
		
		System.out.println("Test 2");
	}
	
	@AfterMethod
	private void after_method() {
		System.out.println("After Method");

	}
	
	@AfterClass
	private void after_class() {
		System.out.println("After Class Dummy2");

	}

}
