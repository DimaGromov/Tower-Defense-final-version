package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Main extends Application {

    public static volatile double frequencyEnemyCreation = 500 + Math.random()*2000;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle( "TD v0.01" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        primaryStage.setScene( theScene );
        Canvas canvas = new Canvas( 1200, 600 );
        root.getChildren().add( canvas );

        theScene.setOnMouseClicked(new Controller());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image background = new Image("Background.jpg");

        gc.drawImage(background,0,0);

        Healths hp = new Healths();
        hp.getHealth();

        Display display = new Display(gc, background, primaryStage,hp);
        Menu menu = new Menu(primaryStage, display, theScene);
        menu.ShowMenu();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(frequencyEnemyCreation), ae -> {
            new Enemys();
        }));
        timeline.setCycleCount(100);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

