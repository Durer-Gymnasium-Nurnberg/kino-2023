import java.util.GregorianCalendar;

public class Vorstellung
{
    private int vorstellungID;
    private int filmID;
    private int kinoSaalID;
    private GregorianCalendar datumZeit;
    
    /**
     * Konstruktor der Klasse Vorstellung
     */
    
    public Vorstellung(int vorstellungID, GregorianCalendar datumZeit, int filmID, int kinoSaalID)
    {
        this.vorstellungID = vorstellungID;
        this.filmID = filmID;
        this.kinoSaalID = kinoSaalID;
        this.datumZeit = datumZeit;        
    }

    public int getVorstellungID(){
        return this.vorstellungID;
    }
    
    public void setVorstellungID(int vorstellungID){
        this.vorstellungID = vorstellungID;
    }
    
    // Make sure the dateTime is not mutated
    public final GregorianCalendar getDatumZeit(){
        return this.datumZeit;
    }
    
    public void setDatumZeit(GregorianCalendar datumZeit){
        this.datumZeit = datumZeit;
    }

    public int getFilmID(){
        return this.filmID;
    }

    public void setFilmID(int filmID){
        this.filmID = filmID;
    }

    public int getKinoSaalID(){
        return this.kinoSaalID;
    }

    public void setKinoSaalID(int kinoSaalID){
        this.kinoSaalID = kinoSaalID;
    }
}