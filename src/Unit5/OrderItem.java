package Unit5;

public class OrderItem {
    private int quantity;
    private LegalCase legalCase;

    public OrderItem(int quantity, LegalCase legalCase) {
        this.quantity = quantity;
        this.legalCase = legalCase;
    }

    public OrderItem(){
        quantity = 0;
        legalCase = null;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LegalCase getLegalCase() {
        return legalCase;
    }

    public void setLegalCase(LegalCase legalCase) {
        this.legalCase = legalCase;
    }
}
