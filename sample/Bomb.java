package sample;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Sprite {

    private boolean isDead = false;

    private final String fileName = "Bomb.png";

    private final static int coastCreate = 100;

    public Bomb(double x, double y) {
        super(x, y);
        setImage(fileName);
        bombs.add(this);

    }

    public void setDead(Boolean dead){
        isDead = dead;
    }

    public Boolean getDead(){ return isDead; }

    static List<Bomb> bombs = new ArrayList<>();

    public static boolean canCreate() {
        return MoneyCount.getMoney() >= coastCreate;
    }

    public static int getCoastCreate(){
        return coastCreate;
    }
}
