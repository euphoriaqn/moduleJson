package HomeworkJson;

/**
 * Created by user22 on 06.09.2017.
 */
public class Client {
    public String name;
    public Fruit.typeOfFruit type;
    public int count;

    public Client(String name, Fruit.typeOfFruit type, int count) {
        this.name = name;
        this.type = type;
        this.count = count;
    }

}
