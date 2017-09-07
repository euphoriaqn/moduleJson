package HomeworkJson;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.*;

/**
 * Created by user22 on 31.08.2017.
 */
public class TradeShop {
    //Баланс лавки
    private int moneyBalance = 0;

    public int getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(int moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    //Всі продукти, які зберігаються на складу продуктової
    public ArrayList<Fruit> fruits = new ArrayList<>();
    //Зберігає зв'язки  -  поставка та дата поставки
    private ArrayList<Pair> pair = new ArrayList<>();

    //Функція для додавання нової поставки без фіксованої дати поставки
    public void addFruits(String pathToJsonFile) throws IOException {
        String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
        TradeShop tradeShop = JSON.parseObject(json, TradeShop.class);
        for (Fruit value : tradeShop.fruits) {
            fruits.add(value);
        }
        moneyBalance = tradeShop.getMoneyBalance();
    }

    //Функція для додавання нової поставки з фіксованою датою поставки
    public void addFruitsWithDateOfSupply(String pathToJsonFile, Date date) throws IOException {
        String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
        TradeShop tradeShop = JSON.parseObject(json, TradeShop.class);
        for (Fruit value : tradeShop.fruits) {
            fruits.add(value);
        }
        pair.add(new Pair(date, tradeShop.fruits));
    }

    //Зюерігає всю інформацію зі складу лавки до json-файлу
    public void save(String pathToJsonFile) throws IOException {
        //  String json = JSON.toJSONSt  ring(tradeShop);
        TradeShop tradeShop1 = new TradeShop();
        tradeShop1.fruits = this.fruits;
        tradeShop1.setMoneyBalance(this.moneyBalance);
        String json = JSON.toJSONStringWithDateFormat(tradeShop1, "dd/MM/yyyy");
        FileWriter writer = new FileWriter(pathToJsonFile);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    //Видаляє поточну інфмормацію з коллекції та завантажує нову зі збереженої  копії
    public void load(String pathToJsonFile) throws IOException {
        fruits.clear();
        addFruits(pathToJsonFile);
      //  moneyBalance =
    }

    //Функція, що повертає продукти, які будуть зіпсовані до заданої дати
    public ArrayList<Fruit> getSpoiledFruits(Date date) {
        ArrayList<Fruit> spoiledList = new ArrayList<>();
        for (Fruit value : fruits) {
            if (value.getDate().after(date))
                spoiledList.add(value);
        }
        return spoiledList;
    }

    //Функція, що повертає продукти, які будуть не зіпсовані до заданої дати
    public ArrayList<Fruit> getAvailableFruits(Date date) {
        ArrayList<Fruit> spoiledList = new ArrayList<>();
        for (Fruit value : fruits) {
            if ((value.getDate().before(date)) || (value.getDate().equals(date)))
                spoiledList.add(value);
        }
        return spoiledList;
    }

    //Функція, що повертає продукти заданого типу, які будуть зіпсовані до заданої дати
    public ArrayList<Fruit> getSpoiledFruits(Date date, Fruit.typeOfFruit type) {
        ArrayList<Fruit> spoiledList = new ArrayList<>();
        for (Fruit value : fruits) {
            if (value.getDate().after(date) && value.getType() == type)
                spoiledList.add(value);
        }
        return spoiledList;
    }

    //Функція, що повертає продукти заданого типу, які будуть не зіпсовані до заданої дати
    public ArrayList<Fruit> getAvailableFruits(Date date, Fruit.typeOfFruit type) {
        ArrayList<Fruit> spoiledList = new ArrayList<>();
        for (Fruit value : fruits) {
            if (((value.getDate().before(date)) || (value.getDate().equals(date))) && (value.getType() == type))
                spoiledList.add(value);
        }
        return spoiledList;
    }

    //Функція, що повертає продукти, які були поставлені до  заданої дати
    public ArrayList<Fruit> getAddedFruits(Date date) {
        ArrayList<Fruit> arrayList = new ArrayList<>();
        for (int i = 0; i < pair.size(); i++) {
            if (pair.get(i).key == date)
                for (int j = 0; j < pair.get(i).value.size(); j++)
                    arrayList.add(pair.get(i).value.get(j));
        }
        return arrayList;
    }

    //Функція, що повертає продукти заданого типу, які були поставлені до заданої дати
    public ArrayList<Fruit> getAddedFruits(Date date, Fruit.typeOfFruit type) {
        ArrayList<Fruit> arrayList = new ArrayList<>();
        for (int i = 0; i < pair.size(); i++) {
            if (pair.get(i).key == date)
                for (int j = 0; j < pair.get(i).value.size(); j++) {
                    if (pair.get(i).value.get(j).getType() == type)
                        arrayList.add(pair.get(i).value.get(j));
                }
        }
        return arrayList;
    }
    //Функція, що повертає кількість фруктів заданого типу у лавці
    public int countOfFruits(Fruit.typeOfFruit typeOfFruit) {
        int countOfFruits = 0;
        for (Fruit value : fruits) {
            if (value.getType() == typeOfFruit)
                countOfFruits += 1;
        }
        return countOfFruits;
    }
    //Функція продажу продуктів з лавки у відповідності до замовлень
    public void sell(String pathToJsonFile) throws IOException {
        String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
        Person person = JSON.parseObject(json, Person.class);
        for (Client value : person.clients) {
            int countOfFr = countOfFruits(value.getType());
            if (countOfFr >= value.getCount()) {
                for (int i = 0; i < fruits.size(); i++) {
                    if (fruits.get(i).getType() == value.getType())
                        moneyBalance+=fruits.get(i).getPrice();
                        fruits.remove(i);
                    }
                }
            }
     //Зберігаємо поточний стан лавки
            save("files/lavka.txt");

        }
    }