
package Unit8;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static JTextField sellingPriceField = new JTextField();
    static JTextField costPriceField = new JTextField();

    static String[] caseTypes = {"Corporate Case", "Criminal Case", "Pro Bono Case"};
    static JComboBox caseTypeComboBox = new JComboBox(caseTypes);

    static ArrayList<LegalCase> activeCases = new ArrayList<>();
    static ArrayList<LegalCase> openCases = new ArrayList<>();

    static String[] columnNames = {"Case Type", "Selling Price", "Cost Price"};
    static DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    static JTable reportTable = new JTable(tableModel);
    static JScrollPane reportScrollPane = new JScrollPane(reportTable);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setLayout(new FlowLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2));

        JLabel infoLabel = new JLabel();
        JButton inputButton = new JButton("Input");
        JButton reportButton = new JButton("Report");

        mainPanel.add(inputButton);
        mainPanel.add(reportButton);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        JPanel reportPanel = new JPanel();
        reportPanel.setLayout(new BorderLayout());
        reportPanel.add(reportScrollPane);

        JLabel sellingPriceLabel = new JLabel("Selling Price: ");
        JLabel costPriceLabel = new JLabel("Cost Price: ");

        JButton submitButton = new JButton("Submit");
        JButton returnButton = new JButton("Return");

        JButton loadButton = new JButton("Load Data");
        JButton secondReturnButton = new JButton("Return");

        reportPanel.add(loadButton, BorderLayout.NORTH);
        reportPanel.add(secondReturnButton, BorderLayout.SOUTH);


        inputPanel.add(sellingPriceLabel);
        inputPanel.add(sellingPriceField);
        inputPanel.add(costPriceLabel);
        inputPanel.add(costPriceField);
        inputPanel.add(caseTypeComboBox);
        inputPanel.add(returnButton);
        inputPanel.add(submitButton);
        inputPanel.add(infoLabel, 5);

        frame.add(mainPanel);
        frame.add(inputPanel);
        frame.add(reportPanel);

        inputButton.addActionListener(e -> {
            mainPanel.setVisible(false);
            reportPanel.setVisible(false);
            inputPanel.setVisible(true);
        });

        reportButton.addActionListener(e -> {
            mainPanel.setVisible(false);
            inputPanel.setVisible(false);
            reportPanel.setVisible(true);
        });

        returnButton.addActionListener(e -> {
            mainPanel.setVisible(true);
            inputPanel.setVisible(false);
            reportPanel.setVisible(false);
        });

        secondReturnButton.addActionListener(e -> {
            mainPanel.setVisible(true);
            inputPanel.setVisible(false);
            reportPanel.setVisible(false);
        });



        submitButton.addActionListener( e -> {
            double sellingPrice;
            double costPrice;

            ObjectOutputStream outputStream =  null;

            try{
                    outputStream = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream("caseInfo.txt")));

                    sellingPrice = Double.parseDouble(sellingPriceField.getText());
                    costPrice = Double.parseDouble(costPriceField.getText());

                    LegalCase legalCase = new LegalCase(caseTypeComboBox.getSelectedItem().toString(), sellingPrice, costPrice);

                    activeCases.add(legalCase);

                    outputStream.writeObject(activeCases);

                    outputStream.flush();

                    outputStream.close();

                    costPriceField.setText("");
                    sellingPriceField.setText("");

                    caseTypeComboBox.setSelectedItem("Corporate Case");

                    infoLabel.setText("Success!");

            } catch (IOException error){
                infoLabel.setText("Couldn't access file!");
            }


        });

        loadButton.addActionListener(e -> {

            ObjectInputStream in = null;

            try {
                in = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("caseInfo.txt")));

                openCases = (ArrayList<LegalCase>) in.readObject();

                System.out.println(openCases.toArray().toString());

                Object[][] data = new Object[openCases.size()][3];

                for(int i = 0; i < openCases.size(); i++){
                    data[i][0] = openCases.get(i).getName();
                    data[i][1] = openCases.get(i).getSalePrice();
                    data[i][2] = openCases.get(i).getCostPrice();
                }

                tableModel.setRowCount(0);

                for (int i = 0; i < data.length; i++) {
                    tableModel.addRow(data[i]);
                }


            }
            catch(Exception error) {
               error.printStackTrace();
            }


        });
























        inputPanel.setVisible(false);
        reportPanel.setVisible(false);
        frame.setVisible(true);

        /*
        // Configure products
        System.out.println("Configure Corporate Case:");
        System.out.print("Selling price: ");
        double corpCaseSP = scanner.nextDouble();
        System.out.print("cost to company: ");
        double corpCaseCC = scanner.nextDouble();
        LegalCase corpCase = new LegalCase("Corp Case", corpCaseSP, corpCaseCC);

        System.out.println("Configure Criminal Case:");
        System.out.print("selling price: ");
        double crimCaseSP = scanner.nextDouble();
        System.out.print("cost to company: ");
        double crimeCaseCC = scanner.nextDouble();
        LegalCase crimCase = new LegalCase("Crim Case", crimCaseSP, crimeCaseCC);

        System.out.println("Configure Pro Bono Case:");
        System.out.print("selling price: ");
        double pbCaseSP = scanner.nextDouble();
        System.out.print("cost to company: ");
        double pbCaseCC = scanner.nextDouble();
        // Collect orders
        System.out.print("How many orders will you be entering? ");
        int numOrders = scanner.nextInt();
        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 1; i <= numOrders; i++) {
            System.out.println("Order " + i + " – which product? (1) for Corporate case, (2) for Criminal, (3) for Pro Bono Case");
            int productChoice = scanner.nextInt();
            System.out.println("Order " + i + " – quantity?");
            int quantity = scanner.nextInt();

            LegalCase chosenProduct;

            switch (productChoice) {
                case 1:
                    chosenProduct = corpCase;
                    break;
                case 2:
                    chosenProduct = crimCase;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Wrong choice. Sorry!");
                    chosenProduct = null;
                    break;
            }
            ArrayList<OrderItem> orderItems = new ArrayList<>();

            orders.add(new Order(i, orderItems));
        }

        // Perform calculations
        Accounting accounting = new Accounting(orders);

        // Output results
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).summarize());
        }

        System.out.println(accounting.summarize());

        scanner.close();
*/
    }
    }