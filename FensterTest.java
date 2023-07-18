import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Vector;
import java.sql.SQLException;

public class FensterTest extends JFrame implements ActionListener, ItemListener {
    private JPanel pan1, pan2;
    
    private JTextField nameEingabe;
    private JComboBox filmAuswahl;
    private JButton reservieren;
    
        
    public FensterTest() {
        super("Kinobuchungssystem");
        
        setSize(600,200);
        setLayout( new GridLayout(2,1) );
        hinzufuegen();
        
        add(pan1);
        add(pan2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);        
    }
    
    private void hinzufuegen() {
        pan1 = new JPanel();
        pan1.setLayout( new GridLayout(2,2) );
              
        JLabel name = new JLabel("Name: ");
        pan1.add(name);
        nameEingabe = new JTextField();
        pan1.add(nameEingabe);
        
        
        Vector<Film> filmListe = null;
        try {
             //filmListe = (Vector<Film>) Datenbankanbindung.getFilme();
            filmListe = new Vector <Film>(Datenbankanbindung.getFilme());           
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("Filme konnten aus der DB gelesen werden!");
        }
        
        JLabel film = new JLabel("Film auswählen:");
        pan1.add(film);
        JComboBox filmAuswahl = new JComboBox<Film>(filmListe);
        filmAuswahl.addItemListener(this);
        pan1.add(filmAuswahl);
        
        pan2 = new JPanel();
        pan2.setLayout( new GridLayout(2,2) );
        
        JLabel vorstellung = new JLabel("Vorstellung auswählen:");
        pan2.add(vorstellung);
        JComboBox vorstellungsAuswahl = new JComboBox();
        vorstellungsAuswahl.addItemListener(this);
        pan2.add(vorstellungsAuswahl);
        
        pan2.add( new JLabel() );
        reservieren = new JButton("Reservieren");
        reservieren.addActionListener(this);
        pan2.add(reservieren);
        
        pan1.setVisible(true);
        pan2.setVisible(false);  
        
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
    
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        
        if (e.getStateChange() == ItemEvent.SELECTED) {
            Film f = (Film) e.getItem();
            //ruft die toString()-Methode von Film auf:
            //System.out.println(f);
            
            pan2.setVisible(true);
            validate();
            repaint();
        }
    }
    
    public static void main(String[] args) {
        new FensterTest();
    }
    
}
