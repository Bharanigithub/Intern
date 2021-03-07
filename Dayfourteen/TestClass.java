package Dayfourteen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClass {
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("SetUpBefore Class Called!");
	}
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("TearDownAfter Class Called!");
	}
	@After
	public void setUp() {
		System.out.println("Setup Class");
	}
	@Before
	public void tearDown() {
		System.out.println("TearDown Class!");
	}
	@Test
	public void test1() {
		System.out.println("Test 1!!");
	}
	public void test2() {
		System.out.println("Test 2!!");
	}
	public void test3() {
		System.out.println("Test 3!!");
	}
}
