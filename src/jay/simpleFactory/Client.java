package jay.simpleFactory;

/**
 * Created by jaywangs on 2019/4/9
 */
public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
    }
}
