package Midterm;

class DefendantCase extends Projects {
    public DefendantCase(String name, int totalHours, Client client) {
        super(name, totalHours, client);
    }

    public DefendantCase() {
        super();
    }

    @Override
    public String getProjectType() {
        return "Defendant Case";
    }
}
