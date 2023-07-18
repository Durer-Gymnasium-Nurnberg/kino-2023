
public class Kinosaal
{
    public int kinoSaalID;
    /**
     * Konstruktor der Klasse Kinosaal
     */
    public Kinosaal(int kinoSaalID)
    {
        this.kinoSaalID = kinoSaalID;
    }

    /**GET Method Propertie kinoSaalID*/
    public int getKinoSaalID(){
        return this.kinoSaalID;
    }//end method getKinoSaalID

    /**SET Method Propertie kinoSaalID*/
    public void setKinoSaalID(int kinoSaalID){
        this.kinoSaalID = kinoSaalID;
    }//end method setKinoSaalID


}