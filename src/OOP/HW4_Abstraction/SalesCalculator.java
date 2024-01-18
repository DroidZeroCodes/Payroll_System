package OOP.HW4_Abstraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface Item { //interface for phone and repair services
    double calculateSales(); //abstract method
    String getItemDetails(); //abstract method
}

class Phone implements Item { //class for phone, implements interface


    private final double price; //instance variables to store price and quantity sold, declared as private and final for encapsulation
    private final int quantitySold;


    public Phone(double price, int quantitySold) { //constructor to initialize price and quantity sold
        this.price = price;
        this.quantitySold = quantitySold;
    }

    public double calculateSales() { //override abstract method to calculate sales
        return price * quantitySold;
    }
    public String getItemDetails() { //override abstract method to get item details
        return "Phone: Price=" + price + ", Quantity Sold=" + quantitySold;
    }
}

class RepairServices implements Item { //class for repair services, implements interface

    private final double pricePerHour; //instance variables to store price per hour and number of hours, declared as private and final for encapsulation
    private final int numberOfHours;
    public RepairServices(double pricePerHour, int numberOfHours) { //constructor to initialize price per hour and number of hours
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }

    public double calculateSales() { //override abstract method to calculate sales
        return pricePerHour * numberOfHours;
    }

    public String getItemDetails() { //override abstract method to get item details
        return "Repair Services: Price Per Hour=" + pricePerHour + ", Number of Hours=" + numberOfHours;
    }
}


public class SalesCalculator extends JFrame implements ActionListener { //class for sales calculator with GUI

    //GUI components
    private final JButton calculateButton;
    private final JTextField txt_Price;
    private final JTextField txt_QuantitySold;
    private final JTextField txt_PricePerHour;
    private final JTextField txt_NumberOfHours;
    private final JTextArea resultArea;

    public SalesCalculator() { //constructor to initialize GUI
        setTitle("Electronics Store Sales Calculator");  //set title of frame
        setSize(550, 450);                 // set size of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //exit on close
        setLayout(new GridLayout(6,1));      // set layout of frame

        //Phone label
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Phone panel
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new FlowLayout());

        //add components to phone panel
        phonePanel.add(new JLabel("Price"));               //price label
        phonePanel.add(txt_Price = new JTextField(10)); //price text field to enter price

        phonePanel.add(new JLabel("Quantity Sold"));              //quantity sold label
        phonePanel.add(txt_QuantitySold = new JTextField(10)); //quantity sold text field to enter quantity

        //Repair Services label
        JLabel repairServicesLabel = new JLabel("Repair Services");
        repairServicesLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Repair panel
        JPanel repairPanel = new JPanel();
        repairPanel.setLayout(new FlowLayout());

        //add components to repair panel
        repairPanel.add(new JLabel("Price Per Hour"));             //price per hour label
        repairPanel.add(txt_PricePerHour = new JTextField(10)); //price per hour text field to enter price per hour

        repairPanel.add(new JLabel("Number of Hours"));              //number of hours label
        repairPanel.add(txt_NumberOfHours = new JTextField(10));  //number of hours text field to enter number of hours

        //Buttons
        calculateButton = new JButton("Calculate"); //calculate button
        calculateButton.addActionListener(this);      //add action listener to know when calculate button is clicked

        //Result
        resultArea = new JTextArea(); //text area to display sales result


        JPanel buttonPanel = new JPanel(); //panel for buttons
        buttonPanel.add(calculateButton);  //add calculate button to panel

        //add components to frame
        add(phoneLabel);          //start with phone label
        add(phonePanel);          //add phone panel
        add(repairServicesLabel); //add repair services label
        add(repairPanel);         //add repair panel
        add(buttonPanel);         //add button panel
        add(resultArea);          //add result area
    }

    //Getter Methods
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

    //Action Listener for calculate button
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {

            //parsing (converting) text fields (what the user enters) to double and integer
            double price = Double.parseDouble(getPrice());
            double pricePerHour = Double.parseDouble(getPricePerHour());
            int quantitySold = Integer.parseInt(getQuantitySold());
            int numberOfHours = Integer.parseInt(getNumberOfHours());

            //create phone and repair services objects
            Item phone = new Phone(price, quantitySold);                           //passing price and quantity sold to constructor
            Item repairServices = new RepairServices(pricePerHour, numberOfHours); //passing price per hour and number of hours to constructor

            //running calculate sales and getting item details
            double phoneSales = phone.calculateSales();
            double repairSales = repairServices.calculateSales();
            String phoneDetails = phone.getItemDetails();
            String repairDetails = repairServices.getItemDetails();

            //displaying item details and sales in result area, "\n" for new line
            resultArea.setText("Phone Details: " + phoneDetails + "\nRepair Services Details: " + repairDetails + "\nPhone Sales: " + phoneSales + "\nRepair Services Sales: " + repairSales);
        }
    }

    //main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { //run on swing thread
            SalesCalculator electronicsStore = new SalesCalculator(); //create object
            electronicsStore.setVisible(true); //make frame visible
        });
    }
}
