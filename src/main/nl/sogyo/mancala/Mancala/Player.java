package nl.sogyo.mancala.Mancala;

public class Player {

    protected boolean turn=true;
    protected Boolean winner;

    public boolean getTurn(){
        return turn;
    }

    public Boolean getWinner(){
        return winner;
    }

    public void switchTurn() {
        turn=!turn;
    }

    public void isWinner() {
        winner=true;
    }

    public void isLoser(){
        winner=false;
    }

    public void Tie(){
        winner=null;
    }
}


