package design_pattern.struct.proxy._dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Object getDynProxy(Object target) {
        InvocationHandler handler = new DynamicProxyLawyer(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
