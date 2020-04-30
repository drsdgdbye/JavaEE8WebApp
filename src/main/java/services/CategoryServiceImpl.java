package services;

import entities.Category;
import repositories.CategoryRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoryServiceImpl implements CategoryService, CategoryServiceWs {
    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.insert(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.update(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public void saveCategoryWs(Category category) {
        saveCategory(category);
    }
}
