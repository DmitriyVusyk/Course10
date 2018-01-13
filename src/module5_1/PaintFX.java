package module5_1;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class PaintFX extends Application {
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 700;

    private static final int RGB_SYMBOLS_COUNT = 6;

    private static final double SNOWMAN_POSITION_X = 600;

    private SimpleIntegerProperty countOfCircles = new SimpleIntegerProperty();
    private SimpleIntegerProperty minRadius = new SimpleIntegerProperty();
    private SimpleIntegerProperty maxRadius = new SimpleIntegerProperty();

    private static double circlePosition = 600;
    private double nextPos;

    private static Random r = new Random();

    private int getCountOfCircles() {
        return countOfCircles.get();
    }

    private int getMinRadius() {
        return minRadius.get();
    }

    private int getMaxRadius() {
        return maxRadius.get();
    }

    private double getCirclePosition() {
        return circlePosition;
    }

    private void setCountOfCircles(int countOfCircles) {
        this.countOfCircles.set(countOfCircles);
    }

    private void setMinRadius(int minRadius) {
        this.minRadius.set(minRadius);
    }

    private void setMaxRadius(int maxRadius) {
        this.maxRadius.set(maxRadius);
    }

    private void setCirclePosition(double nextCirclePosition) {
        this.circlePosition = nextCirclePosition;
    }

    public SimpleIntegerProperty countOfCirclesProperty() {
        return countOfCircles;
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static Paint generateRandomColor() {
        String rgb = "#";
        for (int i = 0; i < RGB_SYMBOLS_COUNT; i++) {
            rgb += (char) ('0' + r.nextInt(9));
        }
        System.out.println(rgb);
        return Paint.valueOf(rgb);
    }

    private Circle generateCircle(int maxRadius, int maxStroke) {
        Circle c = new Circle();

        c.setCenterX(SNOWMAN_POSITION_X);
        c.setRadius((r.nextDouble() * ++maxRadius) + getMinRadius());
        c.setStrokeWidth(r.nextDouble() * maxStroke);
        c.setStroke(generateRandomColor());
        c.setFill(Paint.valueOf("#00000000"));

        return c;
    }

    private void draw(Pane root) {

        Circle[] circles = new Circle[getCountOfCircles()];
        Circle[] faceCircles = new Circle[3];

        for (int i = 0; i < getCountOfCircles(); i++) {
            Circle circle = generateCircle(getMaxRadius(), 10);
            circles[i] = circle;
        }

        for (int i = 0; i < circles.length; i++) {
            circles[i].setCenterY(getCirclePosition());
            nextPos = circles[i].getCenterY() - circles[i].getRadius() - circles[i].getStrokeWidth() / 2;

            if (i == circles.length - 1) {

                for (int j = 0; j < faceCircles.length; j++) {
                    Circle faceCircle = new Circle();

                    faceCircle.setRadius(circles[i].getRadius() / 4);
                    faceCircle.setStrokeWidth(r.nextDouble() * 5);
                    faceCircle.setStroke(generateRandomColor());
                    faceCircle.setFill(Paint.valueOf("#00000000"));
                    faceCircles[j] = faceCircle;
                }

                faceCircles[0].setCenterX(SNOWMAN_POSITION_X - circles[i].getRadius() / 2);
                faceCircles[0].setCenterY(circles[i].getCenterY() - circles[i].getRadius() / 4);

                faceCircles[1].setCenterX(SNOWMAN_POSITION_X + circles[i].getRadius() / 2);
                faceCircles[1].setCenterY(circles[i].getCenterY() - circles[i].getRadius() / 4);

                faceCircles[2].setCenterX(circles[i].getCenterX());
                faceCircles[2].setCenterY(circles[i].getCenterY() + circles[i].getRadius() / 4);

                root.getChildren().addAll(faceCircles[0], faceCircles[1], faceCircles[2]);
            }

            if (i < circles.length - 1) {
                setCirclePosition(nextPos - circles[i + 1].getRadius());
            }
            root.getChildren().addAll(circles[i]);
        }


    }

    void windowSetup(Stage primaryStage) {
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);

        primaryStage.setMaxWidth(WINDOW_WIDTH);
        primaryStage.setMaxHeight(WINDOW_HEIGHT);

        primaryStage.setMinWidth(WINDOW_WIDTH);
        primaryStage.setMinHeight(WINDOW_HEIGHT);
    }

    private void drawUI(Pane root, Pane circlesRoot) {

        TextField countOfCirclesTF = new TextField();
        countOfCirclesTF.setTranslateX(180);
        countOfCirclesTF.setTranslateY(10);

        TextField minRadiusTF = new TextField();
        minRadiusTF.setTranslateX(180);
        minRadiusTF.setTranslateY(60);

        TextField maxRadiusTF = new TextField();
        maxRadiusTF.setTranslateX(180);
        maxRadiusTF.setTranslateY(110);

        Button drawSnowMan = new Button("Draw Snowman");
        drawSnowMan.setTranslateX(10);
        drawSnowMan.setTranslateY(160);
        drawSnowMan.setOnAction((event) -> {
            draw(circlesRoot);
        });

        Button countButton = new Button("Set number of Circles");
        countButton.setTranslateX(10);
        countButton.setTranslateY(10);
        countButton.setOnAction((event) -> {
            setCountOfCircles(Integer.parseInt(countOfCirclesTF.getText()));
        });


        Button minRadButton = new Button("Set Min Radius");
        minRadButton.setTranslateX(10);
        minRadButton.setTranslateY(60);
        minRadButton.setOnAction((event) -> {
            setMinRadius(Integer.parseInt(minRadiusTF.getText()));
        });

        Button maxRadButton = new Button("Set Max Radius");
        maxRadButton.setTranslateX(10);
        maxRadButton.setTranslateY(110);
        maxRadButton.setOnAction((event) -> {
            setMaxRadius(Integer.parseInt(maxRadiusTF.getText()));
        });

        root.getChildren().addAll(drawSnowMan, countButton, minRadButton, maxRadButton,
                countOfCirclesTF, minRadiusTF, maxRadiusTF);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Pane circlesRoot = new Pane();

        root.getChildren().addAll(circlesRoot);
        drawUI(root, circlesRoot);
        draw(circlesRoot);

        windowSetup(primaryStage);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}