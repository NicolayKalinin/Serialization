import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class BasketTest {
    @Test
    public void testAddToBasket() {
        int[] prices = new int[] {
                50,
                100,
                35
        };
        String[] products = new String[] {
                "Хлеб",
                "Яблоко",
                "Молоко"
        };
        Basket basket = new Basket(products, prices);

        basket.addToCard(0, 10);
        basket.addToCard(1, 5);
        int[] actual = basket.getQuantities();
        int[] expected = {10, 5, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLoadFromTxtFile() {
        Basket basket = Basket.loadFromTxtFile(new File("src/test/resources/test_basket.txt"));

        String[] actualGoods = basket.getGoods();
        String[] expectedGoods = {"Хлеб", "Яблоко", "Молоко"};

        Assertions.assertArrayEquals(expectedGoods, actualGoods);
    }

}