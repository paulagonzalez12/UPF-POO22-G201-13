import java.awt.*;
public class Agent {
    private Vec2D pos;
    private double radius;
    private Vec2D dir;
    private Vec2D target;
    private double speed;

    //constructor
    public Agent(double px, double py, double r){ 
        pos = new Vec2D(px, py);
        radius = r;  
    }

    public setTarget(double tx, double ty) { 
        target = new Vec2D(tx, ty);
        dir = new Vec2D(target);
        dir.subtract(pos);
        dir.normalize();
    }

    public setSpeed(double s) { 
        speed = s; 
    }

    public updatePosition() { 
        pos.add(new Vec2D(speed*dir.getX(),speed*dir.gety()));
    }

    public boolean targetReached() { 
        Vec2D dif = new Vec2D(target);
        dif.subtract(pos);
        if (dif.length =< radius) {
            return true;
        }
        return false;
    }

    public boolean isColliding(Agent a) {
        Vec2D dif = new Vec2D(pos);
        dif.subtract(a.pos);
        if (dir.length =< radius + a.radius) {
            return true;
        }
        return false;
    }

    public void paint (Graphics g){
        int x = (int)(pos.getX()-radius);
        int y = (int)(pos.getY()-radius);
        int d = (int) (2*radius);
        g.setColor(Collor.RED);
        g.fillOval(x, y, d, d);
    }
}
