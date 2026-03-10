import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class uglycalc extends JFrame implements ActionListener {
    JTextField x, y, z;
    JButton Add, Subt, Multi, Divide, Clear;

    uglycalc() {
        super("my first  Calculator");

        JLabel L = new JLabel("edSlash Coding Hub Calculator", JLabel.CENTER);
        L.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(L, BorderLayout.NORTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- PANEL 1 (for text fields) ---
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2, 7, 7));

        p1.add(new JLabel("Number 1:"));
        x = new JTextField(10);
        p1.add(x);

        p1.add(new JLabel("Number 2:"));
        y = new JTextField(10);
        p1.add(y);

        p1.add(new JLabel("Result:"));
        z = new JTextField(10);
        z.setEditable(false); // instead of hiding it
        p1.add(z);

        // --- PANEL 2 (for buttons) ---
        JPanel p2 = new JPanel(new FlowLayout());

        Add = new JButton("Add");
        Add.setFocusable(false);
        Add.addActionListener(this);

        Subt = new JButton("Subt");
        Subt.setFocusable(false);
        Subt.addActionListener(this);

        Multi = new JButton("Multi");
        Multi.setFocusable(false);
        Multi.addActionListener(this); // fixed method name

        Divide = new JButton("Divide");
        Divide.setFocusable(false);
        Divide.addActionListener(this); // fixed method name

        Clear = new JButton("Clear");
        Clear.setFocusable(false);
        Clear.addActionListener(this);

        // Add buttons to panel
        p2.add(Add);
        p2.add(Subt);
        p2.add(Multi);
        p2.add(Divide);
        p2.add(Clear);

        // Add panels to frame
        this.add(p1, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    // --- ACTION HANDLER ---
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == Add) {
                double A = Double.parseDouble(x.getText());
                double B = Double.parseDouble(y.getText());
                z.setText(String.valueOf(A + B));
            } 
            else if (e.getSource() == Subt) {
                double A = Double.parseDouble(x.getText());
                double B = Double.parseDouble(y.getText());
                z.setText(String.valueOf(A - B));
            } 
            else if (e.getSource() == Multi) {
                double A = Double.parseDouble(x.getText());
                double B = Double.parseDouble(y.getText());
                z.setText(String.valueOf(A * B));
            } 
            else if (e.getSource() == Divide) {
                double A = Double.parseDouble(x.getText());
                double B = Double.parseDouble(y.getText());
                if (B == 0) {
                    JOptionPane.showMessageDialog(this, "Dividing by zero is undefined!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                z.setText(String.valueOf(A / B)); // fixed: should divide, not add
            } 
            else if (e.getSource() == Clear) {
                x.setText("");
                y.setText("");
                z.setText("");
            }
        } 
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "INVALID INPUT!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new uglycalc();
    }
}
