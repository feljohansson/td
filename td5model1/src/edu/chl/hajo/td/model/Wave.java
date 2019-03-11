package edu.chl.hajo.td.model;

import edu.chl.hajo.td.model.creeps.Creep;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 *    A Wave of creeps
 *    - All creeps of same kind
 *    - All follow same path.
 *
 */

public class Wave {
    @Getter
    private final Creep prototype;
    @Setter
    @Getter
    private final int waveSize;

    @Getter
    private final List<Creep> wave;


    public Wave(int size, long tenth, long one, Creep p) {
        this.prototype = p;
        this.waveSize = size;
        this.wave = new ArrayList<Creep>();
    }



    public void move() {


    }

    public void spawn(long now) {

    }


    // TODO



}
