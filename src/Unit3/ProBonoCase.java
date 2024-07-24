package Unit3;

class ProBonoCase extends Case {
    private String defendantName;
    private String plantiffName;
    private Boolean defending;

    public String getDefendantName() {
        return defendantName;
    }

    public void setDefendantName(String defendantName) {
        this.defendantName = defendantName;
    }

    public Boolean getDefending() {
        return defending;
    }

    public void setDefending(Boolean defending) {
        this.defending = defending;
    }

    public String getPlantiffName() {
        return plantiffName;
    }

    public void setPlantiffName(String plantiffName) {
        this.plantiffName = plantiffName;
    }

    public ProBonoCase(Boolean settling, int lawyers, String defendantName, String plantiffName, Boolean defending) {
        super(settling, lawyers);
        this.defendantName = defendantName;
        this.plantiffName = plantiffName;
        this.defending = defending;
    }

    public ProBonoCase() {
        super(false, 0);
        this.defendantName = "";
        this.plantiffName = "";
        this.defending = false;
    }

    @Override
    public String outputService() {
        return "ProBonoCase{" +
                "defendantName='" + defendantName + '\'' +
                ", plaintiffName='" + plantiffName + '\'' +
                ", defending=" + defending +
                ", settlement=" + settlement +
                ", lawyersOnCase=" + lawyersOnCase +
                '}';
    }
}
