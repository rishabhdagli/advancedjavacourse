package Unit2;

public class Employee {
    public String jobTitle;
    public String fullName;
    public String hireDate;

    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String paycheckGross(){
        return "Unable to calculate paycheck for base employee";
    }

    public String toString(){
        return "Job Title: " + jobTitle +
                "Name: " + fullName +
                "Hire Date:" + hireDate;
    }
}
