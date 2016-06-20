package service.impl;

import java.util.List;

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
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username= ? and password= ? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List list = query.list();
			tx.commit();
			if (null != list && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}
}
