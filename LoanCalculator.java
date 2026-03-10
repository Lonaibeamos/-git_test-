import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoanCalculator extends JFrame implements ActionListener {
    // Components
    JTextField txtL, txtR, txtN;
    JButton btnCalc, btnClear;

    public LoanCalculator() {
        //super("Loan Calculator");
        

        // Panel for layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        // Labels and text fields
        panel.add(new JLabel("Loan Amount:"));
        txtL = new JTextField(10);
        panel.add(txtL);

        panel.add(new JLabel("Monthly Interest Rate:"));
        txtR = new JTextField(10);
        panel.add(txtR);

        panel.add(new JLabel("Number of Payments:"));
        txtN = new JTextField(10);
        panel.add(txtN);

        // Buttons
        btnCalc = new JButton("Calculate");
        btnCalc.addActionListener(this);
        panel.add(btnCalc);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);
        panel.add(btnClear);

        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalc) {
            try {
                // Read input values
                double L = Double.parseDouble(txtL.getText());
                double R = Double.parseDouble(txtR.getText());
                int N = Integer.parseInt(txtN.getText());

                // Calculate monthly payment
                double payment = (L * R) / (1 - Math.pow(1 + R, -N));

                // Show result
                JOptionPane.showMessageDialog(this, "Your monthly payment is " + payment);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers.");
            }
        } else if (e.getSource() == btnClear) {
            // Clear all text fields
            txtL.setText("");
            txtR.setText("");
            txtN.setText("");
        }
    }

    public static void main(String[] args) {
        new LoanCalculator();
    }
}