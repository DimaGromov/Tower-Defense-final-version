package sample;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Controller implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        if(Bomb.canCreate()) {
            double x = event.getX();
            double y = event.getY();

            if(x > 900) {
                return;
            }

            MoneyCount.sendMoney(Bomb.getCoastCreate());

            boolean inter = false;
            Enemys tempEnemy = null;

            Bomb newBomb = new Bomb(x, y);

            for (Enemys enemy : Enemys.enemys) {
                if(enemy.intersects(newBomb)){
                    tempEnemy = enemy;
                    inter = true;
                }
            }

            if(inter) {
                Enemys.enemys.remove(tempEnemy);
                newBomb.setDead(true);
                newBomb.setImage("flame.gif");
                MoneyCount.addMoney(100);
            }
        }

    }
}
