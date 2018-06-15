package spring_intro.bookshop_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_intro.bookshop_system.models.entities.Author;
import spring_intro.bookshop_system.models.entities.Category;
import spring_intro.bookshop_system.repositories.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveIntoDB(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}
