package topic5.task4.action;

import topic5.task4.entity.Treasure;
import topic5.task4.entity.TreasureCollection;
import topic5.task4.enumeration.TypesOfTreasures;

import java.io.*;

public class FillTreasureCollection {

    private static final String FILE_PATH = "src\\topic5\\task4\\Treasures.txt";

    public static TreasureCollection fill() {
        TreasureCollection treasureCollection = new TreasureCollection();

        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            while (bufferedReader.ready()) {
                String[] oneTreasure = bufferedReader.readLine().trim().split("\\s+");
                TypesOfTreasures name = TypesOfTreasures.valueOf(oneTreasure[0]);

                double cost = Double.valueOf(oneTreasure[1]);
                Treasure treasure = new Treasure(name, cost);
                if (oneTreasure.length == 3) {
                    treasure.setQuantity(Integer.valueOf(oneTreasure[2]));
                }
                treasureCollection.addTreasure(treasure);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
            e.printStackTrace();
        }

        return treasureCollection;
    }
}
