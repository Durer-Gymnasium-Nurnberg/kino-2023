
public class Reservierung
{
    int reservierung_ID;
    int vorstellung_ID_Vorstellung;
    int besucher_ID_Besucher;
    int platz_ID_Platz;
    public Reservierung(int reservierung_ID, int vorstellung_ID_Vorstellung, int besucher_ID_Besucher, int platz_ID_Platz)
    {
        this.reservierung_ID = reservierung_ID;
        this.vorstellung_ID_Vorstellung = vorstellung_ID_Vorstellung;
        this.besucher_ID_Besucher = besucher_ID_Besucher;
        this.platz_ID_Platz = platz_ID_Platz;
    }


//Start GetterSetterExtension Source Code

    /**GET Method Propertie reservierung_ID*/
    public int getReservierung_ID(){
        return this.reservierung_ID;
    }//end method getReservierung_ID

    /**SET Method Propertie reservierung_ID*/
    public void setReservierung_ID(int reservierung_ID){
        this.reservierung_ID = reservierung_ID;
    }//end method setReservierung_ID

    /**GET Method Propertie vorstellung_ID_Vorstellung*/
    public int getVorstellung_ID_Vorstellung(){
        return this.vorstellung_ID_Vorstellung;
    }//end method getVorstellung_ID_Vorstellung

    /**SET Method Propertie vorstellung_ID_Vorstellung*/
    public void setVorstellung_ID_Vorstellung(int vorstellung_ID_Vorstellung){
        this.vorstellung_ID_Vorstellung = vorstellung_ID_Vorstellung;
    }//end method setVorstellung_ID_Vorstellung

    /**GET Method Propertie besucher_ID_Besucher*/
    public int getBesucher_ID_Besucher(){
        return this.besucher_ID_Besucher;
    }//end method getBesucher_ID_Besucher

    /**SET Method Propertie besucher_ID_Besucher*/
    public void setBesucher_ID_Besucher(int besucher_ID_Besucher){
        this.besucher_ID_Besucher = besucher_ID_Besucher;
    }//end method setBesucher_ID_Besucher

    /**GET Method Propertie platz_ID_Platz*/
    public int getPlatz_ID_Platz(){
        return this.platz_ID_Platz;
    }//end method getPlatz_ID_Platz

    /**SET Method Propertie platz_ID_Platz*/
    public void setPlatz_ID_Platz(int platz_ID_Platz){
        this.platz_ID_Platz = platz_ID_Platz;
    }//end method setPlatz_ID_Platz

//End GetterSetterExtension Source Code


}//End class