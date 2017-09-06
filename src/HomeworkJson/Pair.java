package HomeworkJson;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user22 on 05.09.2017.
 */
//класс необхідний для зберігання Дати поставки та Списку фруктів
public class Pair {
    public Date key;
    public ArrayList<Fruit> value = new ArrayList<>();

    public Pair() {
    }
        public Pair(Date key, ArrayList<Fruit> value) {
        this.key = key;
        for (Fruit svalue: value) {
            this.value.add(svalue);
        }
    }

    public Date getKey() {
        return key;
    }

    public void setKey(Date key) {
        this.key = key;
    }

    public ArrayList<Fruit> getValue() {
        return value;
    }

    public void setValue(ArrayList<Fruit> value) {
        this.value = value;
    }
}
