package HomeworkJson;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user22 on 31.08.2017.
 */
public class Program {
    public static void main(String[] args) throws IOException {
        JSON.DEFFAULT_DATE_FORMAT = "dd/MM/yyyy";
        TradeShop tradeShop = new TradeShop();
//        JSON.toJSONString(tradeShop, SerializerFeature.WriteDateUseDateFormat);
        //тут происходит добавление в коллекцию из JSON-файла №1
        Date date1 = new Date(117, 4,9);
        Date date4 = new Date(117, 3,9);
        Date date5 = new Date(117, 2,9);
        tradeShop.addFruitsWithDateOfSupply("files/jsonFruits.txt", date1);
        //тут происходит сохранение в JSON-файл №2 и нарушение структур
        tradeShop.addFruitsWithDateOfSupply("files/jsonFruits.txt", date4);
        tradeShop.addFruitsWithDateOfSupply("files/jsonFruits.txt", date4);
     //   show(tradeShop.getAddedFruits(date4));
        show(tradeShop.getAddedFruits(date4, Fruit.typeOfFruit.Banana));
        System.out.println();
        tradeShop.save("files/lavka.txt");
//
         tradeShop.load("files/lavka.txt");
            show(tradeShop.fruits);

         tradeShop.sell("files/clients.txt");
        System.out.println();
            show(tradeShop.fruits);
        System.out.println("" + tradeShop.getMoneyBalance());

//       // public Date(int year, int month, int date)
//
//        Date date2 = new Date(117, 6,9);
//        Date date3 = new Date(117, 6,10);
//        show(tradeShop.getSpoiledFruits(date2));
//        show(tradeShop.getAvailableFruits(date3));
//        show(tradeShop.getSpoiledFruits(date2, Fruit.typeOfFruit.Banana));
//        show(tradeShop.getAvailableFruits(date3, Fruit.typeOfFruit.Banana));

    }
    public static void show(ArrayList<Fruit> arrayList){
        for (Fruit value: arrayList) {
            System.out.println(value.getType());
        }
    }
}