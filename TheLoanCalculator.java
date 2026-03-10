import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TheLoanCalculator extends JFrame implements ActionListener{
    JTextField txtL,txt,txtN;
    JButton btnCalc,btnClea;
    TheLoanCalculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lblT = new JLabel("LOAN CALCULATOR",JLabel.CENTER);
        lblT.setFont(new Font("Arial",Font.PLAIN,20));
        this.add(lblT,BorderLayout.NORTH);
        JOptionPane p = new JOptionPane();
        p.setLayout(new GridLayout(4,2,5,5));
        p.add(new JLabel("Loan Amount"));
        txtL = new JTextField(10);
        p.add(txtL);
        p.add(new JLabel("Monthly Interest Rate"));
        txt = new JTextField(10);
        p.add(txt);
        p.add(new JLabel("Number of Payments"));
        txtN = new JTextField(10);
        p.add(txtN);
        btnClea = new JButton("Calculate");
        btnClea.setFocusable(false);
        btnClea.addActionListener(this);
        p.add(btnClea);
        btnCalc = new JButton("Clear");
        btnCalc.setFocusable(false);
        btnCalc.addActionListener(this);
        p.add(btnCalc);
        this.add(p);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==btnClea){
            try{
                double L = Double.parseDouble(txtL.getText());
                double R = Double.parseDouble(txt.getText());
                int N = Integer.parseInt(txtN.getText());
                if(L<0){
                    throw new Exception("Loan Can't be Negative.Make it Positive");
                }
                if(R<0){
                    throw new Exception("Rate can't be Negative.Please Make It Positive");
                }
                if(N<0||N==0){
                    throw new Exception("Number of payments cant be Zero or Negative.Make it Positive");
                }
                double formula = (L*R) / (1-Math.pow(1+R,-N));
                JOptionPane.showMessageDialog(null,"your monthly payment is " + formula,"Message",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(NumberFormatException b){
                JOptionPane.showMessageDialog(null,"INVALID INPUT.Please Enter a number","Error",JOptionPane.ERROR_MESSAGE);

            }
            catch(Exception c){
                JOptionPane.showMessageDialog(null,c.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(a.getSource()==btnCalc){
            txtL.setText("");
            txt.setText("");
            txtN.setText("");
        }
    }
    public static void main(String[] args){
        new TheLoanCalculator();
    }
}