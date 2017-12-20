package nl.sogyo.mancala.Mancala;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallBoxTest{
	public SmallBox box;

	@Before
	public void Before(){
		box=new SmallBox();
	}

	@Test
	public void existTest() {
		assertNotNull(box);
	}
	
	@Test
	public void initBox() {
		assertEquals(box.getStones(),4);
	}

	@Test
	public void NeighbourHasStonesTest() {
		assertEquals(box.neighbour.getStones(),4);
	}
	
	@Test
	public void receiveStonesTest() {
		box.receiveStones(2,box.player);
		assertEquals(box.getStones(),5);
		assertEquals(box.neighbour.getStones(),5);
		assertEquals(box.neighbour.neighbour.getStones(),4);
	}


	@Test
	public void playerDifferentinBoxes(){
		assertNotNull(box.HelperInit(8).getPlayer());
		assertNotEquals(box.HelperInit(8).getPlayer(),box.HelperInit(3).getPlayer());
	}

	@Test
	public void HitAcrossBoxTest(){
		box.setStones(2);
		box.HelperInit(2).setStones(0);
		box.doingMove();
		assertEquals(box.getKalaha().getStones(),5);
	}

	@Test
	public void checkOpponentBoxesEmptyTest(){
		assertFalse(box.checkOpponentBoxesEmpty(box.player));
		box.emptyAllOpponentBoxes(box.player);
		assertEquals(box.getAcrossNeighbour().getStones(),0);
		assertEquals(box.getKalaha().neighbour.neighbour.getStones(),0);
		assertEquals(box.getKalaha().neighbour.getStones(),0);
		assertTrue(box.checkOpponentBoxesEmpty(box.getPlayer()));
	}

	@Test
	public void takeAllMyStonesTest(){
		assertEquals(box.getStones(),4);
		assertEquals(box.getKalaha().getStones(),0);
		assertEquals(box.HelperInit(3).getStones(),4);
		assertEquals(box.HelperInit(13),box.getAcrossNeighbour().getKalaha());
		box.takeAllMyStones(box.player);
		assertEquals(box.getKalaha().getStones(),24);

	}

	@Test
	public void endGameOpponentWinsTest(){
		box.emptyAllMyBoxes(box.player);
		assertEquals(box.getStones(),0);
		assertEquals(box.neighbour.neighbour.getStones(),0);
		SmallBox sb= (SmallBox) box.getAcrossNeighbour();
		sb.doingMove();
		assertTrue(sb.getPlayer().winner);
		assertFalse(box.getPlayer().winner);
	}

	@Test
	public void endGameThisPlayerWinsTest(){
		box.emptyAllOpponentBoxes(box.player);
		box.doingMove();
		assertTrue(box.getPlayer().winner);
		SmallBox sb=(SmallBox) box.getAcrossNeighbour();
		assertFalse(sb.getPlayer().winner);
	}

	@Test
	public void endGameTieTest(){
		assertEquals(box.neighbour.getStones(),4);
		box.emptyAllOpponentBoxes(box.player);
		box.getAcrossNeighbour().getKalaha().setStones(24);
		box.doingMove();
		assertEquals(box.getStones(),4);
		assertEquals(box.neighbour.getStones(),4);
		assertEquals(box.getAcrossNeighbour().getStones(),0);
		assertEquals(box.getKalaha().getStones(),24);
		assertEquals(box.getAcrossNeighbour().getKalaha().getStones(),24);
		assertNull(box.getPlayer().winner);
		assertNull(box.getAcrossNeighbour().getPlayer().winner);


	}


}
