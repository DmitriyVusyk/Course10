package module5_3.flower_entities;

import java.io.Serializable;

public abstract class Flower implements Serializable {
    int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
