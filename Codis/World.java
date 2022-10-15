import java.awt.*;

public class World {
    private int width;
    private int height;
    private Agent[] agents;
    private int numAgents;
    private int margin;

    private double randomPos(){
        return margin + Math.random() *(width - 2 * margin);
    }
    private double randomRadius() {
        return 5 + Math.random() * (margin - 5);
    }

    public World(int w, int h) {
        width = w;
        height = h;
        agents = new Agent[10];
        for (int i = 0; i < 10; i++) {
            agents[i] = new Agent(randomPos(),randomPos(),randomRadius());
            agents[i].setTarget(randomPos(),randomPos());
            agents[i].setSpeed(1);
        }
    }

    public void simulationStep() {
        for (int i = 0; i < 10; i++){
           if (agents[i].targetReached() == true) {
            agents[i].setTarget(randomPos(), randomPos());
           } else {
            agents[i].updatePosition();
           }
        }
    }

    public void paint(Graphics g) {
        for (int i=0; i< numAgents;i++){
            agents[i].paint(g);
        }
    }
}
