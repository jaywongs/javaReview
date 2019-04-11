package jay.singleton;

/**
 * Created by jaywangs on 2019/3/16
 */
public class SingletonSychronized {
    private volatile static SingletonSychronized uniqueInstance;
    private SingletonSychronized(){

    }
    public SingletonSychronized getUniqueInstance(){
        if (uniqueInstance == null) {
            synchronized (SingletonSychronized.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonSychronized();
                }
            }
        }
        return uniqueInstance;
    }
}
