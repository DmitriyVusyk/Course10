package module5.module5FXMenu.view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import module5.module5FXMenu.MainApp;
import module5.module5FXMenu.model.Car;
import module5.module5FXMenu.model.CarWheel;

import java.util.regex.Pattern;

public class ControlPanelController {

    // Ссылка на главное приложение.
    private MainApp mainApp;

    @FXML
    private Label carNameLbl;
    @FXML
    private Label engineTypeLbl;
    @FXML
    private Label productionDateLbl;
    @FXML
    private Label maxSpeedLbl;
    @FXML
    private Label maxNumberOfSeatsLbl;
    @FXML
    private Label leftFDLbl;
    @FXML
    private Label rightFDLbl;
    @FXML
    private Label leftFWndwLbl;
    @FXML
    private Label rightFWndwLbl;
    @FXML
    private Label leftRDLbl;
    @FXML
    private Label rightRDLbl;
    @FXML
    private Label leftRWndwLbl;
    @FXML
    private Label rightRWndwLbl;
    @FXML
    private Label leftFWLbl;
    @FXML
    private Label rightFWLbl;
    @FXML
    private Label leftRWLbl;
    @FXML
    private Label rightRWLbl;
    @FXML
    private Label currentSpeedLbl;
    @FXML
    private Label numberOfPassengersLbl;
    @FXML
    private CheckBox frontLeftDoorChecked;
    @FXML
    private CheckBox frontRightDoorChecked;
    @FXML
    private CheckBox rearleftDoorChecked;
    @FXML
    private CheckBox rearRightDoorChecked;
    @FXML
    private CheckBox frontLeftWheelChecked;
    @FXML
    private CheckBox frontRightWheelChecked;
    @FXML
    private CheckBox rearLeftWheelChecked;
    @FXML
    private CheckBox rearRightWheelChecked;

    private IntegerProperty percentInt = new SimpleIntegerProperty();

    @FXML
    private TextField percentInput;

    private IntegerProperty speedInt = new SimpleIntegerProperty();

    @FXML
    private TextField speedInput;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public ControlPanelController() {

    }

    /**
     * Заполняет поля вывода информации
     *
     * @param car текущий обьект Машины
     */
    private void fillConditionLabels(Car car) {
        carNameLbl.setText(car.getCarName());
        engineTypeLbl.setText(car.getEngineType());
        productionDateLbl.setText(car.getProductionDate());
        maxSpeedLbl.setText(String.valueOf(car.getMaxSpeed()));
        maxNumberOfSeatsLbl.setText(String.valueOf(car.getMaxNumberOfPassengers()));

        leftFDLbl.setText(String.valueOf(car.getCarDoorAtIndex(0).checkDoorIsOpen()));
        rightFDLbl.setText(String.valueOf(car.getCarDoorAtIndex(1).checkDoorIsOpen()));
        leftRDLbl.setText(String.valueOf(car.getCarDoorAtIndex(2).checkDoorIsOpen()));
        rightRDLbl.setText(String.valueOf(car.getCarDoorAtIndex(3).checkDoorIsOpen()));

        leftFWndwLbl.setText(String.valueOf(car.getCarDoorAtIndex(0).checkWindowIsOpen()));
        rightFWndwLbl.setText(String.valueOf(car.getCarDoorAtIndex(1).checkWindowIsOpen()));
        leftRWndwLbl.setText(String.valueOf(car.getCarDoorAtIndex(2).checkWindowIsOpen()));
        rightRWndwLbl.setText(String.valueOf(car.getCarDoorAtIndex(3).checkWindowIsOpen()));

        leftFWLbl.setText(String.valueOf(car.getCarWheelAtIndex(0).getWheelCondition()));
        rightFWLbl.setText(String.valueOf(car.getCarWheelAtIndex(1).getWheelCondition()));
        leftRWLbl.setText(String.valueOf(car.getCarWheelAtIndex(2).getWheelCondition()));
        rightRWLbl.setText(String.valueOf(car.getCarWheelAtIndex(3).getWheelCondition()));

        currentSpeedLbl.setText(String.valueOf(car.getCurrentSpeed()));
        numberOfPassengersLbl.setText(String.valueOf(car.getNumberOfPassengers()));


    }

    private void configTextLabel() {
        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");

        percentInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) percentInput.setText(oldValue);
        });

        speedInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) speedInput.setText(oldValue);
        });
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        percentInput.textProperty().bindBidirectional(percentInt, new NumberStringConverter());
        speedInput.textProperty().bindBidirectional(speedInt, new NumberStringConverter());
    }

    @FXML
    private void openCloseDoorButton() {

        if (frontLeftDoorChecked.isSelected()) {
            mainApp.getCar().getCarDoorAtIndex(0).openCloseCarDoor();
        }

        if (frontRightDoorChecked.isSelected()) {
            mainApp.getCar().getCarDoorAtIndex(1).openCloseCarDoor();
        }

        if (rearleftDoorChecked.isSelected()) {
            mainApp.getCar().getCarDoorAtIndex(2).openCloseCarDoor();
        }

        if (rearRightDoorChecked.isSelected()) {
            mainApp.getCar().getCarDoorAtIndex(3).openCloseCarDoor();
        }

        fillConditionLabels(mainApp.getCar());

    }

    @FXML
    private void openCloseDoorWindow() {

        if (frontLeftDoorChecked.isSelected()) {
            mainApp.getCar().getCarDoorAtIndex(0).openCloseCarWindow();
        }

        if (frontRightDoorChecked.isSelected()) {
            mainApp.getCar().getCarDoorAtIndex(1).openCloseCarWindow();
        }

        if (rearleftDoorChecked.isSelected()) {
            mainApp.getCar().getCarDoorAtIndex(2).openCloseCarWindow();
        }

        if (rearRightDoorChecked.isSelected()) {
            mainApp.getCar().getCarDoorAtIndex(3).openCloseCarWindow();
        }

        fillConditionLabels(mainApp.getCar());

    }

    @FXML
    private void changeWheel() {

        if (frontLeftWheelChecked.isSelected()) {
            mainApp.getCar().getCarWheelAtIndex(0).changeNewWheel();
        }

        if (frontRightWheelChecked.isSelected()) {
            mainApp.getCar().getCarWheelAtIndex(1).changeNewWheel();
        }

        if (rearLeftWheelChecked.isSelected()) {
            mainApp.getCar().getCarWheelAtIndex(2).changeNewWheel();
        }

        if (rearRightWheelChecked.isSelected()) {
            mainApp.getCar().getCarWheelAtIndex(3).changeNewWheel();
        }

        fillConditionLabels(mainApp.getCar());

    }

    @FXML
    private void unmountWheels() {

        for (CarWheel wheel :
                mainApp.getCar().getWheelsArray()) {
            wheel.setWheelCondition(0);
        }

        fillConditionLabels(mainApp.getCar());

    }

    @FXML
    private void eraseWheelProfile() {

        if (frontLeftWheelChecked.isSelected()) {
            mainApp.getCar().getCarWheelAtIndex(0).eraseWheelProfile(percentInt.get());
        }

        if (frontRightWheelChecked.isSelected()) {
            mainApp.getCar().getCarWheelAtIndex(1).eraseWheelProfile(percentInt.get());
        }

        if (rearLeftWheelChecked.isSelected()) {
            mainApp.getCar().getCarWheelAtIndex(2).eraseWheelProfile(percentInt.get());
        }

        if (rearRightWheelChecked.isSelected()) {
            mainApp.getCar().getCarWheelAtIndex(3).eraseWheelProfile(percentInt.get());
        }

        fillConditionLabels(mainApp.getCar());

    }

    @FXML
    private void setCurrentSpeed(){
        mainApp.getCar().setCurrentSpeed(speedInt.get());
        fillConditionLabels(mainApp.getCar());
    }

    @FXML
    private void addPassenger(){
        mainApp.getCar().addPassenger();
        fillConditionLabels(mainApp.getCar());
    }

    @FXML
    private void dropPassenger(){
        mainApp.getCar().dropPassenger();
        fillConditionLabels(mainApp.getCar());
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        fillConditionLabels(mainApp.getCar());

    }
}
