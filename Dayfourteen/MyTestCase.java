package Dayfourteen;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTestCase {

	@Test
	public void test() {
		Calculator calci=new Calculator();
		int result=calci.add(10, 10);
		assertEquals(20, result);
	}

}
