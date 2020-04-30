package repositories;

import entities.OrderItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderRepositoryImpl implements OrderRepository {
    private Session session;

    @Override
    public void insert(OrderItem orderItem) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(orderItem);
        tx.commit();
        session.close();
    }

    @Override
    public void update(OrderItem orderItem) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public OrderItem findById(Long id) {
        return null;
    }

    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        orderItems = session.createQuery("select p from OrderItem p", OrderItem.class).getResultList();
        tx.commit();
        session.close();
        return orderItems;
    }
}
