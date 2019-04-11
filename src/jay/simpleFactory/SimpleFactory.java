package jay.simpleFactory;

/**
 * Created by jaywangs on 2019/4/9
 */
public class SimpleFactory {

    Product product;
    public Product createProduct(int type){
        if (type == 1){
            product = new ConcreteProduct1();
        }else if (type == 2){
            product = new ConcreteProduct2();
        }else {
            product = new ConcreteProduct();
        }
        return product;
    }
}
