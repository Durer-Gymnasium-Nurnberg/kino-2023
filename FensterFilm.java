import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
    /**
     * Konstruktor der Klasse FensterFilm
     */

public class FensterFilm extends JFrame implements ActionListener {
    private JTextField nameEingabe;
    private JTextField laengeEingabe;
    private JTextField fskEingabe;

    private JTextField jahrEingabe;
    //private JTextField inhaltEingabe;

    private JButton reservieren;
    
    public FensterFilm() {  
        super("Filme einfügen");

        setSize(300,500);
        setLayout( new GridLayout(8,2) );
        hinzufuegen();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
        
    }

    private void hinzufuegen() {
        JLabel titel = new JLabel("Filme einfügen");
        add(titel);
        add( new JLabel() );

        //Eingabe Name
        JLabel name = new JLabel("Name: ");
        add(name);
        nameEingabe = new JTextField();
        add(nameEingabe);

        //Eingabe Film
        JLabel laenge = new JLabel("Länge: ");
        add(laenge);
        laengeEingabe = new JTextField();
        add(laengeEingabe);

        //Eingabe Fsk
        JLabel fsk = new JLabel("FSK: ");
        add(fsk);
        fskEingabe = new JTextField();
        add(fskEingabe);

        //Eingabe Jahr
        JLabel jahr = new JLabel("Jahr: ");
        add(jahr);
        jahrEingabe = new JTextField();
        add(jahrEingabe);

        /*Eingabe Inhalt
        JLabel inhalt = new JLabel("Inhalt: ");
        add(inhalt);
        inhaltEingabe = new JTextField();
        add(inhaltEingabe);
         */

        add( new JLabel() );
        reservieren = new JButton("einfügen");
        reservieren.addActionListener(this);
        add(reservieren);

    }

    public void actionPerformed(ActionEvent event) {
        Object verursacher = event.getSource();
        int i = 0;
        if (verursacher == reservieren) {
            String name = nameEingabe.getText(); 
            int fsk = 0;
            int jahr = 0;
            int laenge = 0;

            if (name.length() == 0 ) {
                System.out.println("Bitte Namen eingeben!");
                i--;
            } 

            if (fskEingabe.getText().length() == 0) {
                System.out.println("Bitte FSK eingeben!");
                i--;
            } else {
                fsk = Integer.parseInt( fskEingabe.getText() ) ;
            }

            /*
            if (inhaltEingabe.getText().length() == 0 ) {
            System.out.println("Bitte Inhalt einfügen!");
            i--;
            } 
             */
            if (jahrEingabe.getText().length() == 0 ) {
                System.out.println("Bitte Jahr eingeben!");
                i--;
            } else {
                jahr = Integer.parseInt( jahrEingabe.getText() ) ;
            }

            if (laengeEingabe.getText().length() == 0 ) {
                System.out.println("Bitte Länge eingeben!");
                i--;
            } else {
                laenge = Integer.parseInt( laengeEingabe.getText() ) ;
            }

            if (i == 0) {
                try {
                    Datenbankanbindung.filmEintragen(name, jahr, laenge, fsk);                    
                } catch(SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQLException: " + e.getMessage());
                    System.out.println("SQLState: " + e.getSQLState());
                    System.out.println("VendorError: " + e.getErrorCode());
                    //System.out.println("Film konnte nicht eingefügt werden!");
                }
                System.out.println("Film eingefügt!");
            } 

        }
    }

    public static void main(String[] args) {
        new FensterFilm();
    }

}
