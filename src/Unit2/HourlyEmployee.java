package Unit2;

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursPerPeriod;

    public HourlyEmployee(String name, String jobTitle, String hireDate, double hourlyRate, double hoursPerPeriod) {
        super.fullName = name;
        super.jobTitle = jobTitle;
        super.hireDate = hireDate;
        this.hourlyRate = hourlyRate;
        this.hoursPerPeriod = hoursPerPeriod;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursPerPeriod() {
        return hoursPerPeriod;
    }

    public void setHoursPerPeriod(double hoursPerPeriod) {
        this.hoursPerPeriod = hoursPerPeriod;
    }

    public String paycheckGross(){
        return "$" + (hourlyRate * hoursPerPeriod);
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "hourlyRate=" + hourlyRate +
                ", hoursPerPeriod=" + hoursPerPeriod +
                ", fullName='" + fullName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", hireDate='" + hireDate + '\'' +
                '}';
    }
}
