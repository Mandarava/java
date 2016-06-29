package junit;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.IdCard;
import entity.Person;
import util.HibernateUtil2;

public class OneToOne {

	@Test
	public void add() {
		Transaction tx = null;
		Session session = null;
		try {
			IdCard idCard = new IdCard();
			idCard.setUsefulLife(new Date());

			Person p = new Person();
			p.setName("p1");

			// 
			p.setIdCard(idCard);
			idCard.setPerson(p);

			session = HibernateUtil2.INSTANCE.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(p);
			session.save(idCard);
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
	public void query() {
		Transaction tx = null;
		Session session = null;
		try {
			int id = 1;
			session = HibernateUtil2.INSTANCE.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			// 一对一主对象不会懒加载
			Person p = (Person) session.get(Person.class, id);
			// System.out.print(p.getIdCard());
			// 从对象会懒加载
			// 主表不能有constrained=true,所以主表没有懒加载。  lazy!=false,constrained=true,fetch=select
			// IdCard idCard = (IdCard) s.get(IdCard.class, id);
			// System.out.println(idCard.getPerson());
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
