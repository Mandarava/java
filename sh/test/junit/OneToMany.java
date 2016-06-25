package junit;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Institute;
import util.HibernateUtil2;

public class OneToMany {
	
	@Test
	public void query(){
		int id = 1;
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil2.INSTANCE.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Institute institute = (Institute) session.get(Institute.class, id);
			System.out.println(institute.getTeachers().size());
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw e;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
