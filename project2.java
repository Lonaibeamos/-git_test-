// import java.awt.*;
import javax.swing.*;
class project2{
    public static void main(String...args){
        JFrame F = new JFrame("AWT Test");
        F.setSize(400,400);
        F.setLayout(null);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel P = new JPanel();
        P.setBounds(25,50,350,150);
        JLabel l = new JLabel("Label 1");
        l.setBounds(40,80,100,50);
        JTextField f = new JTextField("TextField 1");
        f.setBounds(150,80,100,50);
        P.add(l);P.add(f);
        JPanel P1 = new JPanel();
        P.setBounds(25,250,350,150);
        JButton b1 = new JButton("Button 1");
        b1.setBounds(40,270,50,50);
        JButton b2 = new JButton("Button 2");
        b2.setBounds(90,270,50,50);
        JButton b3 = new JButton("Button 3");
        b3.setBounds(140,270,50,50);
        P1.add(b1);P1.add(b2);P1.add(b3);
        F.add(P); F.add(P1);
        F.setVisible(true);
    }
}