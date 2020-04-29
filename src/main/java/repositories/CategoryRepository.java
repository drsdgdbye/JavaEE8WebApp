package repositories;

import entities.Category;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

@Local
public interface CategoryRepository extends Serializable {
    void insert(Category category);

    void update(Category category);

    void delete(Long id);

    Category findById(Long id);

    List<Category> findAll();

}
