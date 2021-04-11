package ProjectDTO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class ItemMasterDAOImpl implements ItemMasterDAO {

	@Override
	public int insert(ItemMasterDTO item) {
		Session session=HibernateUtility.getSession();
		session.save(item);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int update(ItemMasterDTO item) {
		Session session=HibernateUtility.getSession();
		session.save(item);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int delete(int itemno) {
		ItemMasterDTO itemMasterDTO=findById(itemno);
		Session session=HibernateUtility.getSession();
		System.out.println("Details:"+itemMasterDTO);
		session.delete(itemMasterDTO);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public ItemMasterDTO findById(int itemno) {
		Session session=HibernateUtility.getSession();
		ItemMasterDTO item=(ItemMasterDTO)session.get(ItemMasterDTO.class,itemno);
		HibernateUtility.closeSession(null);
		return item;
	}

	@Override
	public List<ItemMasterDTO> findAll() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from ItemMasterDTO");
		List<ItemMasterDTO> item=(List<ItemMasterDTO>)query.list();
		HibernateUtility.closeSession(null);
		return item;
	}

}
