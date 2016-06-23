package service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Users;
import service.UsersService;
import util.MyHibernateSessionFactory;

public class UsersServiceImpl implements UsersService {

	/**
	 * 用户登录
	 */
	@Override
	public boolean usersLogin(Users user) {
		Transaction tx = null;
		Session session = null;
		boolean flag = false;
		String hql = "";
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			// session = HibernateUtil2.INSTANCE.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			// hql = "from Users where username= ? and password= ? ";
			hql = "from Users where username= :name and password= :password ";
			Query query = session.createQuery(hql);
			query.setParameter("name", user.getUsername());
			query.setParameter("password", user.getPassword());
			// query.setParameter(0, user.getUsername());
			// query.setParameter(1, user.getPassword());
			
			// 分页
			query.setFirstResult(0);
			query.setMaxResults(10);
			
			List<Users> list = query.list();
			tx.commit();
			if (null != list && list.size() > 0) {
				flag = true;
			}
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

		return flag;
	}
}
