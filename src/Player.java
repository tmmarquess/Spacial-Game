public class Player {
    private int iCoord;
    private int jCoord;
    private int vidas;

    public Player(String coords){
        int i, j;
        if(coords.length() == 3){
            i = Integer.parseInt(coords.substring(0,2));
            j = Integer.parseInt(coords.substring(2));
            if(i > 10){
                i = Integer.parseInt(coords.substring(0,1));
                j = Integer.parseInt(coords.substring(1, 3));
            }
        }else{
            if(coords.length() == 4){
                i = Integer.parseInt(coords.substring(0,2));
                j = Integer.parseInt(coords.substring(2));
            }else{
                i = Integer.parseInt(coords.substring(0,1));
                j = Integer.parseInt(coords.substring(1));
            }
        }
        this.iCoord = i;
        this.jCoord = j;
        vidas = 3;
    }

    public void setiCoord(int iCoord) {
        this.iCoord = iCoord;
    }
    public int getVidas() {
        return vidas;
    }

    public void setjCoord(int jCoord) {
        this.jCoord = jCoord;
    }

    public int getiCoord() {
        return iCoord;
    }

    public int getjCoord() {
        return jCoord;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void getDano(){
        vidas -= 1;
        if(vidas < 0){
            vidas = 0;
        }
    }

    public void moveNave(String move) {
        int i = this.iCoord;
        int j = this.jCoord;
        switch (move) {
            case "W":
                i -= 1;
                break;
            case "A":
                j -= 1;
                break;
            case "S":
                i += 1;
                break;
            case "D":
                j += 1;
                break;
            }
        if(i == 0)
            i += 1;
        if(i == 11)
            i -= 1;

        if(j == 0)
            j += 1;
        if(j == 11)
            j -= 1;

        iCoord = i;
        jCoord = j;
    }
}
