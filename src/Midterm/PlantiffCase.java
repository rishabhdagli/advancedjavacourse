package Midterm;

class PlantiffCase extends Projects {
    public PlantiffCase(String name, int totalHours, Client client) {
        super(name, totalHours, client);
    }

    public PlantiffCase() {

    }

    @Override
    public String getProjectType() {
        return "Plantiff Case";
    }
}
