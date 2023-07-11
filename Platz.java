
public class Platz
{
    public int platz_ID;
    public char reihe;
    public int platz;
    public int kinosaal_ID_Kinosaal;
    public Platz(int platz_ID, char reihe, int platz, int kinosaal_ID_Kinosaal)
    {
        this.platz_ID = platz_ID;
        this.reihe = reihe;
        this.platz = platz;
        this.kinosaal_ID_Kinosaal = kinosaal_ID_Kinosaal;
    }


//Start GetterSetterExtension Source Code

    /**GET Method Propertie platz_ID*/
    public int getPlatz_ID(){
        return this.platz_ID;
    }//end method getPlatz_ID

    /**SET Method Propertie platz_ID*/
    public void setPlatz_ID(int platz_ID){
        this.platz_ID = platz_ID;
    }//end method setPlatz_ID

    /**GET Method Propertie reihe*/
    public char getReihe(){
        return this.reihe;
    }//end method getReihe

    /**SET Method Propertie reihe*/
    public void setReihe(char reihe){
        this.reihe = reihe;
    }//end method setReihe

    /**GET Method Propertie platz*/
    public int getPlatz(){
        return this.platz;
    }//end method getPlatz

    /**SET Method Propertie platz*/
    public void setPlatz(int platz){
        this.platz = platz;
    }//end method setPlatz

    /**GET Method Propertie kinosaal_ID_Kinosaal*/
    public int getKinosaal_ID_Kinosaal(){
        return this.kinosaal_ID_Kinosaal;
    }//end method getKinosaal_ID_Kinosaal

    /**SET Method Propertie kinosaal_ID_Kinosaal*/
    public void setKinosaal_ID_Kinosaal(int kinosaal_ID_Kinosaal){
        this.kinosaal_ID_Kinosaal = kinosaal_ID_Kinosaal;
    }//end method setKinosaal_ID_Kinosaal

//End GetterSetterExtension Source Code


}//End class