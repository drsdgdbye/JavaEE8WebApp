package repositories;

import entities.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

//TODO make the overall structure. abstract factory maybe
@Named
@ApplicationScoped
public class CategoryRepository {
    private Session session;

    public void insert(Category category) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(category);
        tx.commit();
        session.close();
    }

    public void update(Category category) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(category);
        tx.commit();
        session.close();
    }

    public void delete(Long id) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Category.class, id));
        tx.commit();
        session.close();
    }

    public Category findById(Long id) {
        Category category;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        category = session.get(Category.class, id);
        tx.commit();
        session.close();
        return category;
    }

    public List<Category> findAll() {
        List<Category> categories;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        categories = session.createQuery("select p from Category p", Category.class).getResultList();
        tx.commit();
        session.close();
        return categories;
    }
}
