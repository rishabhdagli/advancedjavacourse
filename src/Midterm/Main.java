package Midterm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;


public class Main {
    static JPanel reportPanel = new JPanel();
    static JPanel inputPanel = new JPanel();
    static JPanel menuPanel = new JPanel();
    static JFrame frame = new JFrame();

    static Client client;
    static Projects chosenCase;

    static JTextField clientNameField = new JTextField();
    static JTextField projectNameField = new JTextField();
    static JTextField memberNameField = new JTextField();
    static JTextField projectCompletionField = new JTextField();
    static JTextField memberHoursField = new JTextField();

    static String[] volumeMenuItems = {"High Volume Client", "Low Volume Client"};
    static JComboBox volumeComboBox = new JComboBox(volumeMenuItems);

    static String[] projectTypeItems = {"Defendant", "Plantiff"};
    static JComboBox projectTypeComboBox = new JComboBox(projectTypeItems);

    static ArrayList<String[]> dataList = new ArrayList<>();
    static String[] columnNames = {"Client Name", "Client Type", "Project Name", "Member Name", "Project Type", "Project Completion", "Member Hours"};
    static DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    static JTable reportTable = new JTable(tableModel);
    static JScrollPane reportScrollPane = new JScrollPane(reportTable);

    public static void main(String[] args) {
        frame.setTitle("Project Management System");
        frame.setSize(750, 350);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        inputPanel.setLayout(new GridLayout(9, 2, 15, 5));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            submitInput();
        });

        JButton inReturnButton = new JButton("Return");
        inReturnButton.addActionListener(e ->
        {
            cardLayout.show(cardPanel, "MenuPanel");
        });

        JButton reportReturnButton = new JButton("Return");
        reportReturnButton.addActionListener(e ->
        {
            cardLayout.show(cardPanel, "MenuPanel");
        });


        JLabel clientName = new JLabel("Client Name: ");
        JLabel projectName = new JLabel("Project Name: ");
        JLabel memberName = new JLabel("Member Name: ");
        JLabel projectCompletion = new JLabel("Project Completion: ");
        JLabel memberHours = new JLabel("Member Hours: ");

        inputPanel.add(clientName);
        inputPanel.add(clientNameField);
        inputPanel.add(projectName);
        inputPanel.add(projectNameField);
        inputPanel.add(memberName);
        inputPanel.add(memberNameField);
        inputPanel.add(projectCompletion);
        inputPanel.add(projectCompletionField);
        inputPanel.add(memberHours);
        inputPanel.add(memberHoursField);
        inputPanel.add(volumeComboBox);
        inputPanel.add(projectTypeComboBox);
        inputPanel.add(submitButton);
        inputPanel.add(inReturnButton);


        reportPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        reportPanel.setLayout(new BorderLayout());
        reportPanel.add(reportScrollPane, BorderLayout.CENTER);
        reportPanel.add(reportReturnButton, BorderLayout.SOUTH);


        cardPanel.add(inputPanel, "InputPanel");
        cardPanel.add(reportPanel, "ReportPanel");
        cardPanel.add(menuPanel, "MenuPanel");


        frame.add(cardPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton inputButton = new JButton("Input");
        JButton reportButton = new JButton("Report");
        JButton exitButton = new JButton("Exit");


        cardLayout.show(cardPanel, "MenuPanel");

        inputButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "InputPanel");
            System.out.println("hi");
        });

        reportButton.addActionListener(e -> {
            updateDataTable();
            cardLayout.show(cardPanel, "ReportPanel");
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });


        buttonPanel.add(inputButton);
        buttonPanel.add(reportButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    public static void submitInput() {

        try {

            if (volumeComboBox.getSelectedItem().equals("High Volume Client") && projectTypeComboBox.getSelectedItem().equals("Defendant")){
                client = new HighVolumeClient(clientNameField.getText(), 100000);
                chosenCase = new DefendantCase(clientNameField.getText(), Integer.parseInt(memberHoursField.getText()), client);

            } else if (volumeComboBox.getSelectedItem().equals("Low Volume Client") && projectTypeComboBox.getSelectedItem().equals("Defendant")) {
                client = new LowVolumeClient(clientNameField.getText(), 99999);
                chosenCase = new DefendantCase(clientNameField.getText(), Integer.parseInt(memberHoursField.getText()), client);

            } else if (volumeComboBox.getSelectedItem().equals("High Volume Client") && projectTypeComboBox.getSelectedItem().equals("Plantiff")) {
                client = new HighVolumeClient(clientNameField.getText(), 100000);
                chosenCase = new PlantiffCase(clientNameField.getText(), Integer.parseInt(memberHoursField.getText()), client);

            } else if (volumeComboBox.getSelectedItem().equals("Low Volume Client") && projectTypeComboBox.getSelectedItem().equals("Plantiff")) {
                client = new LowVolumeClient(clientNameField.getText(), 99999);
                chosenCase = new PlantiffCase(clientNameField.getText(), Integer.parseInt(memberHoursField.getText()), client);
            } else {
               client = null;
            }

            try {
                String[] rowData = {
                        client.getName(),
                        volumeComboBox.getSelectedItem().toString(),
                        chosenCase.getName(),
                        memberNameField.getText(),
                        projectTypeComboBox.getSelectedItem().toString(),
                        projectCompletionField.getText(),
                        String.valueOf(chosenCase.getTotalHours())
                };
                dataList.add(rowData);
            } catch (NullPointerException nullPointerException) {
                JOptionPane.showMessageDialog(frame, "Data is missing! " + nullPointerException.getMessage());
            }


            clientNameField.setText("");
            projectNameField.setText("");
            memberNameField.setText("");
            projectCompletionField.setText("");
            memberHoursField.setText("");

        } catch (NullPointerException nullPointerException) {
            JOptionPane.showMessageDialog(frame, "Data is missing! " + nullPointerException.getMessage());
        }
    }

    public static void updateDataTable() {
        int dataSize = dataList.size();
        ArrayList<String[]> tempData = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            tempData.add(dataList.get(i));
        }
        dataList.clear();

        for (int i = 0; i < dataSize; i++) {
            String[] rowData = tempData.get(i);
            tableModel.addRow(rowData);
        }
    }
}
