package jay.rpc;

/**
 * Created by jaywangs on 2019/4/17
 */
public class HelloWorldImpl implements HelloWorldService {
    @Override
    public String sayHelloWorld(String msg) {
        String str = "Hello World" + msg;
        System.out.println(str);
        return str;
    }
}
