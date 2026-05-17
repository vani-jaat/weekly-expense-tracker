import java.awt.*;
import javax.swing.*;
// Weekly Expense Tracker Application
public class ExpenseTracker {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Weekly Expense Tracker");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        // Day Dropdown
        JLabel dayLabel = new JLabel("Day:");
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JComboBox<String> dayBox = new JComboBox<>(days);

        // Category Dropdown
        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {"Groceries", "Eating Out", "Petrol", "Taxi", "Bills", "Rent", "Others"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);

        // Amount Field
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        // Description Field
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        // Buttons
        JButton addButton = new JButton("Add Expense");
        JButton totalButton = new JButton("Get Weekly Total");
        JButton categoryButton = new JButton("View By Category");

        // Output Area
        JTextArea outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
double[] totalExpense = {0};
double[] groceriesTotal = {0};
double[] eatingOutTotal = {0};
double[] petrolTotal = {0};
double[] taxiTotal = {0};
double[] billsTotal = {0};
double[] rentTotal = {0};
double[] othersTotal = {0};
addButton.addActionListener(e -> {

    String day = (String) dayBox.getSelectedItem();
    String category = (String) categoryBox.getSelectedItem();
    String amount = amountField.getText();
    double expenseAmount;

try {

    expenseAmount = Double.parseDouble(amount);

}
catch (Exception ex) {

    JOptionPane.showMessageDialog(
            frame,
            "Please enter a valid amount!"
    );

    return;
}
totalExpense[0] += expenseAmount;
if(category.equals("Groceries")) {
    groceriesTotal[0] += expenseAmount;
}
else if(category.equals("Eating Out")) {
    eatingOutTotal[0] += expenseAmount;
}
else if(category.equals("Petrol")) {
    petrolTotal[0] += expenseAmount;
}
else if(category.equals("Taxi")) {
    taxiTotal[0] += expenseAmount;
}
else if(category.equals("Bills")) {
    billsTotal[0] += expenseAmount;
}
else if(category.equals("Rent")) {
    rentTotal[0] += expenseAmount;
}
else {
    othersTotal[0] += expenseAmount;
}
    String description = descriptionField.getText();

    outputArea.append(
            "Day: " + day +
            " | Category: " + category +
            " | Amount: $" + amount +
            " | Description: " + description + "\n"
    );

});

        // Add Components
        panel.add(dayLabel);
        panel.add(dayBox);

        panel.add(categoryLabel);
        panel.add(categoryBox);

        panel.add(amountLabel);
        panel.add(amountField);

        panel.add(descriptionLabel);
        panel.add(descriptionField);

        panel.add(addButton);
        panel.add(totalButton);

        panel.add(categoryButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        // Weekly Total Button Function
totalButton.addActionListener(e -> {

    outputArea.append(
            "\nTotal Weekly Expense: $" + totalExpense[0] + "\n"
    );

});
// View By Category Button Function
categoryButton.addActionListener(e -> {

    outputArea.append("\nExpenses By Category:\n");

    outputArea.append("Groceries: $" + groceriesTotal[0] + "\n");
    outputArea.append("Eating Out: $" + eatingOutTotal[0] + "\n");
    outputArea.append("Petrol: $" + petrolTotal[0] + "\n");
    outputArea.append("Taxi: $" + taxiTotal[0] + "\n");
    outputArea.append("Bills: $" + billsTotal[0] + "\n");
    outputArea.append("Rent: $" + rentTotal[0] + "\n");
    outputArea.append("Others: $" + othersTotal[0] + "\n");

});

        frame.setVisible(true);
    }
}