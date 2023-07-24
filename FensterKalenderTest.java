import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.JComponent;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.util.Vector;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;
import com.toedter.calendar.JCalendar;

public class FensterKalenderTest extends JFrame implements ActionListener, ItemListener, ChangeListener {
    private JPanel pan1, pan2, pan3, pan4;   
    private GridBagConstraints c;
    
    private JComboBox filmAuswahl;
    private JCalendar kalender;
    private JSpinner stunde, minute, datumZeit;
    private JButton einfuegen;
        
    public FensterKalenderTest() {
        super("Vorstellungen eintragen");
        
        setSize(425,375); // Breite, Höhe
        //setLayout( new GridLayout(3,1));
        setLayout( new GridBagLayout() );
        c = new GridBagConstraints();
        
        hinzufuegen();
        
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0,0,10,0); //Insets​(int top, int left, int bottom, int right)
        c.gridx=0;
        c.gridy=0;
        add(pan1, c);
        
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0,0,10,0);
        //c.weighty = 0.5;
        c.gridx=0;
        c.gridy=1;
        add(pan2, c);
        
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_START;
        //c.weighty = 0.5;
        c.gridx=0;
        c.gridy=2;
        add(pan3, c);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);        
    }
    
    private void hinzufuegen() {
        pan1 = new JPanel();
        pan1.setLayout( new GridLayout(1,2) ); 
        
        Vector<Film> filmListe = null;
        try {
             //filmListe = (Vector<Film>) Datenbankanbindung.getFilme();
            filmListe = new Vector <>(Datenbankanbindung.getFilme());           
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("Filme konnten aus der DB gelesen werden!");
        }
        
        JLabel film = new JLabel("Film");
        pan1.add(film);
        JComboBox filmAuswahl = new JComboBox<Film>(filmListe);
        filmAuswahl.addItemListener(this);
        pan1.add(filmAuswahl);
        
        pan2 = new JPanel();
        pan2.setLayout( new GridLayout(1,2) );
        JLabel datum = new JLabel("Vorstellung am");
        pan2.add(datum);
        kalender = new JCalendar();
        pan2.add(kalender);
        
        //https://docs.oracle.com/javase/tutorial/uiswing/components/spinner.html
        //https://www.straub.as/java/swing/JSpinner.html
        //https://www.java-tutorial.org/jspinner.html
        int currentHour = 15;
        SpinnerNumberModel modelStunde = new SpinnerNumberModel(currentHour, 0, 23, 1);//initial value, min, max, step
        int currentMinute = 0;
        SpinnerNumberModel modelMinute = new SpinnerNumberModel(currentMinute, 0, 60, 1);                       
                
        pan3 = new JPanel(); 
        pan3.setLayout( new GridLayout(3,2) );
        
        JLabel zeit = new JLabel("um");
        pan3.add(zeit);
        
        pan4 = new JPanel();
        pan4.setLayout( new GridLayout(1,3 ));
        
        stunde = new JSpinner(modelStunde);
        stunde.addChangeListener(this);
        pan4.add(stunde);
        JLabel doppelpunkt = new JLabel(":");
        doppelpunkt.setHorizontalAlignment(SwingConstants.CENTER);
        pan4.add(doppelpunkt);
        minute = new JSpinner(modelMinute);
        minute.setEditor(new JSpinner.NumberEditor(minute, "00"));  //Pattern z. B. "#.0# cm"
        minute.addChangeListener(this);
        pan4.add(minute);
        
        pan3.add(pan4);
                
        JLabel alt = new JLabel("alternativ");
        pan3.add(alt);
        datumZeit = new JSpinner( new SpinnerDateModel() );
        datumZeit.addChangeListener(this);
        pan3.add(datumZeit); 
        
        pan3.add( new JLabel() );
        einfuegen = new JButton("Einfügen");
        einfuegen.addActionListener(this);
        pan3.add(einfuegen);   
                
        pan1.setVisible(true);
        pan2.setVisible(false); 
        pan3.setVisible(false);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        Object verursacher = event.getSource();
        
        if (verursacher == einfuegen) {
            
            
        }
        
    }
    
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        
        if (e.getStateChange() == ItemEvent.SELECTED) {
            Film f = (Film) e.getItem();
            //ruft die toString()-Methode von Film auf:
            //System.out.println(f);
            
            pan2.setVisible(true);
            pan3.setVisible(true);
            validate();
            repaint();
        }
    }
    
    public void stateChanged(ChangeEvent e) {
        Object source = e.getSource();
        
        if (source == datumZeit) {
            Date dateDZ = (Date) datumZeit.getValue();
            //https://www.benchresources.net/java-8-how-to-convert-date-to-gregoriancalendar-and-vice-versa/?utm_content=cmp-true
            GregorianCalendar dZ = new GregorianCalendar();
            dZ.setTime(dateDZ);
            
                        
            String[] wochentage = {"So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"};
            int nrWochentag = dZ.get(Calendar.DAY_OF_WEEK);
            int day = dZ.get(Calendar.DAY_OF_MONTH);
            int month = dZ.get(Calendar.MONTH);
            int jahr = dZ.get(Calendar.YEAR);
            int hour = dZ.get(Calendar.HOUR_OF_DAY);
            int minute = dZ.get(Calendar.MINUTE);
            
            System.out.println(wochentage[nrWochentag-1] + " " + day + "." + (month+1) + "." + jahr + " " + hour + ":" + minute);
        }
        
        if (source == stunde) {
            JSpinner spinner = (JSpinner) e.getSource();
            SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
            int value = (Integer) model.getValue();   
                      
            System.out.println("Stunde: " + value);
            
        }
        
        if (source == minute) {
            JSpinner spinner = (JSpinner) e.getSource();
            SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
            int value = (Integer) model.getValue();   
            
            System.out.println("Minute: " + value);
            
        }
        
    }
    
    public static void main(String[] args) {
        new FensterKalenderTest();
    }
    
}
