package junit;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import entity.Students;
import junit.framework.Assert;
import service.StudentsService;
import service.impl.StudentsServiceImpl;

public class TestStudents {

	@Test
	public void testSchemaExport() {
		
		// 创建配置对象
		Configuration configuration = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry();
		// 创建sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		// 创建session
		Session session = sessionFactory.getCurrentSession();
		// 创建SchemaExport
		SchemaExport export = new SchemaExport(configuration);
		export.create(true, true);

		// 5.1.0
		// ServiceRegistry serviceRegistry = new
		// StandardServiceRegistryBuilder().configure().build();
		// Metadata metadata = new
		// MetadataSources(serviceRegistry).buildMetadata();
		// SchemaExport schemaExport = new SchemaExport();
		// schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);

		// // 5.0.1
		// ServiceRegistry serviceRegistry = new
		// StandardServiceRegistryBuilder().configure().build();
		// MetadataImplementor metadataImplementor = (MetadataImplementor) new
		// MetadataSources(
		// serviceRegistry).buildMetadata();
		// SchemaExport export = new SchemaExport(serviceRegistry,
		// metadataImplementor);
		//
		// export.create(true, true);
	}

	@Test
	public void testSaveStudents() {
		// 创建配置对象
		Configuration configuration = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry();
		// 创建sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		// 创建session
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Students s1 = new Students("S000001", "张三丰", "男", new Date(), "上海");
		Students s2 = new Students("S000002", "张四丰", "男", new Date(), "北京");
		Students s3 = new Students("S000003", "貂蝉", "女", new Date(), "南京");

		session.save(s1);
		session.save(s2);
		session.save(s3);

		tx.commit();
	}

	@Test
	public void testQueryAllStudents() {
		StudentsService studentsService = new StudentsServiceImpl();
		List<Students> list = studentsService.queryAllStudents();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testAddStudents(){
		Students students = new Students();
		students.setSname("李子");
		students.setGender("男");
		students.setBirthday(new Date());
		students.setAddress("北京");
		StudentsService studentsService = new StudentsServiceImpl();
		Assert.assertEquals(true, studentsService.addStudents(students));
	}

}
