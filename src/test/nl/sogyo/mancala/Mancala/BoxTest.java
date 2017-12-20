package nl.sogyo.mancala.Mancala;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {
    public SmallBox box;

    @Before
    public void Before() {
        box = new SmallBox();
    }

    @Test
    public void InitTest(){
        assertTrue(box.HelperInit(6)instanceof Kalaha);
        assertTrue(box.HelperInit(3)instanceof SmallBox);
        assertTrue(box.HelperInit(13)instanceof Kalaha);
        assertEquals(box.HelperInit(14),box);
    }


    @Test
    public void getNeighbourAcrossTest(){
        assertTrue(box.getAcrossNeighbour()instanceof SmallBox);
        assertEquals(box.HelperInit(3).getAcrossNeighbour(),box.HelperInit(9));
    }


}