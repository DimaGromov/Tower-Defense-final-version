package sample;

import java.util.ArrayList;

public class Healths extends Sprite {

    final String fileName = "healths.png";
    public static ArrayList<Healths> health = new ArrayList<>();

    public Healths(){
        setImage(fileName);
    }

    public void getHealth(){

        Healths hp1 = new Healths();
        hp1.setPositionX(900, 36);
        health.add(hp1);

        Healths hp2 = new Healths();
        hp2.setPositionX(940, 36);
        health.add(hp2);

        Healths hp3 = new Healths();
        hp3.setPositionX(980,36);
        health.add(hp3);

    }

}
