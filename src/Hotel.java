
import java.util.Random;

public class Hotel{



    public Hotel(String name, int zimmerAnzahl, String hotelanbieterName){
        this.name=name;
        this.zimmerAnzahl=zimmerAnzahl;
        this.hotelanbieterName=hotelanbieterName;

    }

    String name;
    int zimmerAnzahl;
    String hotelanbieterName;
    Random rand = new Random();
    int  Zimmer = rand.nextInt(2);

    public boolean istVerfuegbar(){

        if(Zimmer==0){
            return false;
        } else if (Zimmer > 0) {
            return true;
        }
        else throw new ArithmeticException();

    }

}



