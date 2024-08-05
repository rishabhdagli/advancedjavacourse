package Unit8;

import java.io.Serializable;
import java.util.ArrayList;

public class LegalCase implements Serializable {
    private String name;
    private double salePrice;
    private double costPrice;

    public LegalCase(String name, double salePrice, double costPrice) {
        this.name = name;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
    }

    public LegalCase() {
        name = "";
        salePrice = 0;
        costPrice = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

}
