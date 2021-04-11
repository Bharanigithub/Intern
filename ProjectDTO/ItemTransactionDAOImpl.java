package ProjectDTO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class ItemTransactionDAOImpl implements ItemTransactionDAO {

	@Override
	public int insert(ItemTransactionDTO itemTran) {
		Session session=HibernateUtility.getSession();
		session.save(itemTran);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int update(ItemTransactionDTO itemTran) {
		Session session=HibernateUtility.getSession();
		session.save(itemTran);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int delete(int itemno,int invno) {
		ItemTransactionDTO itemTransactionDTO=findById(itemno,invno);
		Session session=HibernateUtility.getSession();
		System.out.println("Details:"+itemTransactionDTO);
		session.delete(itemTransactionDTO);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public ItemTransactionDTO findById(int itemno,int invno) {
		Session session=HibernateUtility.getSession();
		CompKey compKey=new CompKey();
		compKey.setInvno(invno);
		compKey.setItemno(itemno);
		ItemTransactionDTO itemTran=(ItemTransactionDTO)session.get(ItemTransactionDTO.class,compKey);
		HibernateUtility.closeSession(null);
		return itemTran;
	}

	@Override
	public List<ItemTransactionDTO> findAll() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from ItemTransactionDTO");
		List<ItemTransactionDTO> itemTran=(List<ItemTransactionDTO>)query.list();
		HibernateUtility.closeSession(null);
		return itemTran;
	}

}
