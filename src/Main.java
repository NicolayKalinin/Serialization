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
    public static void main(String[] args) {

        Basket basket = new Basket(products, prices);

        while (true) {
            showPrice();
            System.out.print("Выберете товар и количество через пробел или введите end: ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            basket.addToCard(productNumber, productCount);
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