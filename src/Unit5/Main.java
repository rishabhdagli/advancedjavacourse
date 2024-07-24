
package Unit5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configure products
        System.out.println("Configure Corporate Case:");
        System.out.print("Selling price: ");
        double corpCaseSP = scanner.nextDouble();
        System.out.print("cost to company: ");
        double corpCaseCC = scanner.nextDouble();
        LegalCase corpCase = new LegalCase("Corp Case", corpCaseSP, corpCaseCC);

        System.out.println("Configure Criminal Case:");
        System.out.print("selling price: ");
        double crimCaseSP = scanner.nextDouble();
        System.out.print("cost to company: ");
        double crimeCaseCC = scanner.nextDouble();
        LegalCase crimCase = new LegalCase("Crim Case", crimCaseSP, crimeCaseCC);

        System.out.println("Configure Pro Bono Case:");
        System.out.print("selling price: ");
        double pbCaseSP = scanner.nextDouble();
        System.out.print("cost to company: ");
        double pbCaseCC = scanner.nextDouble();
        LegalCase proBonoCase = new LegalCase("Pro Bono Case", pbCaseSP, pbCaseCC);

        // Collect orders
        System.out.print("How many orders will you be entering? ");
        int numOrders = scanner.nextInt();
        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 1; i <= numOrders; i++) {
            System.out.println("Order " + i + " – which product? (1) for Corporate case, (2) for Criminal, (3) for Pro Bono Case");
            int productChoice = scanner.nextInt();
            System.out.println("Order " + i + " – quantity?");
            int quantity = scanner.nextInt();

            LegalCase chosenProduct;

            switch (productChoice) {
                case 1:
                    chosenProduct = corpCase;
                    break;
                case 2:
                    chosenProduct = crimCase;
                    break;
                case 3:
                    chosenProduct = proBonoCase;
                    break;
                default:
                    System.out.println("Wrong choice. Sorry!");
                    chosenProduct = null;
                    break;
            }
            OrderItem orderItem = new OrderItem(quantity, chosenProduct);
            ArrayList<OrderItem> orderItems = new ArrayList<>();
            orderItems.add(orderItem);

            orders.add(new Order(i, orderItems));
        }

        // Perform calculations
        Accounting accounting = new Accounting(orders);

        // Output results
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).summarize());
        }

        System.out.println(accounting.summarize());

        scanner.close();
    }
}