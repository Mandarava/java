package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory;

	private MyHibernateSessionFactory() {

	}

	public static SessionFactory getSessionFactory() {
		if (null == sessionFactory) {
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		}

		return sessionFactory;
	}
}
