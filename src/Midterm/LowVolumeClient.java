package Midterm;

public class LowVolumeClient extends Client{
    private double priceTag;

    public LowVolumeClient() {
        this.priceTag = 0;
        super.name = "";
    }

    public LowVolumeClient(String name, double priceTag) {
        super.name = name;
        this.priceTag = priceTag;
    }

    public double getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(double priceTag) {
        this.priceTag = priceTag;
    }

    public String getName(){
        return super.name;
    }

    public void setName(String name){
        super.name = name;
    }

    @Override
    public String getClientType() {
        return "Low Volume";
    }
}
