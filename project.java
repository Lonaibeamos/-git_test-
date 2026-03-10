import java.awt.*;
import javax.swing.*;
class project{
    public static void main(String[] args){
        JFrame frame = new JFrame("java.awt.Frame");
        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();
        JMenu F = new JMenu("File");
        JMenu M = new JMenu("Edit");
        bar.add(F); bar.add(M);
        frame.setJMenuBar(bar);
        frame.setVisible(true);
    }
}