import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenster extends JFrame implements ActionListener {
    private JTextField nameEingabe;
    private JButton reservieren;
    
    public Fenster() {
        super("Kinobuchungssystem");
        
        setSize(600,200);
        setLayout( new GridLayout(3,2) );
        hinzufuegen();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
    }
    
    private void hinzufuegen() {
        JLabel titel = new JLabel("Kinobuchungssystem");
        add(titel);
        add( new JLabel() );
        
        JLabel name = new JLabel("Name: ");
        add(name);
        nameEingabe = new JTextField();
        add(nameEingabe);
        
        add( new JLabel() );
        reservieren = new JButton("Reservieren");
        reservieren.addActionListener(this);
        add(reservieren);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        Object verursacher = event.getSource();
        
        if (verursacher == reservieren) {
            if (nameEingabe.getText().length() > 0) {
                System.out.println("Reserviert!");
            } else {
                System.out.println("Bitte Namen eingeben!");
            }
            
        }
    }
    
    public static void main(String[] args) {
        new Fenster();
    }
    
}
