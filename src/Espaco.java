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

    public void updatePositions(Player player, Inimigo inim, int dano){
        inicializarEspaco();
        if(dano == 1){
            cenario[player.getiCoord()][player.getjCoord()] = "|X|";
        }else{
            cenario[player.getiCoord()][player.getjCoord()] = "|▲|";
        }

        if(dano == 2){
            cenario[inim.getiCoord()][inim.getjCoord()] = "|X|";
        }else{
            cenario[inim.getiCoord()][inim.getjCoord()] = "|⧫|";
        }
    }

    public void imprimeCenario(Player player, Inimigo inim, int dano){
        updatePositions(player, inim, dano);
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        
        String HUD[] = {"       W","       ↑" ,"  A ←     → D" ,"       ↓" ,"       S", "","  E - Atirar","  ▲ - Player -> vidas = "+player.getVidas(), "  ⧫ - Inimigo -> saúde = "+inim.getSaude()+"%"};
        int cont = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf("%s ", cenario[i][j]);
                if(j == 10 && i >= 1 && i <= 9){
                    System.out.printf("\t%s", HUD[cont]);
                    cont += 1;
                }
            }
            System.out.printf("\n");
        }
    }

    public void gameOverScreen(Player player, Inimigo inimigo){
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        if(inimigo.getSaude() == 0){
            System.out.println("Você venceu!");
        }else{
            System.out.println("Você perdeu!");
        }
    }
}
