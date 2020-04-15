package utils;

import entities.Category;
import entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
    private static volatile HibernateUtil instance;
    private final String DB_DRIVER_NAME = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://localhost:5432/cinemaDB?currentSchema=ee_shop";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "12345";
    private final String DB_DIALECT = "org.hibernate.dialect.PostgreSQL10Dialect";
    private final String DB_SHOW_SQL = "true";
    private final String DB_CURRENT_SESSION_CONTEXT_CLASS = "thread";
    private final String DB_HBM2DDL_AUTO = "create-drop";
    private SessionFactory sessionFactory;
    private Configuration cfg;

    public static HibernateUtil getInstance() {
        if (instance == null) {
            synchronized (HibernateUtil.class) {
                if (instance == null) {
                    instance = new HibernateUtil();
                }
            }
        }
        return instance;
    }

    public SessionFactory getSf() {
        if (sessionFactory == null) {
            cfg = new Configuration();
            cfg.setProperty(Environment.DRIVER, DB_DRIVER_NAME);
            cfg.setProperty(Environment.URL, DB_URL);
            cfg.setProperty(Environment.USER, DB_USERNAME);
            cfg.setProperty(Environment.PASS, DB_PASSWORD);
            cfg.setProperty(Environment.DIALECT, DB_DIALECT);
            cfg.setProperty(Environment.SHOW_SQL, DB_SHOW_SQL);
            cfg.addAnnotatedClass(Product.class);
            cfg.addAnnotatedClass(Category.class);
            sessionFactory = cfg.buildSessionFactory();
        }
        return sessionFactory;
    }
}
