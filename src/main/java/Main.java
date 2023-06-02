import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int[] prices = new int[] {
            50,
            100,
            35
    };
    static String[] products = new String[] {
            "Хлеб",
            "Яблоко",
            "Молоко"
    };

    static File saveFile = new File("basket.json");
    public static void main(String[] args) throws FileNotFoundException {

        Basket basket = null;

        if (saveFile.exists()) {
            basket = Basket.loadFromJSONFile(saveFile);
        } else {
            basket = new Basket(products, prices);
        }

        ClientLog log = new ClientLog();
        while (true) {
            showPrice();
            System.out.print("Выберете товар и количество через пробел или введите end: ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                log.exportAsCSV(new File("log.csv"));
                break;
            }
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            basket.addToCard(productNumber, productCount);
            log.log(productNumber, productCount);
            basket.saveJSON(saveFile);
        }
        basket.printCart();
    }
        public static void showPrice() {
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i] + " " + prices[i] + " руб/шт");
        }
    }
}