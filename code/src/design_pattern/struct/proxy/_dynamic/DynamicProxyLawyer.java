package design_pattern.struct.proxy._dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyLawyer implements InvocationHandler {

    //被代理的对象
    private Object target;

    public DynamicProxyLawyer(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("案件进展："+method.getName());
        Object result=method.invoke(target,args);
        return result;
    }
}
