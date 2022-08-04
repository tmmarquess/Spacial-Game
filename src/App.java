import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random rand = new Random();
        Espaco cenario = new Espaco();
        Nave player = new Nave("G5");
        Inimigo inim = new Inimigo(""+rand.nextInt(10)+""+rand.nextInt(10));

        cenario.updatePositions(player, inim);

        cenario.imprimeCenario();
    }
}
