package inherPack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class FactoryClient {
	public static void main(String[] args) {
		ShoeFactory shoeFactory=new ShoeFactory();
		BataShoeFactory bata=new BataShoeFactory();
		LakhaniShoeFactory lakhani=new LakhaniShoeFactory();
		Session session=HibernateUtility.getSession();
		shoeFactory.setName("Factory..");
		bata.setName("Factory From Bata");
		bata.setBataname("Bata Bata Bata");
		lakhani.setName("Factory from Lakhani");
		lakhani.setLakhaniname("Lakhani Lakhani Lakhani");
		session.save(shoeFactory);
		session.save(bata);
		session.save(lakhani);
		session.beginTransaction().commit();
	}
}
