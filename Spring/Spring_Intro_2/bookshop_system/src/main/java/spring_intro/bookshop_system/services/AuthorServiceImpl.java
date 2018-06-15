package spring_intro.bookshop_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_intro.bookshop_system.models.entities.Author;
import spring_intro.bookshop_system.repositories.AuthorRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void saveAuthorToDB(Author author) {
        this.authorRepository.saveAndFlush(author);
    }

    @Override
    public void saveAuthorToDB(List<Author> authors) {
        this.authorRepository.saveAll(authors);
    }

    @Override
    public List<Author> getAll() {
        return this.authorRepository.findAll();
    }
}
