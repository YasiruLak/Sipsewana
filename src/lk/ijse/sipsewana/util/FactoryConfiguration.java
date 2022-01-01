package lk.ijse.sipsewana.util;

import lk.ijse.sipsewana.entity.Course;
import lk.ijse.sipsewana.entity.Registration;
import lk.ijse.sipsewana.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/27/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();

        Metadata meta = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Registration.class)
                .getMetadataBuilder().build();

        sessionFactory = meta.getSessionFactoryBuilder().build();

    }
    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ?
                factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
