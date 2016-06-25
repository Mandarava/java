package junit;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Institute;
import entity.Teacher;
import util.HibernateUtil2;

public class ManyToOne {

	@Test
	public void add() {
		Transaction tx = null;
		Session session = null;
		try {
			Institute institute = new Institute();
			institute.setName("institute");

			Teacher teacher = new Teacher();
			teacher.setInstitute(institute);
			teacher.setName("zhangsan");

			session = HibernateUtil2.INSTANCE.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(institute);
			session.save(teacher);
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

	@Test
	public void queryTeacher() {
		int id = 1;
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil2.INSTANCE.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Teacher teacher = (Teacher) session.get(Teacher.class, id);
			System.out.println("institute name : " + teacher.getInstitute().getName());
//			Hibernate.initialize(teacher.getInstitute());
			tx.commit();
//			System.out.println("institute name : " + teacher.getInstitute().getName());
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
