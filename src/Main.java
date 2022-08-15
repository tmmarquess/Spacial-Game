import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        Espaco espaco = new Espaco();
        espaco.imprimeEspaco();
        String pos;
        do{
            pos = JOptionPane.showInputDialog("Escolha a posição da nave (Linha-Coluna): ");
        }while(!pos.matches("^[a-jA-J][0-9]$"));

        Game jogo = new Game(Coords.convertCoord(pos));
        jogo.gameLoop();
    }
}

