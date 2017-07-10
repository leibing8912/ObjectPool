package module.jk.cn.objectpool;

import android.support.v4.util.Pools;

/**
 * @className: TestClass
 * @classDescription: 测试对象
 * @author: leibing
 * @createTime: 2017/7/10
 */
public class TestClass {
    // 对象池
    private static final Pools.SynchronizedPool<TestClass> sPool
            = new Pools.SynchronizedPool<TestClass>(1);

    /**
      * 获取对象中数据
      * @author leibing
      * @createTime 2017/7/10
      * @lastModify 2017/7/10
      * @param
      * @return
      */
    public static TestClass obtain(){
        TestClass acquire = sPool.acquire();
        if (acquire == null){
            return new TestClass();
        }
        return acquire;
    }

    /**
      * 清空对象
      * @author leibing
      * @createTime 2017/7/10
      * @lastModify 2017/7/10
      * @param
      * @return
      */
    public void recycle(){
        sPool.release(this);
    }
}
