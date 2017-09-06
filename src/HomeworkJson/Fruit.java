package HomeworkJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import sun.util.calendar.BaseCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user22 on 31.08.2017.
 */
public class Fruit {

        private typeOfFruit type;
        private int shelfLife;
       // @JSONField(format = "dd/MM/yyyy")
        private Date date;
        private int price;
    enum typeOfFruit {strawberry,  pear, watermelon, Banana,
        orange, mandarin, Apple, kiwi, pineapple, raspberries}


    public Fruit(typeOfFruit type,int shelfLife, Date date, int price) {
        this.type = type;
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }

    public typeOfFruit getType() {
        return type;
    }

    public void setType(typeOfFruit type) {
        this.type = type;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
