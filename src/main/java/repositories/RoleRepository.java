package repositories;

import entities.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RoleRepository {
    private Session session;

    public void insert(Role role) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(role);
        tx.commit();
        session.close();
    }

    public void update(Role role) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(role);
        tx.commit();
        session.close();
    }

    public Role findById(Long id) {
        Role role;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        role = session.get(Role.class, id);
        tx.commit();
        session.close();
        return role;
    }

    public void delete(Long id) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Role.class, id));
        tx.commit();
        session.close();
    }

    public List<Role> findAll() {
        List<Role> roles;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        roles = session.createQuery("select p from Role p", Role.class).getResultList();
        tx.commit();
        session.close();
        return roles;
    }
}
