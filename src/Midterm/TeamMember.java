package Midterm;

public class TeamMember<S, C> {
    private String name;
    private Projects project;
    private int hoursAllocated;
    private int hoursUtilized;

    public TeamMember(String name, Projects project, int hoursAllocated, int hoursUtilized) {
        this.name = name;
        this.project = project;
        this.hoursAllocated = hoursAllocated;
        this.hoursUtilized = hoursUtilized;
    }

    public String getName() {
        return name;
    }

    public Projects getProject() {
        return project;
    }

    public int getHoursAllocated() {
        return hoursAllocated;
    }

    public int getHoursUtilized() {
        return hoursUtilized;
    }

}
