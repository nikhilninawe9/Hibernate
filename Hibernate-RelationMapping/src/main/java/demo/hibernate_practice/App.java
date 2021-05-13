package demo.hibernate_practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import demo.hibernate_practice.model.manytomany.Boyfriend;
import demo.hibernate_practice.model.manytomany.Girlfriend;
import demo.hibernate_practice.model.onetomany.Cars;
import demo.hibernate_practice.model.onetomany.Owner;
import demo.hibernate_practice.model.onetoone.Laptops;
import demo.hibernate_practice.model.onetoone.Students;

public class App {
	static Session session;
	static SessionFactory sessionFactory;
	static Transaction transaction;

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistryObj);
		return sessionFactory;
	}

	public static void main(String[] args) {
		saveOneToOne();
		saveOneToMany();
		saveManyToMany();
	}

	public static void saveOneToOne() {
		try {
			Laptops laptops = new Laptops();
			laptops.setLaptopId(5);
			laptops.setLaptopName("Dell XPS");

			Students student = new Students();
			student.setStudentRollNumber(7);
			student.setStudentName("Nikhil Ninawe");
			student.setMarks(98);
			student.setLaptops(laptops);

			session = buildSessionFactory().openSession();
			session.beginTransaction();
			session.save(laptops);
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Successful Build");
		} catch (Exception sqlException) {
			if (session.getTransaction() != null) {
				System.out.println("roll back");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	public static void saveOneToMany() {
		try {
			Cars car1 = new Cars();
			car1.setCarNumber(001);
			car1.setCarName("Mercedes Benz S-600");
			car1.setCarMake("German (Mercedes)");
			Cars car2 = new Cars();
			car2.setCarNumber(002);
			car2.setCarName("BMW M-3");
			car2.setCarMake("German (BMW)");

			Owner owner = new Owner();
			owner.setOwnerId(1);
			owner.setOwnerName("Nikhil Ninawe");
			owner.setOwnerAddress("London");
			car1.setOwner(owner);
			car2.setOwner(owner);
			owner.getCars().add(car1);
			owner.getCars().add(car2);

			session = buildSessionFactory().openSession();
			session.beginTransaction();
			session.save(owner);
			session.save(car1);
			session.save(car2);
			session.getTransaction().commit();
			System.out.println("Successful Build");
		} catch (Exception sqlException) {
			if (session.getTransaction() != null) {
				System.out.println("roll back");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	public static void saveManyToMany() {
		try {
			Boyfriend boyfriend1 = new Boyfriend();
			boyfriend1.setBoyfriendBusiness("Investment Banker");
			boyfriend1.setBoyfriendId(1);
			boyfriend1.setBoyfriendName("Ansh");
			boyfriend1.setBoyfriendType("Humerous");
			Boyfriend boyfriend2 = new Boyfriend();
			boyfriend2.setBoyfriendBusiness("Engineering Consultant");
			boyfriend2.setBoyfriendId(2);
			boyfriend2.setBoyfriendName("Vikky");
			boyfriend2.setBoyfriendType("Hard Drinker");
			Boyfriend boyfriend3 = new Boyfriend();
			boyfriend3.setBoyfriendBusiness("Broaker");
			boyfriend3.setBoyfriendId(3);
			boyfriend3.setBoyfriendName("Samuel");
			boyfriend3.setBoyfriendType("Honest");

			Girlfriend girlfriend1 = new Girlfriend();
			girlfriend1.setGirlfriendId(1);
			girlfriend1.setGirlfriendName("Kareena");
			girlfriend1.setGirlfriendType("Pretty");
			Girlfriend girlfriend2 = new Girlfriend();
			girlfriend2.setGirlfriendId(2);
			girlfriend2.setGirlfriendName("Aisha");
			girlfriend2.setGirlfriendType("Sexy");
			Girlfriend girlfriend3 = new Girlfriend();
			girlfriend3.setGirlfriendId(3);
			girlfriend3.setGirlfriendName("Palak");
			girlfriend3.setGirlfriendType("Not Trustworthy");
			Girlfriend girlfriend4 = new Girlfriend();
			girlfriend4.setGirlfriendId(4);
			girlfriend4.setGirlfriendName("Esha");
			girlfriend4.setGirlfriendType("Beautiful");

			boyfriend1.getGirlfriend().add(girlfriend1);
			boyfriend1.getGirlfriend().add(girlfriend3);
			boyfriend2.getGirlfriend().add(girlfriend4);
			boyfriend2.getGirlfriend().add(girlfriend3);
			boyfriend2.getGirlfriend().add(girlfriend1);
			boyfriend2.getGirlfriend().add(girlfriend2);
			boyfriend3.getGirlfriend().add(girlfriend3);

			girlfriend1.getBoyfriend().add(boyfriend3);
			girlfriend2.getBoyfriend().add(boyfriend1);
			girlfriend2.getBoyfriend().add(boyfriend2);
			girlfriend2.getBoyfriend().add(boyfriend3);
			girlfriend3.getBoyfriend().add(boyfriend1);
			girlfriend4.getBoyfriend().add(boyfriend2);
			girlfriend4.getBoyfriend().add(boyfriend1);

			session = buildSessionFactory().openSession();
			session.beginTransaction();

			session.save(girlfriend4);
			session.save(girlfriend1);
			session.save(girlfriend2);
			session.save(girlfriend3);

			session.save(boyfriend3);
			session.save(boyfriend2);
			session.save(boyfriend1);

			session.getTransaction().commit();
			System.out.println("Successful Build");
		} catch (Exception sqlException) {
			if (session.getTransaction() != null) {
				System.out.println("roll back");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}
}
