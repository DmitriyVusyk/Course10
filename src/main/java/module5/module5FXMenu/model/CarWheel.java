package module5.module5FXMenu.model;

/**
 * This class is implements a Car Wheel
 */
public class CarWheel {

    private float wheelCondition;

    public CarWheel(float wheelCondition) {
        if (0 < wheelCondition && wheelCondition < 1) {
            this.wheelCondition = wheelCondition;
        } else {
            this.wheelCondition = 1;
        }
    }

    public CarWheel() {
        this.wheelCondition = 1f;
    }

    public float getWheelCondition() {
        return wheelCondition;
    }

    public void setWheelCondition(float wheelCondition) {
        this.wheelCondition = wheelCondition;
    }

    public void changeNewWheel() {
        setWheelCondition(1f);
    }

    public void eraseWheelProfile(int byPercent) {
        if (byPercent > 100 || byPercent < 0) {
            throw new IllegalArgumentException();
        }

        if (byPercent == 100) {
            setWheelCondition(0f);
        } else if (byPercent == 0) {
            setWheelCondition(getWheelCondition());
        } else {
            setWheelCondition(getWheelCondition() - (getWheelCondition() * byPercent / 100));
        }

    }

    @Override
    public String toString() {
        return "CarWheel:" +
                "wheelCondition=" + wheelCondition +
                ';';
    }
}
