package OOP.HW4_Abstraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

interface Item { //interface for phone and repair services
    double calculateSales(); //abstract method
    String getItemDetails(); //abstract method

}

class Phone implements Item { //class for phone, implements interface
    private final String item;  //instance variables to store item, price, and quantity sold, declared as private and final for encapsulation
    private final double price;
    private final int quantitySold;


    public Phone(String item, double price, int quantitySold) { //constructor to initialize price and quantity sold
        this.item = item;
        this.price = price;
        this.quantitySold = quantitySold;
    }

    public double calculateSales() { //override abstract method to calculate sales
        return price * quantitySold;
    }
    public String getItemDetails() { //override abstract method to get item details
        return item +": Price = " + price + ", Quantity Sold = " + quantitySold;
    }
}

class RepairServices implements Item { //class for repair services, implements interface

    private final String item;  //instance variables to store item, price per hour, and number of hours, declared as private and final for encapsulation
    private final double pricePerHour;
    private final int numberOfHours;
    public RepairServices(String item, double pricePerHour, int numberOfHours) { //constructor to initialize price per hour and number of hours
        this.item = item;
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }

    public double calculateSales() { //override abstract method to calculate sales
        return pricePerHour * numberOfHours;
    }

    public String getItemDetails() { //override abstract method to get item details
        return item + ": Price Per Hour = " + pricePerHour + ", Number of Hours = " + numberOfHours;
    }
}


public class SalesCalculator extends JFrame implements ActionListener { //class for sales calculator with GUI

    //GUI components
    private final JButton calculateButton;

    private final JTextField txt_Item1;

    private final JTextField txt_Item2;
    private final JTextField txt_Price;
    private final JTextField txt_QuantitySold;
    private final JTextField txt_PricePerHour;
    private final JTextField txt_NumberOfHours;
    private final JTextArea resultArea;

    public SalesCalculator() { //constructor to initialize GUI
        setTitle("Electronics Store Sales Calculator");  //set title of frame
        setSize(400, 550);                 // set size of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //exit on close
        setLayout(new BorderLayout(10,10));  //set layout of frame

        //Phone label
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Phone panel, 3 rows for item, price, and quantity
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new GridLayout(3, 1, 10, 5));

        //add components to phone panel
        phonePanel.add(new JLabel("Item"));                 //item label
        phonePanel.add(txt_Item1 = new JTextField(10)); //item text field to enter item name

        phonePanel.add(new JLabel("Price"));               //price label
        phonePanel.add(txt_Price = new JTextField(10)); //price text field to enter price

        phonePanel.add(new JLabel("Quantity Sold"));              //quantity sold label
        phonePanel.add(txt_QuantitySold = new JTextField(10)); //quantity sold text field to enter quantity

        //Repair Services label
        JLabel repairServicesLabel = new JLabel("Repair Services");
        repairServicesLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Repair panel, 3 rows for item, price per hour, and number of hours
        JPanel repairPanel = new JPanel();
        repairPanel.setLayout(new GridLayout(3, 1, 10, 5));

        //add components to repair panel
        repairPanel.add(new JLabel("Item"));                 //item label
        repairPanel.add(txt_Item2 = new JTextField(10)); //item text field to enter item name

        repairPanel.add(new JLabel("Price Per Hour"));             //price per hour label
        repairPanel.add(txt_PricePerHour = new JTextField(10)); //price per hour text field to enter price per hour

        repairPanel.add(new JLabel("Number of Hours"));              //number of hours label
        repairPanel.add(txt_NumberOfHours = new JTextField(10));  //number of hours text field to enter number of hours

        //Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 20));

        //Button
        calculateButton = new JButton("Calculate"); //calculate button
        calculateButton.addActionListener(this);      //add action listener to know when calculate button is clicked
        buttonPanel.add(calculateButton);                //add calculate button to panel

        //Result area
        resultArea = new JTextArea(8,1); //text area to display sales result
        resultArea.setPreferredSize(new Dimension(400, 60));
        resultArea.setEditable(false);

        //Main panel, 5 rows for phone label, phone panel, repair services label, repair panel, and button panel
        JPanel mainPanel = new JPanel(new GridLayout(5,1,5,5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //add components to main panel
        mainPanel.add(phoneLabel);          //start with phone label
        mainPanel.add(phonePanel);          //add phone panel
        mainPanel.add(repairServicesLabel); //add repair services label
        mainPanel.add(repairPanel);         //add repair panel
        mainPanel.add(buttonPanel);         //add button panel

        //add main panel and result area to frame
        add(mainPanel);
        add(resultArea, BorderLayout.SOUTH);
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

    public String getItem1() {
        return txt_Item1.getText();
    }

    public String getItem2() {
        return txt_Item2.getText();
    }

    //Action Listener for calculate button
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {

            //parsing (converting) text fields (what the user enters) to double and integer
            double price = Double.parseDouble(getPrice());
            double pricePerHour = Double.parseDouble(getPricePerHour());
            int quantitySold = Integer.parseInt(getQuantitySold());
            int numberOfHours = Integer.parseInt(getNumberOfHours());
            String phoneName = getItem1();
            String repairName = getItem2();

            //create phone and repair services objects
            Item phone = new Phone(phoneName, price, quantitySold);                            //passing price and quantity sold to constructor
            Item repairServices = new RepairServices(repairName, pricePerHour, numberOfHours); //passing price per hour and number of hours to constructor

            //running calculate sales and getting item details
            double phoneSales = phone.calculateSales();
            double repairSales = repairServices.calculateSales();
            String phoneDetails = phone.getItemDetails();
            String repairDetails = repairServices.getItemDetails();

            //change decimal format
            DecimalFormat df = new DecimalFormat("#.00");

            //displaying item details and sales in result area, "\n" for new line
            resultArea.setText(
                            "Phone Details: \n" + phoneDetails +
                            "\nPhone Sales: " + df.format(phoneSales) +
                            "\n\nRepair Services Details: \n" + repairDetails +
                            "\nRepair Services Sales: " + df.format(repairSales)
                            );
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
