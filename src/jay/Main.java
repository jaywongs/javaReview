package jay;

import java.util.Arrays;
import java.util.List;

class Fruit{ }
class Apple extends Fruit{ }
class Orange extends Fruit{ }
public class Main {

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Orange> oranges = Arrays.asList(new Orange());
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static class CovariantReader<T>{
        T readCovariant(List<? extends T> list){
            return list.get(0);
        }
    }

    static void f1() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
        Fruit f = fruitReader.readCovariant(apples);
    }


    public static void main(String[] args) {
	// write your code here
        f1();
    }
}
