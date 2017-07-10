package module.jk.cn.objectpool;

import java.lang.reflect.Proxy;

/**
 * @className: TestProxyFactory
 * @classDescription: 代理factory
 * @author: leibing
 * @createTime: 2017/7/10
 */
public class TestProxyFactory {

    /**
      * 为指定target生成动态代理对象
      * @author leibing
      * @createTime 2017/7/10
      * @lastModify 2017/7/10
      * @param
      * @return
      */
    public static Object getProxy(Object target) throws Exception {
        // 创建一个TestInvocationHandler对象
        TestInvocationHandler handler = new TestInvocationHandler();
        // 为TestInvocationHandler设置target对象
        handler.setTarget(target);
        // 创建,并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }
}
