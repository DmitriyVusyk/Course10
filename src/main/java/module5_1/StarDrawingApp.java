package module5_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class StarDrawingApp extends Application {
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 700;

    private static final int RGB_SYMBOLS_COUNT = 6;

    private static final int COUNTS_OF_RAYS = 5;

    private int xPosition;
    private int yPosition;
    private int maxRadius;

    public static void main(String[] args) {
        launch(args);
    }

    private void createSimpleStar(Pane root) {
        Shape shape = drawStar(xPosition, yPosition, maxRadius / 2.63, maxRadius, 5,
                Math.toRadians(-18));
        shape.setStrokeWidth(2);
        shape.setFill(Paint.valueOf("#00000000"));
        shape.setStroke(Paint.valueOf("#11111111"));
        root.getChildren().addAll(shape);
        System.out.println("Star drawed");

    }


    private static Shape drawStar(double koordX, double koordY,
                                  double innerRadius, double outerRadius, int numOfRays,
                                  double startAngleR) {

        Path p = new Path();
        double deltaAngleR = Math.PI / numOfRays;
        for (int i = 0; i < numOfRays * 2; i++) {
            double angleR = startAngleR + i * deltaAngleR;
            double ca = Math.cos(angleR);
            double sa = Math.sin(angleR);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0) {
                relX *= outerRadius;
                relY *= outerRadius;
            } else {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0) {
                p.setTranslateX(koordX + relX);
                p.setTranslateY(koordY + relY);
            } else {
                p.setTranslateX(koordX + relX);
                p.setTranslateY(koordY + relY);
            }
        }
        return p;
    }

    void windowSetup(Stage primaryStage) {
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);

        primaryStage.setMaxWidth(WINDOW_WIDTH);
        primaryStage.setMaxHeight(WINDOW_HEIGHT);

        primaryStage.setMinWidth(WINDOW_WIDTH);
        primaryStage.setMinHeight(WINDOW_HEIGHT);
    }

    private void drawUI(Pane root, Pane starRoot) {

        TextField setXPositionTF = new TextField();
        setXPositionTF.setTranslateX(180);
        setXPositionTF.setTranslateY(10);

        TextField setYPositionTF = new TextField();
        setYPositionTF.setTranslateX(180);
        setYPositionTF.setTranslateY(60);

        TextField maxRadiusTF = new TextField();
        maxRadiusTF.setTranslateX(180);
        maxRadiusTF.setTranslateY(110);

        Button drawStarButton = new Button("Draw Star");
        drawStarButton.setTranslateX(10);
        drawStarButton.setTranslateY(160);
        drawStarButton.setOnAction((event) -> {
            createSimpleStar(starRoot);
        });

        Button setXPositionButton = new Button("Set X Position");
        setXPositionButton.setTranslateX(10);
        setXPositionButton.setTranslateY(10);
        setXPositionButton.setOnAction((event) -> {
            xPosition = Integer.parseInt(setXPositionTF.getText());
        });


        Button setYPositionButton = new Button("Set Y Position");
        setYPositionButton.setTranslateX(10);
        setYPositionButton.setTranslateY(60);
        setYPositionButton.setOnAction((event) -> {
            yPosition = Integer.parseInt(setYPositionTF.getText());
        });

        Button maxRadButton = new Button("Set Max Radius");
        maxRadButton.setTranslateX(10);
        maxRadButton.setTranslateY(110);
        maxRadButton.setOnAction((event) -> {
            maxRadius = Integer.parseInt(maxRadiusTF.getText());
        });

        root.getChildren().addAll(drawStarButton, setXPositionButton, setYPositionButton, maxRadButton,
                setXPositionTF, setYPositionTF, maxRadiusTF);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Pane starRoot = new Pane();

        root.getChildren().addAll(starRoot);
        drawUI(root, starRoot);
        //createSimpleStar(starRoot);

        windowSetup(primaryStage);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}