import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarServiceTest {
    @Test
    public void testAverage() {
        StarService service = new StarService();
        int[] sales = {1,2,3,4,5,6,7,8,9};

        int actual = service.averageSale(sales);
        int expected = (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9) / sales.length;
        Assertions.assertEquals(expected, actual);
    }
}