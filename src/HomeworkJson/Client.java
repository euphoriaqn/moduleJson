package HomeworkJson;

/**
 * Created by user22 on 06.09.2017.
 */
public class Client {
    private String name;
    private Fruit.typeOfFruit type;
    private int count;

    public Client(String name, Fruit.typeOfFruit type, int count) {
        this.name = name;
        this.type = type;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fruit.typeOfFruit getType() {
        return type;
    }

    public void setType(Fruit.typeOfFruit type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
