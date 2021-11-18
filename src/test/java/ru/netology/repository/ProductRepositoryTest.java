package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private Book coreJava2 = new Book(1, "Core Java", 560, "Gary Cornell");
    private Book coreJavaVolume = new Book(2, "Core Java Volume", 630, "Horstmann");

    @Test
    public void shouldSaveOneBook() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneBookWithParameters() {
        repository.save(coreJava2);

        Product[] expected = new Product[]{coreJava2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoBooksWithParameters() {
        repository.save(coreJava2);
        repository.save(coreJavaVolume);

        Product[] expected = new Product[]{coreJava2, coreJavaVolume};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;


        repository.save(coreJava2);
        repository.save(coreJavaVolume);


        repository.removeById(idToRemove);

        Product[] expected = new Product[]{coreJava2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}
