
public class Besucher
{
    public int besucher_ID;
    public String name;
    public int telefon_nummer;
    /**
     * Konstruktor der Klasse Besucher
     */ 
    public Besucher(int besucher_ID, String name, int telefon_nummer){
        this.besucher_ID = besucher_ID;
        this.name = name;
        this.telefon_nummer = telefon_nummer;

    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie besucher_ID*/
    public int getBesucher_ID(){
        return this.besucher_ID;
    }//end method getBesucher_ID

    /**SET Method Propertie besucher_ID*/
    public void setBesucher_ID(int besucher_ID){
        this.besucher_ID = besucher_ID;
    }//end method setBesucher_ID

    /**GET Method Propertie name*/
    public String getName(){
        return this.name;
    }//end method getName

    /**SET Method Propertie name*/
    public void setName(String name){
        this.name = name;
    }//end method setName

    /**GET Method Propertie telefon_nummer*/
    public int getTelefon_nummer(){
        return this.telefon_nummer;
    }//end method getTelefon_nummer

    /**SET Method Propertie telefon_nummer*/
    public void setTelefon_nummer(int telefon_nummer){
        this.telefon_nummer = telefon_nummer;
    }//end method setTelefon_nummer

//End GetterSetterExtension Source Code


}//End class