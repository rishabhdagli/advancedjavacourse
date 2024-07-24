package Unit4;

import java.util.ArrayList;

public class Order implements Calculate {
    private int orderNumber;
    private ArrayList<OrderItem> orderItems;

    public Order(int orderNumber, ArrayList<OrderItem> orderItems) {
        this.orderNumber = orderNumber;
        this.orderItems = orderItems;
    }

    public Order(){
        orderNumber = 0;
        orderItems = null;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String summarize(){
        String summary = "Order #" + orderNumber + "\n";

        for(int i = 0; i<orderItems.size(); i++){
            summary += orderItems.get(i).getQuantity() + "\n";
            summary += orderItems.get(i).getLegalCase().getName() + "\n";
            summary += orderItems.get(i).getLegalCase().getSalePrice() + "\n";
            summary += "Cost is: " + (orderItems.get(i).getQuantity() * orderItems.get(i).getLegalCase().getSalePrice()) + "\n";
            summary += "Goods Cost is: " + (orderItems.get(i).getQuantity() * orderItems.get(i).getLegalCase().getCostPrice()) + "\n";
        }
        return summary;
    }
}
