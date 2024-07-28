package Unit7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class SalesReportApplication {

    public static void main(String[] args) {

        File file = new File("/Users/rishabhdagli/Downloads/salesData.csv");

        String line = null;

        Object[][] data = new Object[1000][1000];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        JLabel errorLabel = new JLabel("", JLabel.LEFT);

        ArrayList<String[]> list = new ArrayList<>();

        String[] splitLine = null;

        String[] temp;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));


            while((line = br.readLine()) != null) {
                for(int i = 0; i < line.length(); i++) {
                    splitLine = line.split(",");
                }
                list.add(splitLine);
            }

            for (int i = 1; i < list.size() - 1; i++) {
                for (int j = 1; j < list.size() - i; j++) {
                    LocalDate dateA = LocalDate.parse(list.get(j)[3], formatter);
                    LocalDate dateB = LocalDate.parse(list.get(j + 1)[3], formatter);
                    if (dateA.isAfter(dateB)) {
                        temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }

        } catch (FileNotFoundException error) {
            errorLabel.setText("The data file wasn't found!");
        } catch (IOException error){
           errorLabel.setText("Could not read the data file.");
        } catch (IndexOutOfBoundsException error){
            errorLabel.setText("The dates could be out of bounds.");
        } catch (Exception error) {
            errorLabel.setText(error.getMessage());
        }


        JFrame frame = new JFrame("Sales Report");
        frame.setSize(1200, 1200);
        frame.setLayout(new BorderLayout());

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


        String[] columnNames = {"itemId", "salePrice" ,"saleCost","saleDate"};

        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < columnNames.length; j++) {
                data[i][j] = list.get(i)[j];
            }
        }

        Object[][] filteredData = new Object[365][5];
        JTable reportTable = new JTable(data, columnNames);
        JTable filteredReportTable = new JTable(filteredData, columnNames);
        frame.add(new JScrollPane(reportTable), BorderLayout.CENTER);
        frame.add(new JScrollPane(filteredReportTable), BorderLayout.SOUTH);


        generateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String startDateStr = startDateField.getText();
                String endDateStr = endDateField.getText();
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

                    try{

                        startFilterDate = LocalDate.parse(startDateStr, formatter);
                        endFilterDate = LocalDate.parse(endDateStr, formatter);

                        for(int i = 0; i <1000; i++) {
                            if(data[i][3].equals(startDateStr)) {
                                startRow = i;
                                continue;
                            }
                            if(data[i][3].equals(endDateStr)) {
                                endRow = i;
                                break;
                            }
                        }

                        for(int i = startRow; i <= endRow; i++) {
                            for(int j = 0; j < 4; j++) {
                                filteredData[i][j] = data[i][j];
                            }
                        }

                    } catch (Exception error){
                        System.err.println(error);
                    }

                    if(startFilterDate == null || endFilterDate == null){
                        throw new IllegalArgumentException("At least 1 date is out of our data scope.");
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