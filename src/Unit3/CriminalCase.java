package Unit3;

class CriminalCase extends Case {
    private String crime;
    private String defendantName;
    private double bailPrice;

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getDefendantName() {
        return defendantName;
    }

    public void setDefendantName(String defendantName) {
        this.defendantName = defendantName;
    }

    public double getBailPrice() {
        return bailPrice;
    }

    public void setBailPrice(double bailPrice) {
        this.bailPrice = bailPrice;
    }

    public CriminalCase() {
        super(false, 0);
        this.crime = "";
        this.defendantName = "";
        this.bailPrice = 0;
    }

    public CriminalCase(boolean settlement, int lawyersOnCase, String crime, String defendantName, double bailPrice) {
        super(settlement, lawyersOnCase);
        this.crime = crime;
        this.defendantName = defendantName;
        this.bailPrice = bailPrice;
    }

    @Override
    public String outputService() {
        return "Criminal Case{" +
                "crime='" + crime + '\'' +
                ", defendant name='" + defendantName + '\'' +
                ", bail price=" + bailPrice +
                '}';
    }
}
