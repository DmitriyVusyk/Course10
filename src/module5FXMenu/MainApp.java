package module5FXMenu;

import module5FXMenu.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import module5FXMenu.view.ControlPanelController;

import java.io.IOException;
import java.io.InputStream;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private Car car;

    public MainApp() {
        this.car = new Car("Audi A6", 2012, 10, 12,
                "AGU", 240, 6.0f,
                5, 0, 0);

        CarDoor frontLeftDoor = new CarDoor(false, false);
        CarDoor frontRightDoor = new CarDoor(false, false);
        CarDoor rearLeftDoor = new CarDoor(false, false);
        CarDoor rearRightDoor = new CarDoor(false, false);

        CarWheel frontLeftWheel = new CarWheel(1);
        CarWheel frontRightWheel = new CarWheel(1);
        CarWheel rearLeftWheel = new CarWheel(1);
        CarWheel rearRightWheel = new CarWheel(1);

        CarDoor[] carDoors = {frontLeftDoor, frontRightDoor, rearLeftDoor, rearRightDoor};
        CarWheel[] carWheels = {frontLeftWheel, frontRightWheel, rearLeftWheel, rearRightWheel};

        car.setDoorsArray(carDoors);
        car.setWheelsArray(carWheels);
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Car Control Panel");

        initRootLayout();

        showCarControlPanel();
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Показывает в корневом макете сведения.
     */
    public void showCarControlPanel() {
        try {
            // Загружаем сведения об адресатах.

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("view/ControlPanelLayout.fxml"));

            AnchorPane carControlPanel = loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(carControlPanel);

            // Даём контроллеру доступ к главному приложению.
            ControlPanelController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает главную сцену.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
