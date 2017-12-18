package module5FXMenu.model;

import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class is implements a Car
 */
public class Car {
    private String carName;
    private String productionDate;
    private String engineType;
    private int maxSpeed;
    private float accelerationTime;
    private int maxNumberOfPassengers;
    private int numberOfPassengers;
    private int currentSpeed;
    private CarWheel[] wheelsArray;
    private CarDoor[] doorsArray;

    public Car(int year, int month, int day) {
        this.productionDate = formatedDate(year, month, day);
    }

    public Car(String carName, int year, int month, int day, String engineType,
               int maxSpeed, float accelerationTime,
               int maxNumberOfPassengers, int numberOfPassengers,
               int currentSpeed) {
        this.carName = carName;
        this.productionDate = formatedDate(year, month, day);
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelerationTime = accelerationTime;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.numberOfPassengers = numberOfPassengers;
        this.currentSpeed = currentSpeed;
    }

    // Getters:

    public String getCarName() {
        return carName;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public float getAccelerationTime() {
        return accelerationTime;
    }

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public CarWheel[] getWheelsArray() {
        return wheelsArray;
    }

    public CarDoor[] getDoorsArray() {
        return doorsArray;
    }

    //Setters:

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAccelerationTime(float accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setWheelsArray(CarWheel[] wheelsArray) {
        this.wheelsArray = wheelsArray;
    }

    public void setDoorsArray(CarDoor[] doorsArray) {
        this.doorsArray = doorsArray;
    }

    //Default methods:

    private String formatedDate(int year, int month, int day) {
        int yearD = year - 1900;
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date(yearD, month - 1, day);

        return formater.format(date);
    }

    public void addPassenger() {
        if (getNumberOfPassengers() < getMaxNumberOfPassengers()) {
            setNumberOfPassengers(getNumberOfPassengers() + 1);
        }
    }

    public void dropPassenger() {
        if (0 < getNumberOfPassengers()) {
            setNumberOfPassengers(getNumberOfPassengers() - 1);
        }
    }

    public void dropAllPassengers() {
        setNumberOfPassengers(0);
    }

    public CarDoor getCarDoorAtIndex(int doorIndex) {

        CarDoor[] doors = getDoorsArray();

        return doors[doorIndex];
    }

    public CarWheel getCarWheelAtIndex(int wheelIndex) {
        CarWheel[] wheels = getWheelsArray();

        return wheels[wheelIndex];
    }

    public void unmountAllWheels() {
        setWheelsArray(null);
    }

    public void mountAdditionalWheels(int countOfNewWheels) {

        CarWheel[] wheels = getWheelsArray();
        CarWheel[] result = new CarWheel[wheels.length + countOfNewWheels];

        System.arraycopy(wheels, 0, result, 0, wheels.length);

        for (CarWheel wheel :
                result) {
            if (wheel == null) {
                wheel = new CarWheel();
            }

        }
    }

    public float calculateMaxSpeed() {

        if (getNumberOfPassengers() == 0) {
            return 0;
        }

        float result;
        CarWheel[] wheels = getWheelsArray();
        CarWheel mostErasedWheel = wheels[0];

        for (CarWheel wheel : wheels) {
            if (wheel.getWheelCondition() < mostErasedWheel.getWheelCondition())
                mostErasedWheel = wheel;
        }

        result = getMaxSpeed() * mostErasedWheel.getWheelCondition();

        return result;
    }

    @Override
    public String toString() {
        return "Car:" +
                "production date: " + productionDate +
                ", engine type: '" + engineType + '\'' +
                ", max speed: " + maxSpeed +
                ", current max speed: " + calculateMaxSpeed() +
                ", acceleration time: " + accelerationTime +
                ", max number of passengers: " + maxNumberOfPassengers +
                ", number of passengers: " + numberOfPassengers +
                ", current speed: " + currentSpeed +
                ", wheels array: " + Arrays.toString(wheelsArray) +
                ", doors array: " + Arrays.toString(doorsArray) +
                '.';
    }
}
