package module5_3.flower_entities;

public class Chamomile extends Flower {

    private int cost = 70;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Chamomile{" +
                "cost=" + cost +
                '}';
    }
}
