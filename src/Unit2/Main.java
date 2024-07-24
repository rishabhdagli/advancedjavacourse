package Unit2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Employee Management System!");
        menu();
    }

    public static void menu(){
        int choice;
        System.out.println("Would you like to view or add employees? Press 1 to add, and 2 to view. Anything else to quit.");
        choice = input.nextInt();

        switch(choice) {
            case 1:
                System.out.println("How many employees would you like to add?");
                int amt = input.nextInt();
                for(int i = 0; i < amt; i++) {
                    addEmployee();
                }
                menu();
                break;

            case 2:
                viewAllEmployees();
                break;

            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }
    }

    public static void addEmployee(){
        System.out.print("Enter the type of employee: (1) for Hourly paid, (2) for salaried, (3) for contractor: ");
        int type = input.nextInt();

        switch(type) {
            case 1:
                addHourlyEmployee();
                break;
            case 2:
                addSalariedEmployee();
                break;
            case 3:
                addContractedEmployee();
                break;
            default:
                System.out.println("Invalid type");
                break;
        }
    }

    public static void addHourlyEmployee(){
        String lName;
        String fName;
        String jobTitle;
        String hireDate;

        //hourly
        double rate;
        double hoursPerPeriod;

        System.out.print("Enter the first name of the employee: ");
        fName = input.next();
        System.out.print("Enter the last name of the employee: ");
        lName = input.next();
        System.out.print("Enter the job title: ");
        jobTitle = input.next();
        System.out.print("Enter the hire date: ");
        hireDate = input.next();
        System.out.print("Enter the hourly rate: ");
        rate = input.nextDouble();
        System.out.print("Enter the hours per period: ");
        hoursPerPeriod = input.nextDouble();

        HourlyEmployee newHourlyEmployee = new HourlyEmployee((fName + " " + lName), jobTitle, hireDate, rate, hoursPerPeriod);

        employeeList.add(newHourlyEmployee);
        System.out.println("Hourly employee added");
    }

    public static void addSalariedEmployee(){
        String fName;
        String lName;
        String jobTitle;
        String hireDate;

        //hourly
        double rate;
        double bonus;

        System.out.print("Enter the first name of the employee: ");
        fName = input.next();
        System.out.print("Enter the last name of the employee: ");
        lName = input.next();
        System.out.print("Enter the job title: ");
        jobTitle = input.next();
        System.out.print("Enter the hire date: ");
        hireDate = input.next();
        System.out.print("Enter the salary: ");
        rate = input.nextDouble();
        System.out.print("Enter the bonus: ");
        bonus = input.nextDouble();

        SalariedEmployee newSalariedEmployee = new SalariedEmployee((fName + " " + lName), jobTitle, hireDate, rate, bonus);

        employeeList.add(newSalariedEmployee);
        System.out.println("New salaried employee added");

    }

    public static void addContractedEmployee(){
        String fName;
        String lName;
        String jobTitle;
        String hireDate;
        String company;
        String contractStart;
        String contractEnd;
        double hoursPerPeriod;
        double hourlyRate;

        System.out.print("Enter the first name of the employee: ");
        fName = input.next();
        System.out.print("Enter the last name of the employee: ");
        lName = input.next();
        System.out.print("Enter the job title: ");
        jobTitle = input.next();
        System.out.print("Enter the hire date: ");
        hireDate = input.next();
        System.out.print("Enter the company: ");
        company = input.nextLine();
        System.out.print("Enter the contract start: ");
        contractStart = input.next();
        System.out.print("Enter the contract end: ");
        contractEnd = input.next();
        System.out.print("Enter the hours per period: ");
        hoursPerPeriod = input.nextDouble();
        System.out.print("Enter the hourly rate: ");
        hourlyRate = input.nextDouble();

        ContractorEmployee newContractedEmployee = new ContractorEmployee((fName + " " + lName), jobTitle, hireDate, hourlyRate, company,contractStart, hoursPerPeriod,contractEnd);

        employeeList.add(newContractedEmployee);
        System.out.println("Contracted employee added to the list");

    }

    public static void viewAllEmployees(){

        if(employeeList.isEmpty()){
            System.out.println("No employees found!");
        }

        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
        menu();
    }

}

