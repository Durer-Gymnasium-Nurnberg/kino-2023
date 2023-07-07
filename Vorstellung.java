import java.util.GregorianCalendar;


public class Vorstellung
{
    public int vorstellungID;
    public GregorianCalendar datumZeit;
    public int filmID;
    public int kinoSaalID;
    public int jahr;
    public int monat;
    public int tag;
    public int stunde;
    public int minute;
    
    
    public Vorstellung(int vorstellungID,GregorianCalendar datumZeit, int jahr,int monat, int tag, int stunde, int minute, int filmID, int kinoSaalID)
    {
        
        this.vorstellungID = vorstellungID;
        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;
        this.stunde = stunde;
        this.minute = minute;
        
        this.datumZeit = new GregorianCalendar(jahr, monat, tag, stunde, minute);
        
        
    }


//Start GetterSetterExtension Source Code

    /**GET Method Propertie vorstellungID*/
    public int getVorstellungID(){
        return this.vorstellungID;
    }//end method getVorstellungID

    /**SET Method Propertie vorstellungID*/
    public void setVorstellungID(int vorstellungID){
        this.vorstellungID = vorstellungID;
    }//end method setVorstellungID

    /**GET Method Propertie datumZeit*/
    public GregorianCalendar getDatumZeit(){
        return this.datumZeit;
    }//end method getDatumZeit

    /**SET Method Propertie datumZeit*/
    public void setDatumZeit(GregorianCalendar datumZeit){
        this.datumZeit = datumZeit;
    }//end method setDatumZeit

    /**GET Method Propertie filmID*/
    public int getFilmID(){
        return this.filmID;
    }//end method getFilmID

    /**SET Method Propertie filmID*/
    public void setFilmID(int filmID){
        this.filmID = filmID;
    }//end method setFilmID

    /**GET Method Propertie kinoSaalID*/
    public int getKinoSaalID(){
        return this.kinoSaalID;
    }//end method getKinoSaalID

    /**SET Method Propertie kinoSaalID*/
    public void setKinoSaalID(int kinoSaalID){
        this.kinoSaalID = kinoSaalID;
    }//end method setKinoSaalID

    /**GET Method Propertie jahr*/
    public int getJahr(){
        return this.jahr;
    }//end method getJahr

    /**SET Method Propertie jahr*/
    public void setJahr(int jahr){
        this.jahr = jahr;
    }//end method setJahr

    /**GET Method Propertie monat*/
    public int getMonat(){
        return this.monat;
    }//end method getMonat

    /**SET Method Propertie monat*/
    public void setMonat(int monat){
        this.monat = monat;
    }//end method setMonat

    /**GET Method Propertie tag*/
    public int getTag(){
        return this.tag;
    }//end method getTag

    /**SET Method Propertie tag*/
    public void setTag(int tag){
        this.tag = tag;
    }//end method setTag

    /**GET Method Propertie stunde*/
    public int getStunde(){
        return this.stunde;
    }//end method getStunde

    /**SET Method Propertie stunde*/
    public void setStunde(int stunde){
        this.stunde = stunde;
    }//end method setStunde

    /**GET Method Propertie minute*/
    public int getMinute(){
        return this.minute;
    }//end method getMinute

    /**SET Method Propertie minute*/
    public void setMinute(int minute){
        this.minute = minute;
    }//end method setMinute

//End GetterSetterExtension Source Code


}//End class