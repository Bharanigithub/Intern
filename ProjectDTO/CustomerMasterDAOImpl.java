package ProjectDTO;

import java.util.*;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class CustomerMasterDAOImpl implements CustomerMasterDAO {

	@Override
	public int insert(CustomerMasterDTO cus) {
		Session session=HibernateUtility.getSession();
		session.save(cus);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int update(CustomerMasterDTO cus) {
		Session session=HibernateUtility.getSession();
		session.save(cus);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int delete(int cusno) {
		CustomerMasterDTO customerMasterDTO=findById(cusno);
		Session session=HibernateUtility.getSession();
		System.out.println("Details:"+customerMasterDTO);
		session.delete(customerMasterDTO);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public CustomerMasterDTO findById(int cusno) {
		Session session=HibernateUtility.getSession();
		CustomerMasterDTO cus=(CustomerMasterDTO)session.get(CustomerMasterDTO.class,cusno);
		HibernateUtility.closeSession(null);
		return cus;
	}

	@Override
	public List<CustomerMasterDTO> findByName(String name) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from CustomerMasterDTO cus where cus.name=:c");
		query.setParameter("c", name);
		List<CustomerMasterDTO> cus=(List<CustomerMasterDTO>)query.list();
		HibernateUtility.closeSession(null);
		return cus;
	}

	@Override
	public List<CustomerMasterDTO> findAll() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from CustomerMasterDTO");
		List<CustomerMasterDTO> cus=(List<CustomerMasterDTO>)query.list();
		HibernateUtility.closeSession(null);
		return cus;
	}
//	public static void main(String[] args) {
//		CustomerMasterDTO cust1=new CustomerMasterDTO();
//		cust1.setAddress("abc street");
//		cust1.setEmail("abc@gmail.com");
//		cust1.setName("Bharani");
//		cust1.setPhone("986543210");
//		CustomerMasterDTO cust2=new CustomerMasterDTO();
//		cust2.setAddress("bcd street");
//		cust2.setEmail("bcd@gmail.com");
//		cust2.setName("Vikram");
//		cust2.setPhone("986543210");
//		CustomerMasterDAOImpl cu=new CustomerMasterDAOImpl();
//		cu.insert(cust1);
//		cu.insert(cust2);
//		System.out.println(cu.findByName("Bharani"));
//	}
}
