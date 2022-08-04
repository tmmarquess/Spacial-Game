public class Espaco {
    private String cenario[][];
    private String letras[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public Espaco() {
        this.cenario = new String[11][11];
        inicializarEspaco();
    }

    private void inicializarEspaco(){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(i == 0){
                    if(j == 0){
                        this.cenario[i][j] = " ";
                    }else{
                        this.cenario[i][j] = " " + (j-1) + " ";
                    }
                    
                }else{
                    if(j == 0){
                        this.cenario[i][j] = letras[i - 1];
                    }else{
                        this.cenario[i][j] =  "| |";
                    }
                }
            }
        }
    }

    private int getLetterIndex(char letter){
        String letras = "ABCDEFGHIJ";
        return letras.indexOf(letter);
    }

    public void updatePositions(Nave player, Inimigo enemy){
        inicializarEspaco();
        int i = getLetterIndex(player.coords.charAt(0)) + 1;
        int j = Integer.parseInt(player.coords.substring(1)) + 1;
        cenario[i][j] = "|^|";

        i = Integer.parseInt(enemy.coords.substring(0,1)) + 1;
        j = Integer.parseInt(enemy.coords.substring(1));
        cenario[i][j] = "|@|";
    }

    private void limpaConsole() {
        try {
            final String os = System.getProperty("o, js.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
        }
    }

    public void imprimeCenario(){
        limpaConsole();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf("%s ", cenario[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
