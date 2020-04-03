package sample;

public class MoneyCount {
    private static int money = 1000;



    public static int getMoney() {
        return money;
    }

    public static void sendMoney(int coast) {
        money -= coast;
    }

    public static void addMoney(int coast) {
        money += coast;
    }
}
