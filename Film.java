
public class Film
{
    public int filmID;
    public String name;
    public int jahr;
    public int laenge;
    public int fsk;
    
    
    public Film(int filmID, String name, int jahr,int laenge,int fsk)
    {
        this.filmID = filmID;
        this.jahr = jahr;
        this.laenge = laenge;
        this.fsk = fsk;
    }
    
    public int getFilmID(){
        return filmID;
    
    }
    
    public void setFilmID(int filmID){
        this.filmID = filmID;
    }
    
    public String getName(){
        return name;
    
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getJahr(){
        return jahr;
    
    }
    
    public void setJahr(int jahr){
        this.jahr = jahr;
    }

    public int getlaenge(){
        return laenge;
    
    }
    
    public void setLaenge(int laenge){
        this.laenge = laenge;
    }
    
    public int getFsk(){
        return fsk;
    
    }
    
    public void setFsk(int fsk){
        this.fsk = fsk;
    }
}
