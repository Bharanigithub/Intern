package SpringProj;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		DBDao dbDao=ctx.getBean("dao", DBDao.class);
		dbDao.firstTest();
	}
}
