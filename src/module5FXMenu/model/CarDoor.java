package module5FXMenu.model;

/**
 * This class is implements a Car Door
 */
public class CarDoor {

    private boolean doorIsOpen;
    private boolean windowIsOpen;

    public CarDoor() {
        this.doorIsOpen = false;
        this.windowIsOpen = false;
    }

    public CarDoor(boolean doorIsOpen, boolean windowIsOpen) {
        this.doorIsOpen = doorIsOpen;
        this.windowIsOpen = windowIsOpen;
    }

    public boolean checkDoorIsOpen() {
        return doorIsOpen;
    }

    public boolean checkWindowIsOpen() {
        return windowIsOpen;
    }

    private void setDoorIsOpen(boolean doorIsOpen) {
        this.doorIsOpen = doorIsOpen;
    }

    private void setWindowIsOpen(boolean windowIsOpen) {
        this.windowIsOpen = windowIsOpen;
    }

    public boolean openCarDoor() {
        setDoorIsOpen(true);
        return checkDoorIsOpen();
    }

    public boolean closeCarDoor() {
        setDoorIsOpen(false);
        return checkDoorIsOpen();
    }

    public boolean openCloseCarDoor() {
        return doorIsOpen ? closeCarDoor() : openCarDoor();
    }

    public boolean openCarWindow() {
        setWindowIsOpen(true);
        return checkWindowIsOpen();
    }

    public boolean closeCarWindow() {
        setWindowIsOpen(false);
        return checkWindowIsOpen();
    }

    public boolean openCloseCarWindow() {
        return windowIsOpen ? closeCarWindow() : openCarWindow();
    }

    @Override
    public String toString() {
        return "CarDoor:" +
                "doorIsOpen=" + doorIsOpen +
                ", windowIsOpen=" + windowIsOpen +
                '.';
    }
}
