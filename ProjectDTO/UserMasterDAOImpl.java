package ProjectDTO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class UserMasterDAOImpl implements UserMasterDAO {

	@Override
	public int insert(UserDTO user) {
		Session session=HibernateUtility.getSession();
		session.save(user);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int update(UserDTO user) {
		Session session=HibernateUtility.getSession();
		session.save(user);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int delete(int userno) {
		UserDTO userDTO=findById(userno);
		Session session=HibernateUtility.getSession();
		System.out.println("Details:"+userDTO);
		session.delete(userDTO);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public UserDTO findById(int userno) {
		Session session=HibernateUtility.getSession();
		UserDTO user=(UserDTO)session.get(UserDTO.class,userno);
		HibernateUtility.closeSession(null);
		return user;
	}

	@Override
	public List<UserDTO> findAll() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from UserDTO");
		List<UserDTO> user=(List<UserDTO>)query.list();
		HibernateUtility.closeSession(null);
		return user;
	}

}
