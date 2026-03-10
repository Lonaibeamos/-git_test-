//Dialogue box
import javax.swing.*;
import java.awt.*;
public class project1{
    public static void main(String...args){
        JFrame f = new JFrame("A Dialog Box");
        f.setLayout(null);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField field = new JTextField();
        field.setBounds(130,30,100,20);
        JLabel L = new JLabel("Enter a number");
        L.setBounds(20,30,120,20);
        f.add(L); f.add(field);
        //f.pack();
        f.setVisible(true);
    }
}