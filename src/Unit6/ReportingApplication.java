package Unit6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ReportingApplication {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Company Sales Reporting");
        frame.setSize(1200, 1200);
        frame.setLayout(new BorderLayout());

        JLabel errorLabel = new JLabel("", JLabel.LEFT);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Report Start Date (mm/dd/yyyy):"));
        JTextField startDateField = new JTextField();
        inputPanel.add(startDateField);

        inputPanel.add(new JLabel("Report End Date (mm/dd/yyyy):"));
        JTextField endDateField = new JTextField();
        inputPanel.add(endDateField);

        inputPanel.add(errorLabel);

        JButton generateReportButton = new JButton("Generate Report");
        inputPanel.add(generateReportButton, BorderLayout.CENTER);

        frame.add(inputPanel, BorderLayout.NORTH);


        String[] columnNames = {"Sale Date", "Sale Price", "Sale Cost", "Profit or Loss", "Profit Margin"};
        Object[][] data = {
                {"01/05/2024", "500", "250", "Profit", "20%"},
                {"01/06/2024", "5645", "234", "Profit", "56%"},
                {"01/07/2024", "121", "654", "Profit", "23%"},
                {"01/08/2024", "5045450", "123", "Profit", "75%"},
                {"01/09/2024", "4565", "32", "Profit", "12%"},
                {"01/10/2024", "212", "54", "Profit", "76%"},
                {"01/11/2024", "86", "23", "Profit", "34%"},
                {"01/12/2024", "9678", "8168", "Profit", "88%"},
                {"01/13/2024", "4534", "645", "Profit", "12%"},
                {"01/14/2024", "87", "73", "Profit", "0%"},
                {"01/15/2024", "234", "356", "Loss", "9%"},
                {"01/16/2024", "75", "1", "Profit", "8%"},
                {"01/17/2024", "23", "97", "Loss", "7%"},
                {"01/18/2024", "876", "34", "Profit", "6%"},
                {"01/19/2024", "123", "87", "Profit", "5%"},
                {"01/20/2024", "84", "2", "Profit", "34%"},
        };
        Object[][] filteredData = new Object[100][5];
        JTable reportTable = new JTable(data, columnNames);
        JTable filteredReportTable = new JTable(filteredData, columnNames);
        frame.add(new JScrollPane(reportTable), BorderLayout.CENTER);
        frame.add(new JScrollPane(filteredReportTable), BorderLayout.SOUTH);


        generateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String startDateStr = startDateField.getText();
                String endDateStr = endDateField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate startFilterDate = null;
                LocalDate endFilterDate = null;
                int endRow = 0;
                int startRow = 0;


                try {
                    LocalDate startDate = LocalDate.parse(startDateStr, formatter);
                    LocalDate endDate = LocalDate.parse(endDateStr, formatter);

                    if (startDate.isAfter(endDate)) {
                        throw new IllegalArgumentException("Start date must be before end date.");
                    }

                    if (startDate.isEqual(endDate)) {
                        throw new IllegalArgumentException("Start date can not equal end date.");
                    }

                    for(int i = 0; i < reportTable.getRowCount(); i++){
                        if(reportTable.getValueAt(i, 0).equals(startDateStr)){
                            System.out.println("Start date found");
                            startFilterDate = LocalDate.parse((String) reportTable.getValueAt(i,0),formatter);
                            startRow = i;
                            System.out.println("Start row: " + startRow);
                            continue;
                        }

                        if(reportTable.getValueAt(i, 0).equals(endDateStr)){
                            System.out.println("End date found");
                            endFilterDate = LocalDate.parse((String) reportTable.getValueAt(i,0),formatter);
                            endRow = i;
                            break;
                        }
                    }

                    System.err.println(startFilterDate + " - " + endFilterDate + " " + startRow + " " + endRow);

                    if(startFilterDate == null || endFilterDate == null){
                        throw new IllegalArgumentException("At least 1 date is out of our data scope.");
                    }

                    try{

                        for(int i = startRow; i <= endRow; i++) {
                            for (int j = 0; j < columnNames.length; j++) {
                                System.out.println(reportTable.getValueAt(i, j).toString());
                                filteredReportTable.setValueAt(reportTable.getValueAt(i, j), i, j);
                                errorLabel.setText(" ");
                            }
                        }

                    } catch (Exception err){
                        System.err.println("Report generation failed! " + err.getMessage());
                        errorLabel.setText("Report generation failed!");
                    }


                } catch (IllegalArgumentException error) {
                    System.err.println(error.getMessage());
                    errorLabel.setText("Report generation failed! Error: " + error.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}