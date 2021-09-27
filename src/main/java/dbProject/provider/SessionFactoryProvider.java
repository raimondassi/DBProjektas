package dbProject.provider;

import dbProject.domain.*;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;


public class SessionFactoryProvider {

    private static SessionFactoryProvider sessionFactoryProvider;

    private static SessionFactory sessionFactory;

    private SessionFactoryProvider() {
        try {
            Configuration configuration = new Configuration();
            Properties properties = createPropertiesPostgress();
            configuration.setProperties(properties);
            // add anotated class (pojo)
            configuration.addAnnotatedClass(Exam.class);
            configuration.addAnnotatedClass(ExamAnswer.class);
            configuration.addAnnotatedClass(Grade.class);
            configuration.addAnnotatedClass(Question.class);
            configuration.addAnnotatedClass(Student.class);
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(properties).build();
            sessionFactory = configuration.buildSessionFactory(registry);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static SessionFactoryProvider getSessionFactoryProvider() {
        if(sessionFactoryProvider == null) {
            sessionFactoryProvider = new SessionFactoryProvider();
        }
        return sessionFactoryProvider;
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void changeEntity(Consumer<Session> consumer) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactoryProvider().getSessionFactory().openSession();
            transaction = session.beginTransaction();
            consumer.accept(session);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public static <T> T getEntity(Function<Session, T> function) {
        try(Session session = SessionFactoryProvider.getSessionFactoryProvider().getSessionFactory().openSession();) {
            return function.apply(session);
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private static Properties createPropertiesH2() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        properties.put(Environment.DRIVER, "org.h2.Driver");
        properties.put(Environment.URL, "jdbc:h2://localhost/DBProjektas");
        properties.put(Environment.USER, "sa");
        // properties.put(Environment.PASS, "");  //password to pgAdmin admin
        properties.put(Environment.SHOW_SQL, "true");
        // properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        return properties;
    }

    private static Properties createPropertiesPostgress() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL94Dialect");
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost/DBProjektas");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgrespsw");  //password to pgAdmin admin
        properties.put(Environment.SHOW_SQL, "true");
        //properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        return properties;
    }
}



