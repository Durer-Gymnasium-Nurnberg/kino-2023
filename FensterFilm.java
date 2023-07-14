import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FensterFilm extends JFrame implements ActionListener {
    private JTextField nameEingabe;
    private JTextField filmEingabe;
    private JTextField telNummerEingabe;
    
    private JTextField saalEingabe;
    private JTextField platzEingabe;
    private JTextField reiheEingabe;
    
    private JButton reservieren;
    
    public FensterFilm() {
        super("Kinobuchungssystem");
        
        setSize(1500,200);
        setLayout( new GridLayout(8,2) );
        hinzufuegen();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
    }
    
    private void hinzufuegen() {
        JLabel titel = new JLabel("Kinobuchungssystem");
        add(titel);
        add( new JLabel() );
        
        //Eingabe Name
        JLabel name = new JLabel("Name: ");
        add(name);
        nameEingabe = new JTextField();
        add(nameEingabe);
        
        //Eingabe Film
        JLabel film = new JLabel("Film: ");
        add(film);
        filmEingabe = new JTextField();
        add(filmEingabe);
        
        //Eingabe Telefonnummer
        JLabel telNummer = new JLabel("Telefonnummer: ");
        add(telNummer);
        telNummerEingabe = new JTextField();
        add(telNummerEingabe);
        
        //Eingabe Saal
        JLabel saal = new JLabel("Saal: ");
        add(saal);
        saalEingabe = new JTextField();
        add(saalEingabe);
        
        //Eingabe Platz
        JLabel platz = new JLabel("Platz: ");
        add(platz);
        platzEingabe = new JTextField();
        add(platzEingabe);
        
        //Eingabe Reihe
        JLabel reihe = new JLabel("Reihe: ");
        add(reihe);
        reiheEingabe = new JTextField();
        add(reiheEingabe);
        
        add( new JLabel() );
        reservieren = new JButton("Reservieren");
        reservieren.addActionListener(this);
        add(reservieren);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        Object verursacher = event.getSource();
        int i = 0;
        if (verursacher == reservieren) {
            if (nameEingabe.getText().length() == 0 ) {
                System.out.println("Bitte Namen eingeben!");
                i--;
            } 
            
            if (telNummerEingabe.getText().length() == 0 ) {
                System.out.println("Bitte Telefonnummer eingeben!");
                i--;
            } 
            
            if (platzEingabe.getText().length() == 0 ) {
                System.out.println("Bitte Platz eingeben!");
                i--;
            } 
            
            if (reiheEingabe.getText().length() == 0 ) {
                System.out.println("Bitte Reihe eingeben!");
                i--;
            } 
            
            if (saalEingabe.getText().length() == 0 ) {
                System.out.println("Bitte Saal eingeben!");
                i--;
            } 
            
            if (filmEingabe.getText().length() == 0 ) {
                System.out.println("Bitte Film eingeben!");
                i--;
            } 
            
            if (i == 0) {
                System.out.println("Reserviert!");
            } 
            
        }
    }
    
    public static void main(String[] args) {
        new Fenster();
    }
    
}
