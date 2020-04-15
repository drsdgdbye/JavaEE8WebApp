package repositories;

import entities.OrderItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class OrderRepository {
    private Session session;

    public void insert(OrderItem orderItem) {
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(orderItem);
        tx.commit();
        session.close();
    }

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
