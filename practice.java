//PART - IV
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class practice extends JFrame implements ActionListener {

    // Components
    JTextField txtL, txtR, txtN;
    JButton btnCalc, btnClear;

    public practice() {
        super("Loan Calculator");

        // --- Header Label (centered) ---
        JLabel header = new JLabel("Loan Calculator", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        add(header, BorderLayout.NORTH); // add to top of frame

        // --- Panel for form fields and buttons ---
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

        // Add panel to center of frame
        add(panel, BorderLayout.CENTER);

        // Final frame settings
        pack();
        setLocationRelativeTo(null); // center on screen
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
                JOptionPane.showMessageDialog(this, "Your monthly payment is " + String.format("%.2f", payment));
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
        new practice();
    }
}