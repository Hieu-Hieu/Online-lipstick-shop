package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Bill;
import model.BillDetail;
import model.Brand;
import model.Cart;
import model.Category;
import model.Product;
import model.User;

/**
 * Java based configuration
 * 
 * @author ramesh Fadatare
 *
 */
public class Utill {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL,
						"jdbc:mysql://localhost:3306/lipstickshop?allowPublicKeyRetrieval=true&useSSL=false");

				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "123456");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

//				settings.put(Environment.C3P0_MIN_SIZE, "5");
//				settings.put(Environment.C3P0_MAX_SIZE, "20");
//				settings.put(Environment.C3P0_TIMEOUT, "300");
//				settings.put(Environment.C3P0_MAX_STATEMENTS, "50");
//				settings.put(Environment.C3P0_IDLE_TEST_PERIOD, "3000");
				settings.put(Environment.POOL_SIZE, "100");
//				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Bill.class);
				configuration.addAnnotatedClass(BillDetail.class);
				configuration.addAnnotatedClass(Brand.class);
				configuration.addAnnotatedClass(Category.class);
				configuration.addAnnotatedClass(Product.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Cart.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}