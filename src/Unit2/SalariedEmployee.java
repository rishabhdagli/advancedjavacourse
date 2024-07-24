package Unit2;

public class SalariedEmployee extends Employee {
    private double salary;
    private double bonus;

    public SalariedEmployee(String name, String jobTitle, String hireDate, double salary, double bonus) {
        super.fullName = name;
        super.jobTitle = jobTitle;
        super.hireDate = hireDate;
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String paycheckGross(){
        double paycheck = salary/26;
        return "$" + paycheck;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "salary=" + salary +
                ", bonus=" + bonus +
                ", jobTitle='" + jobTitle + '\'' +
                ", fullName='" + fullName + '\'' +
                ", hireDate='" + hireDate + '\'' +
                '}';
    }
}

