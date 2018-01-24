package module5_3.flower_entities;

public class Tulip extends Flower {

    private int cost = 45;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Tulip{" +
                "cost=" + cost +
                '}';
    }
}
