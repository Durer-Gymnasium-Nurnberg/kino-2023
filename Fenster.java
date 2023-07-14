import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.util.Vector;
import javax.swing.JPanel;
import java.util.List;
import java.sql.SQLException;

public class Fenster extends JFrame implements ActionListener {
    private JTextField nameEingabe;
    private JButton reservieren;

    private JButton bestätigenF;
    private JButton bestätigenV;
    private JButton bestätigenS;
    private JComboBox<Film> filmAuswahl;
    private JComboBox vorstellungsAuswahl;
    private JComboBox sitzplatzAuswahl;
    JFrame jcbJFrameF = new JFrame();
    JFrame jcbJFrameV = new JFrame();
    JFrame jcbJFrameS = new JFrame();
    private String wahlFilm;
    private Vector wahlVorstellung;
    private String wahlSitz;
    
       
    public Fenster() {
        
    }

    public void actionPerformed(ActionEvent event) {
        Object verursacher = event.getSource();
        if (verursacher == bestätigenF)
        {
            jcbJFrameF.setVisible(false);
            vorstellungAuswahl();
        }
        if (verursacher == bestätigenV)
        {
            jcbJFrameV.setVisible(false);
            sitzplatzAuswahl();
        }
        if (verursacher == bestätigenS)
        {
            jcbJFrameS.setVisible(false);
        }
        if (verursacher == filmAuswahl)
        {
            JComboBox cbf = (JComboBox)event.getSource();
            wahlFilm = (String)cbf.getSelectedItem();
        }
        if (verursacher == vorstellungsAuswahl)
        {
            JComboBox cbv = (JComboBox)event.getSource();
            wahlVorstellung = (Vector)cbv.getSelectedItem();
        }
        if (verursacher == sitzplatzAuswahl)
        {
            JComboBox cbs = (JComboBox)event.getSource();
            wahlSitz = (String)cbs.getSelectedItem();
        }
    }

    public void filmAuswahl()
    {
        jcbJFrameF.setTitle("JComboBox Beispiel");
        jcbJFrameF.setSize(250, 250);
        JPanel panel = new JPanel();

        JLabel name = new JLabel("Filmauswahl");
        panel.add(name);
        // String comboBoxListe[] = {"Thor", "Thor9", "Leos privateste Momente"};
        String comboBoxListe[] = {};

        //Datenbankanbindung.getFilme()
        //filmAuswahl = new JComboBox(comboBoxListe);
        
        Vector<Film> filmListe = null;
        try {
            filmListe = (Vector<Film>) Datenbankanbindung.getFilme();
            
            //Ausgabe, ob etwas im Vector drin ist
            for(Film f : filmListe) {
                System.out.println(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Filme konnten aus der DB gelesen werden!");
        }
        filmAuswahl = new JComboBox<Film>(filmListe);
        filmAuswahl.addActionListener(this);
        panel.add(filmAuswahl);

        add( new JLabel() );
        bestätigenF = new JButton("Bestätigen");
        bestätigenF.addActionListener(this);
        panel.add(bestätigenF);

        jcbJFrameF.add(panel);
        jcbJFrameF.setVisible(true);
    }

    public void vorstellungAuswahl()
    {
        jcbJFrameV.setTitle("Vorstellunsauswahl");
        jcbJFrameV.setSize(250, 250);
        JPanel panel = new JPanel();

        JLabel frage = new JLabel("Vorstellungsauswahl");
        panel.add(frage);

        Vector comboBoxListe[] = {};

        vorstellungsAuswahl = new JComboBox(comboBoxListe);
        vorstellungsAuswahl.addActionListener(this);
        panel.add(vorstellungsAuswahl);

        add( new JLabel() );
        bestätigenV = new JButton("Bestätigen");
        bestätigenV.addActionListener(this);
        panel.add(bestätigenV);

        jcbJFrameV.add(panel);
        jcbJFrameV.setVisible(true);
    }

    public void sitzplatzAuswahl()
    {
        jcbJFrameS.setTitle("Sitzplatzwahl");
        jcbJFrameS.setSize(250, 250);
        JPanel panel = new JPanel();

        JLabel frage = new JLabel("Sitzplatzwahl");
        panel.add(frage);

        String comboBoxListe[] = {"12","69"};

        sitzplatzAuswahl = new JComboBox(comboBoxListe);
        sitzplatzAuswahl.addActionListener(this);
        panel.add(sitzplatzAuswahl);

        add( new JLabel() );
        bestätigenS = new JButton("Bestätigen");
        bestätigenS.addActionListener(this);
        panel.add(bestätigenS);

        jcbJFrameS.add(panel);
        jcbJFrameS.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Fenster();
    }

}
