package ProjectDTO;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO{

	@Override
	public int insert(InvoiceMasterDTO inv) {
		Session session=HibernateUtility.getSession();
		session.save(inv);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int update(InvoiceMasterDTO inv) {
		Session session=HibernateUtility.getSession();
		session.save(inv);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int delete(int invno) {
		InvoiceMasterDTO invoiceMasterDTO=findById(invno);
		Session session=HibernateUtility.getSession();
		System.out.println("Details:"+invoiceMasterDTO);
		session.delete(invoiceMasterDTO);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public InvoiceMasterDTO findById(int invno) {
		Session session=HibernateUtility.getSession();
		InvoiceMasterDTO inv=(InvoiceMasterDTO)session.get(InvoiceMasterDTO.class,invno);
		HibernateUtility.closeSession(null);
		return inv;
	}

	@Override
	public List<InvoiceMasterDTO> findAll() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from InvoiceMasterDTO");
		List<InvoiceMasterDTO> inv=(List<InvoiceMasterDTO>)query.list();
		HibernateUtility.closeSession(null);
		return inv;
	}
//	public static void main(String[] args) {
//		InvoiceMasterDTO inv=new InvoiceMasterDTO();
//		inv.setCustomerno(1);
//		inv.setInvDate(LocalDate.now());
//		InvoiceMasterDAOImpl invd=new InvoiceMasterDAOImpl();
//		invd.insert(inv);
//		System.out.println(invd.findById(1));
//		System.out.println(invd.findAll());
//	}
}
