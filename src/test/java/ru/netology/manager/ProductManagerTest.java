package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();


    //private Book coreJava = new Book();
    private Book coreJava2 = new Book(1, "Cora Java2", 566, "Гари Корнелл");
    private Book java3 = new Book(3, "Java3", 750, "Jason");
    private Book java5 = new Book(4, "Java5", 750, "Jason");
    private Book many = new Book(5, "Many", 350, "Ivanov");

    private Smartphone samsung = new Smartphone(7, "Galaxy S21", 55150, "Samsung");
    private Smartphone apple = new Smartphone(2, "11", 150000, "Apple");
    private Smartphone samsung22 = new Smartphone(8, "Galaxy S22", 55150, "Samsung");
    private Product product = new Product(9, "Honor", 54500);

    @Test
    public void shouldSaveOneBook() {


        manager.add(coreJava2);

        Product[] expected = new Product[]{coreJava2};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBy() {
        String textForSearch = "Java";


        manager.add(java3);
        manager.add(many);

        //manager.searchBy(textForSearch);

        Product[] expected = new Product[]{java3,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchByAuthor() {
        String textForSearch = "Jason";


        manager.add(java3);
        manager.add(many);

        manager.searchBy(textForSearch);

        Product[] expected = new Product[]{java3,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchByName() {
        String textForSearch = "11";


        manager.add(samsung);
        manager.add(many);
        manager.add(apple);

        manager.searchBy(textForSearch);

        Product[] expected = new Product[]{apple,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchByManufacturer() {
        String textForSearch = "Samsung";


        manager.add(samsung);
        manager.add(many);
        manager.add(apple);


        manager.searchBy(textForSearch);

        Product[] expected = new Product[]{samsung};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchByAuthorInBooksAndSmartphones() {
        String textForSearch = "Jason";


        manager.add(java3);
        manager.add(many);
        manager.add(samsung22);

        manager.searchBy(textForSearch);

        Product[] expected = new Product[]{java3,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchByManufacturerWhichIsNot() {
        String textForSearch = "Honor";


        manager.add(samsung);
        manager.add(many);
        manager.add(product);

        manager.searchBy(textForSearch);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);


    }
}
