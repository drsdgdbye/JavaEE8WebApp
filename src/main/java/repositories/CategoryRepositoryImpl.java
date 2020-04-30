package repositories;

import entities.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoryRepositoryImpl implements CategoryRepository {
    private Session session;

    @Override
    public void insert(Category category) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(category);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Category category) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(category);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Category.class, id));
        tx.commit();
        session.close();
    }

    @Override
    public Category findById(Long id) {
        Category category;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        category = session.get(Category.class, id);
        tx.commit();
        session.close();
        return category;
    }

    @Override
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
