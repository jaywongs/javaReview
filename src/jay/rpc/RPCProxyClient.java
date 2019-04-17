package jay.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jaywangs on 2019/4/17
 */
public class RPCProxyClient implements InvocationHandler {
    private Object obj;

    public RPCProxyClient(Object obj){
        this.obj = obj;
    }

    /**
     * 得到被代理的对象
     **/

    public static Object getProxy(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),new RPCProxyClient(obj));
    }

    @Override
    /**
     * 调用该方法执行
     **/
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = new Object();
        //执行通信相关逻辑

        return result;
    }
}
