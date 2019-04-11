package jay.factoryMethod;

import jay.simpleFactory.ConcreteProduct1;
import jay.simpleFactory.Product;

/**
 * Created by jaywangs on 2019/4/9
 */
public class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
