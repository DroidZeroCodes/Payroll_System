package OOP.HW4_Abstraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface Item {
    double calculateSales();
    String getItemDetails();
}

class Phone implements Item {

    private double price;
    private int quantitySold;
    public Phone(double price, int quantitySold) {
        this.price = price;
        this.quantitySold = quantitySold;
    }

    public double calculateSales() {
        return price * quantitySold;
    }

    public String getItemDetails() {
        return "Phone: Price=" + price + ", Quantity Sold=" + quantitySold;
    }
}

class RepairServices implements Item {

    private double pricePerHour;
    private int numberOfHours;
    public RepairServices(double pricePerHour, int numberOfHours) {
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }

    public double calculateSales() {
        return pricePerHour * numberOfHours;
    }

    public String getItemDetails() {
        return "Repair Services: Price Per Hour=" + pricePerHour + ", Number of Hours=" + numberOfHours;
    }
}


public class SalesCalculator extends JFrame implements ActionListener {
    private JButton calculateButton;
    private JLabel phoneLabel;
    private JLabel repairServicesLabel;
    private JLabel lbl_PhonePrice;
    private JLabel lbl_PhoneQuantitySold;
    private JLabel lbl_RepairPricePerHour;
    private JLabel lbl_RepairNumberOfHours;
    private JTextField txt_Price;
    private JTextField txt_QuantitySold;
    private JTextField txt_PricePerHour;
    private JTextField txt_NumberOfHours;
    private JTextArea resultArea;

    public SalesCalculator() {
        setTitle("Electronics Store Sales Calculator");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6,1));

        //Phone
        phoneLabel = new JLabel("Phone");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new FlowLayout());

        phonePanel.add(lbl_PhonePrice = new JLabel("Price"));
        phonePanel.add(txt_Price = new JTextField(10));

        phonePanel.add(lbl_PhoneQuantitySold = new JLabel("Quantity Sold"));
        phonePanel.add(txt_QuantitySold = new JTextField(10));

        //Repair
        repairServicesLabel = new JLabel("Repair Services");
        repairServicesLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel repairPanel = new JPanel();
        repairPanel.setLayout(new FlowLayout());

        repairPanel.add(lbl_RepairPricePerHour = new JLabel("Price Per Hour"));
        repairPanel.add(txt_PricePerHour = new JTextField(10));

        repairPanel.add(lbl_RepairNumberOfHours = new JLabel("Number of Hours"));
        repairPanel.add(txt_NumberOfHours = new JTextField(10));

        //Buttons
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        //Result
        resultArea = new JTextArea();


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        add(phoneLabel);
        add(phonePanel);
        add(repairServicesLabel);
        add(repairPanel);
        add(buttonPanel);
        add(resultArea);
    }

    private String getPrice() {
        return txt_Price.getText();
    }

    private String getQuantitySold() {
        return txt_QuantitySold.getText();
    }

    private String getPricePerHour() {
        return txt_PricePerHour.getText();
    }

    private String getNumberOfHours() {
        return txt_NumberOfHours.getText();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {

            double price = Double.parseDouble(getPrice());
            double pricePerHour = Double.parseDouble(getPricePerHour());
            int quantitySold = Integer.parseInt(getQuantitySold());
            int numberOfHours = Integer.parseInt(getNumberOfHours());

            Item phone = new Phone(price, quantitySold);
            Item repairServices = new RepairServices(pricePerHour, numberOfHours);

            double phoneSales = phone.calculateSales();
            double repairSales = repairServices.calculateSales();
            String phoneDetails = phone.getItemDetails();
            String repairDetails = repairServices.getItemDetails();

            resultArea.setText("Phone Details: " + phoneDetails + "\nRepair Services Details: " + repairDetails + "\nPhone Sales: " + phoneSales + "\nRepair Services Sales: " + repairSales);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalesCalculator electronicsStore = new SalesCalculator();
            electronicsStore.setVisible(true);
        });
    }
}
