package repositories;

import entities.OrderItem;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

@Local
public interface OrderRepository extends Serializable {
    void insert(OrderItem orderItem);

    void update(OrderItem orderItem);

    void delete(Long id);

    OrderItem findById(Long id);

    List<OrderItem> findAll();
}
