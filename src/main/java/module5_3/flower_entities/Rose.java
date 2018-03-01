package module5_3.flower_entities;

public class Rose extends Flower {

    private int cost = 100;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Rose{" +
                "cost=" + cost +
                '}';
    }
}
