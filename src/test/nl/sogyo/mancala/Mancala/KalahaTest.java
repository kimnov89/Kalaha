package nl.sogyo.mancala.Mancala;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class KalahaTest{
	public SmallBox box;

	@Before
	public void Before(){
		box=new SmallBox();
	}

	@Test
	public void testKalahaexists() {
		assertNotNull(box.getKalaha());
	}
	
	@Test
	public void testKalahainit(){
		assertEquals(box.getKalaha().getStones(),0);
	}

	@Test
	public void getKalahaTest(){
		assertTrue(box.getKalaha() instanceof Kalaha);
	}

	@Test
	public void doSetOwnKalahaReceivesOneStoneTest(){
		box.setStones(10);
		assertEquals(box.getStones(),10);
		box.doingMove();
		assertEquals(box.getPlayer().getTurn(),false);
		assertEquals(box.getKalaha().getStones(),1);
	}

	@Test
	public void doSetOpponentKalahaSkipped(){
		assertEquals(box.HelperInit(13).getStones(),0);
		box.setStones(13);
		box.doingMove();
		assertEquals(box.getPlayer().getTurn(),false);
		assertEquals(box.HelperInit(13).getStones(),0);
	}

	@Test
	public void endInOwnKalahaTest(){
		box.setStones(5);
		assertEquals(box.getPlayer().getTurn(),true);
		box.doingMove();
		assertEquals(box.getPlayer().getTurn(),true);
	}

}
