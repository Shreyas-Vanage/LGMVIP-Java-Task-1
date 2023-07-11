// Developing Currency Convertor using Java 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CC extends JFrame implements ActionListener {
    private JTextField amtf;
    private JComboBox<String> fcb;
    private JComboBox<String> tcb;
    private JLabel resultL;
    // Exchange rates
    private static final double USD_EUR = 0.85;
    private static final double USD_GBP = 0.73;
    private static final double USD_JPY = 110.63;
    private static final double USD_INR = 74.31;
    private static final double EUR_USD = 1.18;
    private static final double GBP_USD = 1.38;
    private static final double JPY_USD = 0.009;
    private static final double INR_USD = 0.013;

    public CC() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        JLabel amountLabel = new JLabel("Amount:");
        amtf = new JTextField(10);

        JLabel fromLabel = new JLabel("From:");
        fcb = new JComboBox<>(new String[] { "USD", "EUR", "GBP", "JPY", "INR" });

        JLabel toLabel = new JLabel("To:");
        tcb = new JComboBox<>(new String[] { "USD", "EUR", "GBP", "JPY", "INR" });

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        resultL = new JLabel("");

        add(amountLabel);
        add(amtf);
        add(fromLabel);
        add(fcb);
        add(toLabel);
        add(tcb);
        add(convertButton);
        add(resultL);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double amount;
        try {
            amount = Double.parseDouble(amtf.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fromCurrency = (String) fcb.getSelectedItem();
        String toCurrency = (String) tcb.getSelectedItem();
        double result = convertCurrency(amount, fromCurrency, toCurrency);

        resultL.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
    }

    private double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD")) {
            if (toCurrency.equals("EUR")) {
                return amount * USD_EUR;
            } else if (toCurrency.equals("GBP")) {
                return amount * USD_GBP;
            } else if (toCurrency.equals("JPY")) {
                return amount * USD_JPY;
            } else if (toCurrency.equals("INR")) {
                return amount * USD_INR;
            }
        } else if (fromCurrency.equals("EUR")) {
            if (toCurrency.equals("USD")) {
                return amount * EUR_USD;
            }
        } else if (fromCurrency.equals("GBP")) {
            if (toCurrency.equals("USD")) {
                return amount * GBP_USD;
            }
        } else if (fromCurrency.equals("JPY")) {
            if (toCurrency.equals("USD")) {
                return amount * JPY_USD;
            }
        } else if (fromCurrency.equals("INR")) {
            if (toCurrency.equals("USD")) {
                return amount * INR_USD;
            }
        }

        return amount;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CC();
        });
    }
}
