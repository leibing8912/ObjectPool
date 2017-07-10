package module.jk.cn.objectpool;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @className: TestInvocationHandler
 * @classDescription: 动态代理类
 * @author: leibing
 * @createTime: 2017/7/10
 */
public class TestInvocationHandler implements InvocationHandler {
    // 日志标识
    private String TAG = "TestInvocationHandler";

    // 需要被代理的对象
    private Object target;

    /**
      * 指定需被代理的对象
      * @author leibing
      * @createTime 2017/7/10
      * @lastModify 2017/7/10
      * @param target
      * @return
      */
    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 被代理方法被执行前处理
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

        // 以target作为主调来执行method方法
        Object result = method.invoke(target, args);

        // 被代理方法被执行后处理
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long endTime = System.currentTimeMillis();

        Log.e(TAG, "#memory cost " + (endMemory - startMemory)/1024 + " Byte");
        Log.e(TAG, "#time cost " + (endTime - startTime) + " ms");
        return result;
    }
}
