package repositories;

import entities.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class ProductRepository {
    private Session session;

    public void insert(Product product) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    public void update(Product product) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(product);
        tx.commit();
        session.close();
    }

    public void delete(Long id) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Product.class, id));
        tx.commit();
        session.close();
    }

    public Product findById(Long id) {
        Product product;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        product = session.get(Product.class, id);
        tx.commit();
        session.close();
        return product;
    }

    public List<Product> findAll() {
        List<Product> products;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        products = session.createQuery("from Product p", Product.class).getResultList();
        tx.commit();
        session.close();
        return products;
    }
}
