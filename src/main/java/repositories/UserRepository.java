package repositories;

import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserRepository {
    private Session session;

    public void insert(User user) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    public void update(User user) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    public User findById(Long id) {
        User user;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        user = session.get(User.class, id);
        tx.commit();
        session.close();
        return user;
    }

    public void delete(Long id) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(User.class, id));
        tx.commit();
        session.close();
    }

    public List<User> findAll() {
        List<User> users;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        users = session.createQuery("select p from User p", User.class).getResultList();
        tx.commit();
        session.close();
        return users;
    }
}
