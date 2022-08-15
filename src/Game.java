import java.util.Scanner;

public class Game {
    Player player;
    Inimigo inimigo;
    Espaco tela;
    Scanner leitor;
    boolean gameOver;

    public Game(String posPlayer){
        player = new Player(posPlayer);
        inimigo = new Inimigo();
        tela  = new Espaco();
        this.leitor = new Scanner(System.in);
        gameOver = false;

        tela.updatePositions(player, inimigo, 0);
    }

    public void gameLoop(){
        while(! gameOver){
            getColisao(player, inimigo);
            tela.imprimeCenario(player, inimigo, 0);
            checkGameOver(player, inimigo);
            if(! gameOver){
                String move;
                do{
                    move = leitor.nextLine();
                    move = move.toUpperCase();
                }while(!move.matches("^[AWSDE]$"));
                if(move.equals("E")){
                    playerShoot(player, inimigo);
                }else{
                    player.moveNave(move);
                }
                inimigo.move();
            }
        }
        tela.gameOverScreen(player, inimigo);
    }

    private void playerShoot(Player player, Inimigo inim){
        if(player.getjCoord() == inim.getjCoord()){
            if(player.getiCoord() > inim.getiCoord()){
                inimigo.getDano();                
                tela.imprimeCenario(player, inim, 2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                inim.setRandomPos();
            }
        }
    }

    private void getColisao(Player player, Inimigo inim){
        if(player.getjCoord() == inim.getjCoord()){
            if(player.getiCoord() == inim.getiCoord()){
                player.getDano();
                inim.setRandomPos();
                tela.imprimeCenario(player, inim, 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkGameOver(Player player, Inimigo inim){
        if(player.getVidas() == 0 || inim.getSaude() == 0){
            gameOver = true;
        }
    }
}