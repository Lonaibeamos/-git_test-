import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Demo extends JFrame implements ActionListener{
    JTextField txtL,txt,txtN;
    JButton btnClea,btnCalc;
    Demo(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lblT = new JLabel("LOAN CALCULATOR",JLabel.CENTER);
        lblT.setFont(new Font("Times New Roman",Font.BOLD,20));
        this.add(lblT,BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,2,5,5));
        p.add(new JLabel("Loan Amount"));
        txtL = new JTextField(10);
        p.add(txtL);
        p.add(new JLabel("Monthly Interest Rate"));
        txt = new JTextField(10);
        txtN = new JTextField(10);
        p.add(txt);
        p.add(new JLabel("Number of payments"));
        p.add(txtN);
        btnClea = new JButton("Calculate");
        btnClea.setFocusable(false);
        btnClea.addActionListener(this);
        btnCalc = new JButton("Clear");
        btnCalc.setFocusable(false);
        btnCalc.addActionListener(this);
        p.add(btnClea); p.add(btnCalc);
        this.add(p);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnClea){
            try{
                double L = Double.parseDouble(txtL.getText());
            double R = Double.parseDouble(txt.getText());
            int N = Integer.parseInt(txtN.getText());
            if(L < 0){
                throw new Exception("Loan cant be negative!");
            }
            if(R < 0){
                throw new Exception("Interest rate cant be negative.");
            }
            if(N < 0){
                throw new Exception("Payment can't be negative");
            }
        
            double payment = ( L * R ) / (1 - Math.pow(1+R,-N));
            JOptionPane.showMessageDialog(this,"your monthly payment is "+payment);
        }
    catch(NumberFormatException z){
       JOptionPane.showMessageDialog(this,"INVALID INPUT. please use a number!");
    }
    catch(Exception L){
        JOptionPane.showMessageDialog(this,L.getMessage());
    }
        }
     else if(e.getSource()==btnCalc){
        txtL.setText("");
        txt.setText("");
        txtN.setText("");
    }
    }
    
    public static void main(String...args){
        new Demo();
    }

}
