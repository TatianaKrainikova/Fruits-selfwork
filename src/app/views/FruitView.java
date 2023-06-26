package app.views;

import app.controllers.ReadData;
import app.models.Fruit;
import java.util.List;

public class FruitView {

    private static List<Fruit> getData() {
        ReadData readData = new ReadData();
        return readData.selectALl();
    }

    private static void showData(List<Fruit> fruits) {
        int count = 0;
        for (Fruit fruit : fruits) {
            System.out.printf("%d. %s%n%s%n%n", count, fruit.name, fruit.description);
        }
    }
}
