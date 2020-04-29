package services;

import entities.Category;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

@Local
public interface CategoryService extends Serializable {
    Category getCategoryById(Long id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    List<Category> findAllCategories();

    void deleteCategory(Long id);
}
