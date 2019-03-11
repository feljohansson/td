package edu.chl.hajo.td.model.creeps;

import edu.chl.hajo.td.model.Path;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
 *     A basic creep (something that follows a path)
 *     - Follows exactly one path
 *     - Will damage you if arriving at path end
 *     - May be killed by some tower placed by you
 */
public class Creep implements copy {
    @Setter
    @Getter
    private Point2D pos;    // Center position
    @Getter
    private final double width = -1; // Upper right corner: x - width / 2
    @Getter
    private final double height = -1;
    @Getter
    @Setter
    private Vector2D dir;  // Normalized direction for moving
    @Setter
    @Getter
    private double speed;
    @Getter
    private final Path path;

    @Getter
    @Setter
    private int hp;  // Current health
    @Getter
    private final int maxHp = 50;      // Needed for % display in GUI
    @Getter
    private final int killPoints = 100;  // Points to player when killed
    @Getter
    private final int damage = 5;      // Damage caused when arriving at (non existing) base of player

    public Creep(Path p) {
        this.pos = p.getPoints().get(0);
        this.speed = 1;
        this.path = p;
        this.hp = maxHp;
    }

    public void move(){
        List<Point2D> pathPts = path.getPoints();
        Point2D endPt = pathPts.get(pathPts.size() - 1);
        Point2D currentPos = getPos();
        if (pathPts.contains(currentPos)) {
            if (!currentPos.equals(endPt)) {
                int index = pathPts.indexOf(currentPos);
                Point2D startPos = pathPts.get(index);
                Point2D endPos = pathPts.get(index + 1);
                setDir(new Vector2D(startPos, endPos));
                setPos(new Point2D(currentPos.getX() + dir.getX() * getSpeed(), currentPos.getY() + dir.getY() * getSpeed()));
            }
        } else {
            if (!currentPos.equals(endPt)) {
                setPos(new Point2D(currentPos.getX() + (dir.getX() * getSpeed()), currentPos.getY() + (dir.getY() * getSpeed())));
            }
        }
    }

    // Copy constructor
    protected Creep(Creep c) {
        this.pos = new Point2D(c.pos);
        this.dir = new Vector2D(c.dir.getX(), c.dir.getY());
        this.speed = c.speed;
        this.path = new Path(c.path);
    }

    public Creep copy() {
        return new Creep (this);
    }

}


    /*
    @Override
    public Object clone() {
        try {
            Creep c = (Creep) super.clone();
            c.setPos(this.pos);
            c.setDir(this.dir);
            c.setSpeed(this.speed);
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
    */