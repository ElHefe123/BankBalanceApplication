import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApplication {
    private double balance = 0.0;

    public BankBalanceApplication() {
        JFrame frame = new JFrame("Bank Balance Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel balanceLabel = new JLabel("Current Balance: $" + balance);
        JTextField amountField = new JTextField(10);
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = amountField.getText();
                try {
                    double amount = Double.parseDouble(amountStr);
                    balance += amount;
                    updateBalanceLabel(balanceLabel);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
                }
                amountField.setText("");
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = amountField.getText();
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (balance >= amount) {
                        balance -= amount;
                        updateBalanceLabel(balanceLabel);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient funds.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
                }
                amountField.setText("");
            }
        });

        frame.setVisible(true);
    }

    private void updateBalanceLabel(JLabel label) {
        label.setText("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankBalanceApplication();
            }
        });
    }
}
