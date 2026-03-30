import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BankingGUI {
    private static double balance = 1000.00;
    private static ArrayList<String> transactions = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showLoginScreen());
    }

    private static void showLoginScreen() {
        JFrame loginFrame = new JFrame("Bank Login");
        loginFrame.setSize(300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("PIN:");
        passLabel.setForeground(Color.WHITE);
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        panel.add(userLabel); panel.add(userField);
        panel.add(passLabel); panel.add(passField);
        panel.add(new JLabel()); panel.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pin = new String(passField.getPassword());
            if (user.equals("admin") && pin.equals("1234")) {
                loginFrame.dispose();
                createAndShowGUI();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid credentials.");
            }
        });

        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout(10, 10));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        JButton balanceBtn = new JButton("Show Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton exitBtn = new JButton("Exit");

        for (JButton btn : new JButton[]{balanceBtn, depositBtn, withdrawBtn, exitBtn}) {
            btn.setBackground(Color.DARK_GRAY);
            btn.setForeground(Color.GREEN);
            buttonPanel.add(btn);
        }

        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setBackground(Color.BLACK);
        historyArea.setForeground(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(historyArea);

        JLabel statusLabel = new JLabel("Welcome, admin!", SwingConstants.CENTER);
        statusLabel.setForeground(Color.GREEN);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(statusLabel, BorderLayout.SOUTH);

        // Button actions
        balanceBtn.addActionListener(e -> {
            statusLabel.setText("Your balance is ₦" + String.format("%.2f", balance));
            log("Checked balance: ₦" + balance, historyArea);
        });

        depositBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter deposit amount:");
            try {
                if (input != null) {
                    double amount = Double.parseDouble(input);
                    if (amount > 0) {
                        balance += amount;
                        statusLabel.setText("Deposited ₦" + amount);
                        log("Deposited: ₦" + amount, historyArea);
                    } else {
                        statusLabel.setText("Amount must be positive.");
                    }
                }
            } catch (NumberFormatException ex) {
                statusLabel.setText("Invalid input.");
            }
        });

        withdrawBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:");
            try {
                if (input != null) {
                    double amount = Double.parseDouble(input);
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        statusLabel.setText("Withdrew ₦" + amount);
                        log("Withdrew: ₦" + amount, historyArea);
                    } else if (amount > balance) {
                        statusLabel.setText("Insufficient funds.");
                    } else {
                        statusLabel.setText("Amount must be positive.");
                    }
                }
            } catch (NumberFormatException ex) {
                statusLabel.setText("Invalid input.");
            }
        });

        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void log(String action, JTextArea historyArea) {
        transactions.add(action);
        historyArea.setText(""); // clear
        for (String entry : transactions) {
            historyArea.append(entry + "\n");
        }
    }
}
