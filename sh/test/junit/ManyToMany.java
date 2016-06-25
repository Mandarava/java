package junit;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Students;
import entity.Teacher;
import util.HibernateUtil2;

public class ManyToMany {

	@Test
	public void add() {
		Transaction tx = null;
		Session session = null;
		try {
			Set<Teacher> teachers = new HashSet<>();

			Teacher teacher1 = new Teacher();
			teacher1.setName("teacher1");
			teachers.add(teacher1);

			Teacher teacher2 = new Teacher();
			teacher2.setName("teacher2");
			teachers.add(teacher2);

			Set<Students> students = new HashSet<>();

			Students students1 = new Students();
			students1.setSname("student1");
			students1.setSid("001");
			students.add(students1);

			Students students2 = new Students();
			students2.setSname("student2");
			students2.setSid("002");
			students.add(students2);

			teacher1.setStudents(students);
			teacher2.setStudents(students);

			// 维护一个即可
			// students1.setTeachers(teachers);
			// students2.setTeachers(teachers);

			session = HibernateUtil2.INSTANCE.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(teacher1);
			session.save(teacher2);
			session.save(students1);
			session.save(students2);
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
		int id = 1;
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil2.INSTANCE.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Teacher teacher = (Teacher) session.get(Teacher.class, id);
			System.out.println("students : " + teacher.getStudents().size());
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
