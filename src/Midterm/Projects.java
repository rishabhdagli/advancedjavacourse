package Midterm;

abstract class Projects {
    protected String name;
    protected int totalHours;
    protected Client client;

    public Projects(String name, int totalHours, Client client) {
        this.name = name;
        this.totalHours = totalHours;
        this.client = client;
    }

    public Projects() {

    }

    public String getName() {
        return name;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public Client getClient() {
        return client;
    }

    public abstract String getProjectType();
}