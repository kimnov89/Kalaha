package nl.sogyo.mancala.Mancala;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class PlayerTest{
public SmallBox box;


    @Before
    public void Before(){
        box=new SmallBox();
    }

    @Test
    public void turnTest(){
        assertTrue(box.getPlayer().getTurn());
    }

    @Test
    public void switchTurnTest(){
        box.getPlayer().switchTurn();
        assertFalse(box.getPlayer().getTurn());
    }

    @Test
    public void isWinnerTest(){
        box.getPlayer().isWinner();
        assertTrue(box.getPlayer().getWinner());
    }

    @Test
    public void isLoserTest(){
        box.getPlayer().isLoser();
        assertFalse(box.getPlayer().getWinner());
    }

    public void TieTest(){
        box.getPlayer().Tie();
        assertNull(box.getPlayer().getWinner());
    }

}
