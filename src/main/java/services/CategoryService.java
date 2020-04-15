package services;

import entities.Category;
import repositories.CategoryRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CategoryService implements Serializable {
    private static final long serialVersionUID = 6015702456158151251L;
    @Inject
    private CategoryRepository categoryRepository;

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void saveCategory(Category category) {
        categoryRepository.insert(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.update(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }
}
