package service.impl;

import java.util.List;

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
		List<Students> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;

		} finally {
			if (tx != null) {
				tx = null;
			}

		}
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
		Students students = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			students = (Students) session.get(Students.class, sid);
			tx.commit();
			return students;

		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return students;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
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
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			return true;
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

	/**
	 * 更新学生信息
	 * 
	 * @param student
	 *            学生信息
	 */
	@Override
	public boolean updateStudents(Students student) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(student);
			tx.commit();
			return true;
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

	/**
	 * 删除学生
	 * 
	 * @param sid
	 *            学号
	 */
	@Override
	public boolean deleteStudents(String sid) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students students = (Students) session.get(Students.class, sid);
			session.delete(students);
			tx.commit();
			return true;
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

	/**
	 * 获得学号
	 * 
	 * @return 学号
	 */
	private String getNewSid() {
		Transaction tx = null;
		String hql = "";
		String sid = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
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
			return sid;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
