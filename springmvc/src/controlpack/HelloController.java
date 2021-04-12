package controlpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "hello")
public class HelloController {
	@Autowired
	private MyBusiness myBusiness;
	@RequestMapping(value = "hello1",method = RequestMethod.GET)
	public void method1() {
		System.out.println("Welcome to Method 1!!");
	}
	@RequestMapping(value = "hello2",method = RequestMethod.GET)
	public void method2() {
		System.out.println("Welcome to Method 2!!");
	}
	@RequestMapping(value = "hello3",method = RequestMethod.GET)
	public String method3() {
		System.out.println("Welcome to Method 3!!");
		myBusiness.doBusiness();
		return "welcome";
	}
	@RequestMapping(value="hello4", method = RequestMethod.GET)
	public ModelAndView method4() {
		System.out.println("Welcome to Method4!!");
		Employee emp=myBusiness.doBusiness();
		ModelAndView mandv=new ModelAndView();
		mandv.setViewName("welcome");
		mandv.addObject("hello","Hello World!!!");
		mandv.addObject("emp",emp);
		return mandv;
	}
}

class Employee{
	@Override
	public String toString() {
		return "Employee Object!!";
	}
}
@Component
class MyBusiness{
	@Autowired
	private MyService myservice;
	
	public Employee doBusiness() {
		System.out.println("Business Method!!");
		myservice.doService();
		return new Employee();
	}

	public MyService getMyservice() {
		return myservice;
	}

	public void setMyservice(MyService myservice) {
		this.myservice = myservice;
	}
}

@Service
class MyService{
	@Autowired
	private MyDao mydao;
	
	public void doService() {
		System.out.println("Service Method!!");
		mydao.doDao();
	}

	public MyDao getMydao() {
		return mydao;
	}

	public void setMydao(MyDao mydao) {
		this.mydao = mydao;
	}
}

@Repository
class MyDao{
	public void doDao() {
		System.out.println("DAO Method!!");
	}
}