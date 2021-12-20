package lk.ijse.sipsewana.util;

import lk.ijse.sipsewana.entity.Course;
import lk.ijse.sipsewana.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().
                loadProperties("lk/ijse/sipsewana/hibernate.properties").build();

        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
