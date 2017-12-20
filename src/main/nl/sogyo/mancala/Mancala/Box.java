package nl.sogyo.mancala.Mancala;

public abstract class Box {
    protected int stones = 4;
    protected Player player;
    protected Box neighbour;

    public Box() {
    }

    public Box getNeighbour() {
        return neighbour;
    }

    public Box HelperInit(int nrbox) {
        nrbox--;
        if (nrbox == 0) {
            return neighbour;
        } else {
            return neighbour.HelperInit(nrbox);
        }
    }


    public Box getKalaha() {
        if (neighbour instanceof Kalaha) {
            return neighbour;
        } else {
            return neighbour.getKalaha();

        }

    }

    public Box getAcrossNeighbour() {
        int counter = 0;
        counter++;
        if (neighbour instanceof Kalaha) {
            return neighbour.HelperInit(counter + 2);
        } else {
            return neighbour.getAcrossNeighbour();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

    public int getStones() {
        return stones;

    }

    public void receiveStones(int sentStones,Player playerSendingBox) {
        stones++;
        if (sentStones == 0&& this instanceof Kalaha) {
            this.player.switchTurn();
            stones--;
        }else if(sentStones==0){
            stones--;
        } else if (!(this instanceof Kalaha)&&getAcrossNeighbour().getStones() > 0&&stones==1) {
            neighbour.getKalaha().setStones(getAcrossNeighbour().getStones() + neighbour.getKalaha().getStones() + 1);
        } else if (this instanceof Kalaha&&this.player!=playerSendingBox) {
            neighbour.receiveStones(sentStones, playerSendingBox);
            stones--;
        } else {
            neighbour.receiveStones(sentStones - 1,playerSendingBox);

        }
    }

    public void checkWinner() {
        if (getKalaha().getStones() > getAcrossNeighbour().getKalaha().getStones()) {
            getPlayer().isWinner();
            getAcrossNeighbour().getPlayer().isLoser();
        } else if (getKalaha().getStones() == getAcrossNeighbour().getKalaha().getStones()) {
            getPlayer().Tie();
            getAcrossNeighbour().getPlayer().Tie();
        }else{
            getPlayer().isLoser();
            getAcrossNeighbour().getPlayer().isWinner();
        }
    }

    public boolean checkOpponentBoxesEmpty(Player playerOfBoxDoingMove) {
        return false;
    }

    public int takeAllMyStones(){
        return 0;
    }

    public void emptyAllOpponentBoxes(Player player){
    }

    public void takeAllMyStones(Player aPlayer) {
    }

    public void emptyAllMyBoxes(Player aPlayer) {
    }
}
