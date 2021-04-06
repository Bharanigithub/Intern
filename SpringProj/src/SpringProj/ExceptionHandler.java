package SpringProj;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionHandler implements ThrowsAdvice{
	public void afterThrowing(OneShopPerCustomerException e) {
		System.out.println("Exception advice called........."+e);
	}
}
