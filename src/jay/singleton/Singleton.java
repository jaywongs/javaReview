package jay.singleton;

/**
 * Created by jaywangs on 2019/3/14
 */
public class Singleton {
    private static volatile Singleton singleton = null;
    private Singleton(){}
    public static Singleton getSingleton(){
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }

    // 创建单例之静态内部类方法
    static class Holder {
        private static Singleton singleton2 = new Singleton();
    }

    public static Singleton getSingleton2() {
        return Holder.singleton2;
    }

    //枚举实现单例
    public enum Singleton3 {
        INSTANCE;

    }
}
