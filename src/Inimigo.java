import java.util.Random;

public class Inimigo {
    private int iCoord;
    private int jCoord;
    private int saude;
    public Inimigo() {
        setRandomPos();
        saude = 100;
    }

    public void setRandomPos(){
        Random rand = new Random();
        this.iCoord = rand.ints(1, 11).findFirst().getAsInt();
        this.jCoord = rand.ints(1, 11).findFirst().getAsInt();
    }

    public void move(){
        Random rand = new Random();
        int i = getiCoord(), j = getjCoord();
        i += rand.ints(-1, 2).findFirst().getAsInt();
        j += rand.ints(-1, 2).findFirst().getAsInt();

        if(i == 0)
            i += 1;
        if(i == 11)
            i -= 1;
        if(j == 0)
            j += 1;
        if(j == 11)
            j -= 1;

        setiCoord(i);
        setjCoord(j);

    }

    public void getDano(){
        saude -= 10;
        if(saude < 0){
            saude = 0;
        }
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getSaude() {
        return saude;
    }

    public int getiCoord() {
        return iCoord;
    }
    public void setiCoord(int iCoord) {
        this.iCoord = iCoord;
    }

    public int getjCoord() {
        return jCoord;
    }

    public void setjCoord(int jCoord) {
        this.jCoord = jCoord;
    }
}
