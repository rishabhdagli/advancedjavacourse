package Unit3;

public class CorportateCase extends Case{
    private String representingCompany;
    private String opposingCompany;
    private double totalCost;
    private double totalCharge;


    public String getRepresentingCompany() {
        return representingCompany;
    }

    public void setRepresentingCompany(String representingCompany) {
        this.representingCompany = representingCompany;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getOpposingCompany() {
        return opposingCompany;
    }

    public void setOpposingCompany(String opposingCompany) {
        this.opposingCompany = opposingCompany;
    }


    public CorportateCase(Boolean settling, int lawyers, String representingCompany, String opposingCompany, double totalCost, double totalCharge) {
        super(settling, lawyers);
        this.representingCompany = representingCompany;
        this.opposingCompany = opposingCompany;
        this.totalCost = totalCost;
        this.totalCharge = totalCharge;
    }

    public CorportateCase() {
        super(false, 0);
        this.representingCompany = "";
        this.opposingCompany = "";
        this.totalCost = 0;
        this.totalCharge = 0;
    }


    @Override
    public String outputService() {
       return "CorportateCase{" +
                "representingCompany='" + representingCompany + '\'' +
                ", opposingCompany='" + opposingCompany + '\'' +
                ", totalCost=" + totalCost +
                ", totalCharge=" + totalCharge +
                ", settlement=" + settlement +
                ", lawyersOnCase=" + lawyersOnCase +
                ", totalProfit=" + (totalCharge-totalCost) +
                '}';
    }
}
