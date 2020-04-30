package repositories;

import entities.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ProductRepositoryImpl implements ProductRepository {
    private Session session;

    @Override
    public void insert(Product product) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Product product) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(product);
        tx.commit();
        session.close();
    }

    @Override
    public List<Product> findByCategory(Long id) {
        List<Product> products;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select p from Product p where p.category.id = :id", Product.class);
        query.setParameter("id", id);
        products = query.getResultList();
        tx.commit();
        session.close();
        return products;
    }

    @Override
    public Product findByTitle(String title) {
        Product product;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        product = session.get(Product.class, title);
        tx.commit();
        session.close();
        return product;
    }

    @Override
    public void delete(Long id) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Product.class, id));
        tx.commit();
        session.close();
    }

    @Override
    public Product findById(Long id) {
        Product product;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        product = session.get(Product.class, id);
        tx.commit();
        session.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        products = session.createQuery("select p from Product p", Product.class).getResultList();
        tx.commit();
        session.close();
        return products;
    }
}
