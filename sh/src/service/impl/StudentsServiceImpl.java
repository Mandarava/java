package service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Students;
import service.StudentsService;
import util.MyHibernateSessionFactory;

public class StudentsServiceImpl implements StudentsService {

	/**
	 * 查询所有学生信息
	 */
	@Override
	public List<Students> queryAllStudents() {
		Transaction tx = null;
		Session session = null;
		List<Students> list = null;
		String hql = "";
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
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

		return list;
	}

	/**
	 * 根据学号查询学生信息
	 * 
	 * @param sid
	 *            学号
	 */
	@Override
	public Students queryStudentsBySid(String sid) {
		Transaction tx = null;
		Session session = null;
		Students students = null;
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			students = (Students) session.get(Students.class, sid);
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

		return students;
	}

	/**
	 * 添加学生
	 * 
	 * @param student
	 *            学生信息
	 */
	@Override
	public boolean addStudents(Students student) {
		student.setSid(getNewSid());
		Transaction tx = null;
		Session session = null;
		boolean flag = false;
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			flag = true;
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

	/**
	 * 更新学生信息
	 * 
	 * @param student
	 *            学生信息
	 */
	@Override
	public boolean updateStudents(Students student) {
		Transaction tx = null;
		Session session = null;
		boolean flag = false;
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(student);
			tx.commit();
			flag = true;
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

	/**
	 * 删除学生
	 * 
	 * @param sid
	 *            学号
	 */
	@Override
	public boolean deleteStudents(String sid) {
		Transaction tx = null;
		Session session = null;
		boolean flag = false;
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students students = (Students) session.get(Students.class, sid);
			session.delete(students);
			tx.commit();
			flag = true;
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

	/**
	 * 获得学号
	 * 
	 * @return 学号
	 */
	private String getNewSid() {
		Transaction tx = null;
		Session session = null;
		String sid = null;
		String hql = "";
		try {
			session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if (null == sid && "".equals(sid)) {
				sid = "S000001";
			} else {
				int i = Integer.parseInt(sid.substring(1));
				i++;
				sid = String.format("%06d", i);
				sid = "S" + sid;
			}
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
		return sid;
	}

}
