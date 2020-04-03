package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Menu {

    private static Stage primaryStage;
    private Display display;
    private Scene theScene;

    public Menu(Stage primaryStage, Display display, Scene theScene){
        Menu.primaryStage = primaryStage;
        this.display = display;
        this.theScene = theScene;
    }

    public void ShowMenu(){
        Group menu = new Group();
        ImageView background = new ImageView(new Image("Background.jpg"));
        Button Start = getButton("Let's go!");
        Button Exit = getButton("Exit");

        Start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(theScene);
                display.start();
            }
        });

        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        menu.getChildren().addAll(background, Start, Exit);

        Scene MenuScene = new Scene(menu, 800, 600);
        primaryStage.setScene(MenuScene);
        primaryStage.show();
    }

    public static void GameOver(){
        Group gameOver = new Group();
        ImageView background = new ImageView(new Image("Background.jpg"));
        Button end = getButton("Game Over =(");

        end.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        gameOver.getChildren().addAll(background,end);

        Scene KO = new Scene(gameOver);
        primaryStage.setScene(KO);
        primaryStage.show();
    }

    public static Button getButton(String str){
        if (str.equals("Let's go!")){
            Button bt = new Button(str);
            bt.setLayoutX(300);
            bt.setLayoutY(300);
            bt.setScaleX(2);
            bt.setScaleY(2);
            return bt;
        }else if (str.equals("Exit")) {
            Button bt = new Button(str);
            bt.setLayoutX(500);
            bt.setLayoutY(300);
            bt.setScaleX(2);
            bt.setScaleY(2);
            return bt;
        }else {
            Button bt = new Button(str);
            bt.setLayoutX(600);
            bt.setLayoutY(300);
            bt.setScaleX(3);
            bt.setScaleY(3);
            return bt;
        }

    }

}
