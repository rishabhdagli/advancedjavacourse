package Unit3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Case> cases = new ArrayList<>();

    public static void main(String[] args) {
        cases.add(new CorportateCase(false, 10,"Apple", "Google", 12312.04, 234234.04));
        cases.add(new CriminalCase(false, 2, "Murder", "John", 12312.04));
        cases.add(new ProBonoCase(true, 4, "Appleseed", "Janice", true));
        menu();
    }

    public static void CorporateCaseCreate(){
        String cRep;
        String cOpp;
        double tCost;
        double tCharge;

        boolean settling = false;
        int lawyersoncase;
        System.out.println("Please enter the amount of lawyers on the case:");
        lawyersoncase = input.nextInt();
        System.out.println("Please enter if you are settling or not (1) for yes, (2) for no: ");
        int choice = input.nextInt();
        if(choice == 1) {
            settling = true;
        } else if(choice == 2) {settling = false;} else {System.out.println("Invalid choice"); System.exit(0);}

        System.out.println("Please enter company you are representing");
        cRep = input.next();

        System.out.println("Please enter the opposing company");
        cOpp = input.next();

        System.out.println("Please enter the total cost");
        tCost = input.nextDouble();

        System.out.println("Please enter the total charge");
        tCharge = input.nextDouble();

        CorportateCase CorportateCase = new CorportateCase(settling, lawyersoncase, cRep, cOpp, tCost, tCharge);

        cases.add(CorportateCase);
        System.out.println("Corporate case created and added");
        menu();
    }

    public static void ProBonoCaseCreate(){
        String defendant;
        String plantiff;
        boolean defending = false;
        int choice;

        boolean settling = false;
        int lawyersoncase;
        System.out.println("Please enter the amount of lawyers on the case:");
        lawyersoncase = input.nextInt();
        System.out.println("Please enter if you are settling or not (1) for yes, (2) for no: ");
        int choice2 = input.nextInt();
        if(choice2 == 1) {
            settling = true;
        } else if(choice2 == 2) {settling = false;} else {System.out.println("Invalid choice"); System.exit(0);}

        System.out.println("Please enter the defendants name:");
        defendant = input.next();

        System.out.println("Please enter the plantiffs name");
        plantiff = input.next();

        System.out.println("Type (1) if you are representing the defendant and (2) if your are reprsenting the plantiff");
        choice = input.nextInt();

        if(choice == 1) {
            defending = true;
        } else if(choice == 2) {defending = false;} else {System.out.println("Invalid choice"); System.exit(0);}

        ProBonoCase proBonoCase = new ProBonoCase(settling, lawyersoncase, defendant,plantiff, defending);

        cases.add(proBonoCase);
        System.out.println("Pro bono case created and added");
        menu();
    }

    public static void CriminalCaseCreate(){
        String crime;
        String name;
        double bailPrice;

        boolean settling = false;
        int lawyersoncase;
        System.out.println("Please enter the amount of lawyers on the case:");
        lawyersoncase = input.nextInt();
        System.out.println("Please enter if you are settling or not (1) for yes, (2) for no: ");
        int choice = input.nextInt();
        if(choice == 1) {
            settling = true;
        } else if(choice == 2) {settling = false;} else {System.out.println("Invalid choice"); System.exit(0);}

        System.out.println("Please enter the defendants name:");
        name = input.next();

        System.out.println("Please enter the crime commited:");
        crime = input.next();

        System.out.println("Enter the bail price: ");
        bailPrice = input.nextDouble();

        CriminalCase criminalCase = new CriminalCase(settling, lawyersoncase, crime,name,bailPrice);

        cases.add(criminalCase);
        System.out.println("Criminal case created and added");
        menu();
    }

    public static void ViewAllCases(){
        for(int i = 0; i < cases.size(); i++){
            System.out.println(cases.get(i).outputService());
        }
        menu();
    }

    public static void menu(){
        int choice;
        System.out.println("Hello! What kind of case would you like to log today? " +
                "Please refer to the guide for more instructions." + '\n' +
                "(1) Corporate" + '\n' +
                "(2) Pro Bono" + '\n' +
                "(3) Criminal" + '\n' +
                "(4) View Cases" + '\n');
        choice = input.nextInt();

        switch(choice) {
            case 1:
                CorporateCaseCreate();
                break;

            case 2:
                ProBonoCaseCreate();
                break;

            case 3:
                CriminalCaseCreate();
                break;

            case 4:
                ViewAllCases();
                break;

            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }
    }

}
