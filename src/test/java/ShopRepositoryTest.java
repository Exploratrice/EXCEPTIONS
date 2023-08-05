import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(2, "кружка", 300);
        Product product2 = new Product(44, "кастрюля", 3_000);
        Product product3 = new Product(100, "чайник", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(2, "кружка", 300);
        Product product2 = new Product(44, "кастрюля", 3_000);
        Product product3 = new Product(100, "чайник", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(24)
        );
    }
}
