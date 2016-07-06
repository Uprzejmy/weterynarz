package weterynarz.View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class View {
	
	private JFrame frame;
    private JLabel label;
    private JButton button1;
    private JButton button2;

    public View(String text)
    {
        frame = new JFrame("Najladniejsze kotki internetu");                                    
        frame.getContentPane().setLayout(new BorderLayout());                                          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(200,200);        
        frame.setVisible(true);
        
        label = new JLabel(text);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        button1 = new JButton("Rejestruj u¿ytkownika");    
        button2 = new JButton("Pobierz dane");    
        frame.getContentPane().add(button1, BorderLayout.NORTH);    
        frame.getContentPane().add(button2, BorderLayout.SOUTH); 
    }
        
    public JButton getButton1()
    {
        return button1;
    }
    
    public JButton getButton2()
    {
        return button2;
    }
    
    public void setText(String text)
    {
        label.setText(text);
    }
}
