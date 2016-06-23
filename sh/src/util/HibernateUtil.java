package util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public final class HibernateUtil {

	public static void update(Object entity) {
		Transaction tx = null;
		Session session = null;
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void delete(Object entity) {
		Transaction tx = null;
		Session session = null;
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void save(Object entity) {
		Transaction tx = null;
		Session session = null;
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static Object get(Class clazz, Serializable id) {
		Session session = null;
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			Object object = session.get(clazz, id);
			return object;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
