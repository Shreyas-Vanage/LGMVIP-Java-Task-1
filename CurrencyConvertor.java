// Developing Currency Convertor using Java 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConvertor extends JFrame implements ActionListener {
    private JTextField amountTextField;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JLabel resultLabel;
    // Exchange rates
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.73;
    private static final double USD_TO_JPY = 110.63;
    private static final double USD_TO_INR = 74.31;
    private static final double EUR_TO_USD = 1.18;
    private static final double GBP_TO_USD = 1.38;
    private static final double JPY_TO_USD = 0.009;
    private static final double INR_TO_USD = 0.013;

    public CurrencyConvertor() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField(10);

        JLabel fromLabel = new JLabel("From:");
        fromComboBox = new JComboBox<>(new String[] { "USD", "EUR", "GBP", "JPY", "INR" });

        JLabel toLabel = new JLabel("To:");
        toComboBox = new JComboBox<>(new String[] { "USD", "EUR", "GBP", "JPY", "INR" });

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        resultLabel = new JLabel("");

        add(amountLabel);
        add(amountTextField);
        add(fromLabel);
        add(fromComboBox);
        add(toLabel);
        add(toComboBox);
        add(convertButton);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double amount;
        try {
            amount = Double.parseDouble(amountTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fromCurrency = (String) fromComboBox.getSelectedItem();
        String toCurrency = (String) toComboBox.getSelectedItem();
        double result = convertCurrency(amount, fromCurrency, toCurrency);

        resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
    }

    private double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD")) {
            if (toCurrency.equals("EUR")) {
                return amount * USD_TO_EUR;
            } else if (toCurrency.equals("GBP")) {
                return amount * USD_TO_GBP;
            } else if (toCurrency.equals("JPY")) {
                return amount * USD_TO_JPY;
            } else if (toCurrency.equals("INR")) {
                return amount * USD_TO_INR;
            }
        } else if (fromCurrency.equals("EUR")) {
            if (toCurrency.equals("USD")) {
                return amount * EUR_TO_USD;
            }
        } else if (fromCurrency.equals("GBP")) {
            if (toCurrency.equals("USD")) {
                return amount * GBP_TO_USD;
            }
        } else if (fromCurrency.equals("JPY")) {
            if (toCurrency.equals("USD")) {
                return amount * JPY_TO_USD;
            }
        } else if (fromCurrency.equals("INR")) {
            if (toCurrency.equals("USD")) {
                return amount * INR_TO_USD;
            }
        }

        return amount;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CurrencyConvertor();
        });
    }
}
