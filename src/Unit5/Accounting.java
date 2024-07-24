package Unit5;

import java.util.ArrayList;

public class Accounting implements Calculate {
    private ArrayList<Order> orders;

    public Accounting(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList findPL() {
        double PL = 0;
        double margin = 0;
        ArrayList<Double> marginList = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            for (int j = 0; j < orders.get(i).getOrderItems().size(); j++) {
                double salesPrice = orders.get(i).getOrderItems().get(j).getLegalCase().getSalePrice();
                double costPrice = orders.get(i).getOrderItems().get(j).getLegalCase().getCostPrice();
                PL += salesPrice - costPrice;

                try {
                    if (costPrice == 0) {
                        throw new ArithmeticException("Cost price is zero, cannot calculate margin.");
                    }
                    margin += (salesPrice - costPrice) / costPrice;
                } catch (ArithmeticException e) {
                    System.err.println("Division by zero! " + e.getMessage());
                    System.exit(0);
                }
            }
        }
        marginList.add(PL);
        marginList.add(margin);
        return marginList;
    }

    @Override
    public String summarize() {
        ArrayList<Double> list = findPL();
        double margin = list.get(1);
        double PL = list.get(0);

        if (PL == 0) {
            return "You broke even! Your margin was: " + margin;
        } else if (PL > 0) {
            return "You're profitable! Your margin was: " + margin;
        } else {
            return "You lost. Your margin was: " + margin;
        }
    }
}
