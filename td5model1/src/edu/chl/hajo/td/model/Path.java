package edu.chl.hajo.td.model;


import edu.chl.hajo.td.util.Point2D;
import lombok.Getter;
import sun.jvm.hotspot.types.PointerType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 *   A path for creeps (waves) to follow
 */
public class Path {
    @Getter
    private final int id;
    @Getter
    private final List<Point2D> points;
    @Getter
    private final int tileSize;

    public Path(int i, List<String> strPts, int tileSize) {
        Iterator<String> stringIterator = strPts.iterator();
        List<Point2D> test = new ArrayList<>();
        while (stringIterator.hasNext()) {
            String string = stringIterator.next();
            double y = Double.valueOf(string.split(",")[0]) * tileSize;
            double x = Double.valueOf(string.split(",")[1]) * tileSize;
            test.add(new Point2D(y, x));
        }
        this.id = i;
        this.points = test;
        this.tileSize = tileSize;
    }

    public Path(Path p) {
        this.id = p.getId();
        this.points = p.getPoints();
        this.tileSize = p.getTileSize();
    }

    // TODO

}
