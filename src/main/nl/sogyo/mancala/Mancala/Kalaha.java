package nl.sogyo.mancala.Mancala;

public class Kalaha extends Box {


	public Kalaha(Player player, SmallBox firstBox, int numberBoxInit) {
		stones = 0;
		this.player = player;
		numberBoxInit++;
		if (numberBoxInit == 6) {
			neighbour = new SmallBox(new Player(), firstBox, numberBoxInit);
		} else if (numberBoxInit == 13) {
			neighbour = firstBox;
		}
	}



}
