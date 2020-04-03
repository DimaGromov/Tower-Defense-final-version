package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class Enemys extends Sprite {

    private static int counterEnemys = 0;

    final String fileName = "Enemy.gif";

    public Enemys() {
        super();
        setImage(fileName);
        this.setPositionX(((int) (Math.random() * 400)), ((int) (150 + Math.random() * 400)));
        enemys.add(this);

        if(counterEnemys > 10){
            this.setVelocityX(Speed.TWO);
        } else if (counterEnemys > 20) {
            this.setVelocityX(Speed.THREE);
        } else if (counterEnemys > 50) {
            this.setVelocityX(Speed.FOUR);
        } else {
            this.setVelocityX(Speed.ONE);
        }


        counterEnemys++;
    }

    public static  ArrayList<Enemys> enemys = new ArrayList<>();

    public void move(){

        this.update(3);

        checkCollision();
    }

    private void checkCollision() {
        boolean inter = false;

        for (Bomb bomb : Bomb.bombs) {
            if(this.intersects(bomb) && !bomb.getDead()){
                inter = true;

                bomb.setDead(true);
                bomb.setImage("flame.gif");
                setWidth(0,0);

            }
        }

        if (inter) {
            Enemys.enemys.remove(this);
            MoneyCount.addMoney(100);
        }
    }
}
