package spring_intro.bookshop_system.services;


import spring_intro.bookshop_system.models.entities.Category;

import java.util.List;

public interface CategoryService {
    void saveIntoDB(List<Category> categories);

    List<Category> getAll();
}
