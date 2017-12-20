package nl.sogyo.mancala.Mancala;

public class SmallBox extends Box {


	public SmallBox(){
		player=new Player();
		int numberBeginInit=0;
		neighbour=new SmallBox(player,this,numberBeginInit);
	}

    public SmallBox(Player player,SmallBox firstBox, int numberBeginInit) {
		this.player=player;
		numberBeginInit++;
		if(numberBeginInit==5||numberBeginInit==12) {
				neighbour = new Kalaha(player, firstBox, numberBeginInit);
			}else{
				neighbour=new SmallBox(player,firstBox,numberBeginInit);
			}
	}

	public Box HelperInit(int nrbox) {
		nrbox--;
		if (nrbox == 0) {
			return neighbour;
		} else {
			return neighbour.HelperInit(nrbox);
		}
	}

	public boolean checkOpponentBoxesEmpty(Player playerOfBoxDoingMove) {
		if (neighbour instanceof Kalaha&&this.player!=playerOfBoxDoingMove&&this.getStones()==0) {
			return true;
		}else if(this.player!=playerOfBoxDoingMove&&this.getStones()==0){
			return neighbour.checkOpponentBoxesEmpty(playerOfBoxDoingMove);
		}else if(this.player==playerOfBoxDoingMove){
			return getKalaha().neighbour.checkOpponentBoxesEmpty(playerOfBoxDoingMove);
		}else{
			return false;
		}
	}

	public void emptyAllOpponentBoxes(Player playerOfBoxDoingMove){
		if(neighbour instanceof Kalaha&&this.player!=playerOfBoxDoingMove){
			this.setStones(0);
		}else if(this.player==playerOfBoxDoingMove){
			getKalaha().neighbour.emptyAllOpponentBoxes(playerOfBoxDoingMove);
		}else{
			this.setStones(0);
			neighbour.emptyAllOpponentBoxes(playerOfBoxDoingMove);
		}

	}

	public void emptyAllMyBoxes(Player playerOfBoxDoingMove){
		if(neighbour instanceof Kalaha &&this.player==playerOfBoxDoingMove){
			setStones(0);
		}else{
			setStones(0);
			neighbour.emptyAllMyBoxes(playerOfBoxDoingMove);
		}

	}

	public void takeAllMyStones(Player playerOfBoxDoingMove){
		if(neighbour instanceof Kalaha&&this.player==playerOfBoxDoingMove){
			neighbour.setStones(neighbour.getStones()+this.getStones());
		}else if(this.player==playerOfBoxDoingMove){
			this.getKalaha().setStones(this.getKalaha().getStones()+this.getStones());
			neighbour.takeAllMyStones(playerOfBoxDoingMove);
		}

	}

	public void doingMove() {
		checkOpponentBoxesEmpty(this.player);
		if (checkOpponentBoxesEmpty(this.player)) {
			takeAllMyStones(this.player);
			checkWinner();
		} else {
			int x = getStones();
			neighbour.receiveStones(getStones(), this.player);
			this.setStones(0);
			this.player.switchTurn();
		}
	}



}
	

