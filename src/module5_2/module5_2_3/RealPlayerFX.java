package module5_2.module5_2_3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class RealPlayerFX extends Application {

    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 200;

    private Stage stage;
    private String audioFile = null;
    private MediaPlayer player;
    private Boolean fileInUse = false;
    private Label musicLabel = new Label("No File");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.stage = primaryStage;

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(addToolBar());
        borderPane.setStyle("-fx-background-color: Black");
        borderPane.setCenter(musicLabel);
        musicLabel.setStyle("-fx-background-color: Black");
        musicLabel.setStyle("-fx-border-color: Yellow");
        musicLabel.setStyle("-fx-text-fill: Yellow");

        Scene scene = new Scene(borderPane, SCENE_WIDTH, SCENE_HEIGHT);
        scene.setFill(Color.BLACK);

        primaryStage.setTitle("MP3 Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void chooseFile() {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("select your media(*.mp3)", "*.mp3");
        chooser.getExtensionFilters().add(filter);
        File file = chooser.showOpenDialog(this.stage);

        if (file != null) {
            musicLabel.setText(file.getName());

            try {
                this.audioFile = file.toURI().toURL().toString();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }

        } else {
            musicLabel.setText("Invalid Filename");
            this.audioFile = null;
        }
        fileInUse = false;
        player.stop();
    }

    private void playFile() {
        if (fileInUse) {
            player.play();
        } else {
            Media pick = new Media(this.audioFile);
            player = new MediaPlayer(pick);
            player.play();
        }
        fileInUse = true;
    }

    private void pauseFile() {
        player.pause();
    }

    private void moveForward() {
        player.seek(player.getCurrentTime().multiply(1.5));
    }

    private void moveBackward() {
        player.seek(player.getCurrentTime().divide(1.5));
    }

    //create a toolbar
    private HBox addToolBar() {
        HBox toolBar = new HBox();
        toolBar.setPadding(new Insets(20));
        toolBar.setAlignment(Pos.CENTER);
        toolBar.alignmentProperty().isBound();
        toolBar.setSpacing(5);
        toolBar.setStyle("-fx-background-color: Black");


        //PLAY_BUTTON:
        //create a Button and add Image to Button
        Image playButtonImage = new Image(getClass().getResourceAsStream("images/Play.png"));
        Button playButton = new Button();
        playButton.setGraphic(new ImageView(playButtonImage));
        playButton.setStyle("-fx-background-color: Black");

        playButton.setOnAction((ActionEvent e) -> {
            playFile();
        });

        playButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            playButton.setStyle("-fx-background-color: Black");
            playButton.setStyle("-fx-body-color: Black");
        });
        playButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            playButton.setStyle("-fx-background-color: Black");
        });


        //CHOOSE_FILE_BUTTON:

        Image chooseFileImage = new Image(getClass().getResourceAsStream("images/Files.png"));
        Button chooseFileButton = new Button();
        chooseFileButton.setGraphic(new ImageView(chooseFileImage));
        chooseFileButton.setStyle("-fx-background-color: Black");

        chooseFileButton.setOnAction((ActionEvent e) -> chooseFile());

        chooseFileButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            chooseFileButton.setStyle("-fx-background-color: Black");
            chooseFileButton.setStyle("-fx-body-color: Black");
        });
        chooseFileButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            chooseFileButton.setStyle("-fx-background-color: Black");
        });


        //PAUSE_BUTTON:
        Image pauseButtonImage = new Image(getClass().getResourceAsStream("images/Pause.png"));
        Button pauseButton = new Button();
        pauseButton.setGraphic(new ImageView(pauseButtonImage));
        pauseButton.setStyle("-fx-background-color: Black");

        pauseButton.setOnAction((ActionEvent e) -> pauseFile());

        pauseButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            pauseButton.setStyle("-fx-background-color: Black");
            pauseButton.setStyle("-fx-body-color: Black");

        });
        pauseButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            pauseButton.setStyle("-fx-background-color: Black");
        });


        // FORWARD_BUTTON:
        Image forwardButtonImage = new Image(getClass().getResourceAsStream("images/Forward.png"));
        Button forwardButton = new Button();
        forwardButton.setGraphic(new ImageView(forwardButtonImage));
        forwardButton.setStyle("-fx-background-color: Black");

        forwardButton.setOnAction((ActionEvent e) -> moveForward());

        forwardButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            forwardButton.setStyle("-fx-background-color: Black");
            forwardButton.setStyle("-fx-body-color: Black");
        });
        forwardButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            forwardButton.setStyle("-fx-background-color: Black");
        });


        //BACKWARD_BUTTON:
        Image backwardButtonImage = new Image(getClass().getResourceAsStream("images/Back.png"));
        Button backwardButton = new Button();
        backwardButton.setGraphic(new ImageView(backwardButtonImage));
        backwardButton.setStyle("-fx-background-color: Black");

        backwardButton.setOnAction((ActionEvent e) -> moveBackward());

        backwardButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            backwardButton.setStyle("-fx-background-color: Black");
            backwardButton.setStyle("-fx-body-color: Black");
        });
        backwardButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            backwardButton.setStyle("-fx-background-color: Black");
        });

        //SLIDER:


        toolBar.getChildren().addAll(chooseFileButton, backwardButton, playButton, pauseButton, forwardButton);

        return toolBar;
    }
}
