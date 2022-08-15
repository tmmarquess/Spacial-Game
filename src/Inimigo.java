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

        if(i == 1){
            i += rand.ints(0, 2).findFirst().getAsInt();
        }else{
            if(i == 10){
                i += rand.ints(-1, 1).findFirst().getAsInt();
            }else{
                i += rand.ints(-1, 2).findFirst().getAsInt();
            }
        }

        if(j == 1){
            j += rand.ints(0, 2).findFirst().getAsInt();
        }else{
            if(j == 10){
                j += rand.ints(-1, 1).findFirst().getAsInt();
            }else{
                j += rand.ints(-1, 2).findFirst().getAsInt();
            }
        }

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
