package jay.singleton;

/**
 * Created by jaywangs on 2019/4/9
 */
public class singletonTest {

    private volatile static singletonTest uniqueInstance;

    private singletonTest(){

    }

    public static singletonTest getSingletonTest(){
        if (uniqueInstance == null) {
            synchronized (singletonTest.class) {
                if (uniqueInstance == null)
                    uniqueInstance = new singletonTest();
            }
        }
        return uniqueInstance;
    }
}
