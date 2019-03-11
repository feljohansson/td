package edu.chl.hajo.td.model;

import edu.chl.hajo.td.model.creeps.Creep;
import edu.chl.hajo.td.util.Point2D;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static edu.chl.hajo.td.model.TowerDefence.TILE_SIZE;
import static org.junit.Assert.*;

/*
        JUnit testing of model
 */
public class ModelTest {

    @Test
    public void testPath() throws Exception {
         List<String> strPts = Arrays.asList(
                "0,3", "3,3", "3,9", "8,9", "8,4", "12,4",
                "12,12", "3,12", "3,17", "17,17",
                "17,6", "20,6");
        Path p = new Path(0, strPts, TILE_SIZE);

        assertTrue(p.getId() == 0);
        assertTrue(p.getTileSize() == TILE_SIZE);

        Creep c = new Creep(p);
        c.move();

//        assertTrue(c.getPos().equals(new Point2D(640,192)));
        /*
        Creep c2 = c.copy();
        assertTrue(c2.getPos().equals(c.getPos()));
        c.setPos(new Point2D(10.0, 20.0));
        assertTrue(!c2.getPos().equals(c.getPos()));
        // etc.
        */
    }

    // Add more tests as needed

}