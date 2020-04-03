package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ConcurrentModificationException;

public class Display extends AnimationTimer {
    GraphicsContext graphicsContext;
    Image background;
    Stage primaryStage;
    final int[] healths = {3};
    Healths hp;


    Display(GraphicsContext graphicsContext, Image background, Stage primaryStage, Healths hp) {
        this.graphicsContext = graphicsContext;
        this.background = background;
        this.primaryStage = primaryStage;
        this.primaryStage.show();
        this.hp = hp;
    }


    @Override
    public void handle(long now) {
        graphicsContext.clearRect(0,0,1200,600);

        graphicsContext.drawImage(background,0,0);


        for (Bomb bomb: Bomb.bombs) {
            bomb.render(graphicsContext);
        }



        try{
            for (Enemys enemy : Enemys.enemys) {

                enemy.render(graphicsContext);
                enemy.move();


                if (enemy.getPositionX() >= 800){
                    healths[0] --;
                    hp.health.remove(healths[0]);
                    Enemys.enemys.remove(enemy);
                }
                if (healths[0] == 0){
                    Menu.GameOver();
                    this.stop();
                }
            }
            for( Healths HP : hp.health){
                HP.render(graphicsContext);
            }
        } catch (ConcurrentModificationException ex) {}

        String pointsText = "Money: " + MoneyCount.getMoney();
        graphicsContext.fillText( pointsText, 700, 36 );
        graphicsContext.strokeText( pointsText, 700, 36);

    }
}

