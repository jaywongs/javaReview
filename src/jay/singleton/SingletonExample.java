package jay.singleton;

/**
 * Created by jaywangs on 2019/3/14
 */
public class SingletonExample {
    private static SingletonExample singletonExample = null;
    private SingletonExample(){}
    public static SingletonExample getSingletonExample(){
        if (singletonExample == null)
            singletonExample = new SingletonExample();
        return singletonExample;
    }


}
