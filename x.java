import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class x extends JFrame implements ActionListener{
    JTextField txtL; 
    JTextField txt;
    JTextField txtN; 
    JButton btnClea;
    JButton btnCalc;
    x(){
        super("Loan calculation");
       // its like saying JFrame x = new JFrame("Loan Calculation");
       JLabel lblT = new JLabel("LOAN CALCULATOR",JLabel.CENTER);
       lblT.setFont(new Font("Ariel",Font.PLAIN,30));
       this.add(lblT,BorderLayout.NORTH);
       JPanel P = new JPanel();
       P.setLayout(new GridLayout(4,2,5,5));
       txtL = new JTextField(10);
       P.add(new JLabel("Loan Amount"));
       P.add(txtL);
       P.add(new JLabel("Monthly Interest Rate"));
       txt = new JTextField(10);
       P.add(txt);
       P.add(new JLabel("Number of Payments"));
       txtN = new JTextField(10);
       P.add(txtN);
       btnClea = new JButton("Calculate");
       btnClea.setFocusable(false);
       btnClea.addActionListener(this);
       P.add(btnClea);
       btnCalc = new JButton("Clear");
       btnCalc.setFocusable(false);
       btnCalc.addActionListener(this);
       P.add(btnCalc);
       this.add(P);
       this.pack();
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==btnClea){
                double L = Double.parseDouble(txtL.getText());
                double R = Double.parseDouble(txt.getText());
                int N = Integer.parseInt(txtN.getText());
                if(L<0){
                    throw new Exception("Loan cant be negative");
                }
                if(R<0){
                    throw new Exception("Monthly interest rate cant be negative");
                }
                if(N<0){
                    throw new Exception("Number of payments cant be negative");
                }

                //throw new NumberFormatException("INVALID INPUT. please only put a number, thanks :)");
                double formula = (L * R) / (1 - Math.pow(1+R,-N));
                JOptionPane.showMessageDialog(this,"your monthly payment is "+ formula);
            }
        }
            catch(NumberFormatException error){
                JOptionPane.showMessageDialog(this,"INVALID INPUT. please only put a number, thanks :)");
            }
            catch(Exception error){
                JOptionPane.showMessageDialog(this,error.getMessage());
            }
         if(e.getSource()==btnCalc){
            txtL.setText("");
            txt.setText("");
            txtN.setText("");
        }
        }
        public static void main(String[] args){
            new x();
        }
    }
