package Unit8;

import java.util.ArrayList;

public class Accounting implements Calculate {
    private ArrayList<Order> orders;

    public Accounting(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public double findPL(){
        double PL = 0;
        for(int i = 0; i < orders.size(); i++){
            for(int j = 0; j < orders.get(i).getOrderItems().size(); j++){
                PL += orders.get(i).getOrderItems().get(j).getLegalCase().getSalePrice() - orders.get(i).getOrderItems().get(j).getLegalCase().getCostPrice();
            }
        }
        return PL;
    }

    @Override
    public String summarize(){
        double PL = findPL();
        if(PL == 0){
            return "You broke even";
        } else if (PL > 0) {
            return "Your profitable";
        } else{
            return "You lost";
        }
    }
}
