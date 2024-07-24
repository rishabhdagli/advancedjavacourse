package Unit2;

public class ContractorEmployee extends Employee {
    private double hourlyRate;
    private double hoursPerPeriod;
    private String contractStart;
    private String contractEnd;
    private String company;

    public ContractorEmployee(String name, String jobTitle, String hireDate, double hourlyRate, String company, String contractStart, double hoursPerPeriod, String contractEnd) {
        super.fullName = name;
        super.jobTitle = jobTitle;
        super.hireDate = hireDate;
        this.hourlyRate = hourlyRate;
        this.company = company;
        this.contractStart = contractStart;
        this.hoursPerPeriod = hoursPerPeriod;
        this.contractEnd = contractEnd;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getContractStart() {
        return contractStart;
    }

    public void setContractStart(String contractStart) {
        this.contractStart = contractStart;
    }

    public double getHoursPerPeriod() {
        return hoursPerPeriod;
    }

    public void setHoursPerPeriod(double hoursPerPeriod) {
        this.hoursPerPeriod = hoursPerPeriod;
    }

    public String getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "ContractorEmployee{" +
                "hourlyRate=" + hourlyRate +
                ", hoursPerPeriod=" + hoursPerPeriod +
                ", contractStart='" + contractStart + '\'' +
                ", contractEnd='" + contractEnd + '\'' +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", fullName='" + fullName + '\'' +
                ", hireDate='" + hireDate + '\'' +
                '}';
    }

    public String paycheckGross(){
        double paycheck = hourlyRate*80;
        return "$" + paycheck;
    }
}
