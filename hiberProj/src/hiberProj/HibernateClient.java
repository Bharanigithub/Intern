package hiberProj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateClient {
	public static void main(String[] args)  {
		try {
			BookDTO bookDto=new BookDTO(1,"Java","James",350);
			Comment comment=new Comment();
			comment.setMsg("Hibernate Project Demo!!!");
			bookDto.setComment(comment);
			Configuration cfg=new Configuration();
			SessionFactory sf=cfg.configure().buildSessionFactory();
			Session session=sf.openSession();
			session.save(bookDto);
			session.beginTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
