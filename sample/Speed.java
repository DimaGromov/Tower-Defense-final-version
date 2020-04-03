package sample;

public enum Speed {
    ONE(1), TWO(2), THREE(3), FOUR(4);

    private int speed;

    Speed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
}
