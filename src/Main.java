import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        String posicoes = 
        """
            
           0   1   2   3   4   5   6   7   8   9  
        A | | | | | | | | | | | | | | | | | | | | 
        B | | | | | | | | | | | | | | | | | | | | 
        C | | | | | | | | | | | | | | | | | | | |
        D | | | | | | | | | | | | | | | | | | | |
        E | | | | | | | | | | | | | | | | | | | |
        F | | | | | | | | | | | | | | | | | | | |
        G | | | | | | | | | | | | | | | | | | | |
        H | | | | | | | | | | | | | | | | | | | | 
        I | | | | | | | | | | | | | | | | | | | | 
        J | | | | | | | | | | | | | | | | | | | |
        """;
        System.out.println(posicoes);

        String pos;
        do{
            pos = JOptionPane.showInputDialog("Escolha a posição da nave (Linha-Coluna): ");
        }while(!pos.matches("^[a-jA-J][0-9]$"));

        Game jogo = new Game(Coords.convertCoord(pos));
        jogo.gameLoop();
    }
}
