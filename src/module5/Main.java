package module5;


/**
 * Created by dmytrovusyk on 12.12.17.
 */
public class Main {

    public static void main(String[] args) {
        Car car = new Car("Audi A6", 2002, 2, 24,
                "agu", 220, 6.6f,
                4, 1, 0);
        CarWheel carWheelFrontLeft = new CarWheel(1);
        CarDoor carDoorLeft = new CarDoor(false, false);

        CarWheel[] wheelsArray = {carWheelFrontLeft};
        CarDoor[] carDoorsArray = {carDoorLeft};

        car.setWheelsArray(wheelsArray);
        car.setDoorsArray(carDoorsArray);

        System.out.println(car.calculateMaxSpeed());
        car.getCarWheelAtIndex(0).eraseWheelProfile(20);
        System.out.println(car.calculateMaxSpeed());

    }
}
