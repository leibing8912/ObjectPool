package module.jk.cn.objectpool;

import android.util.Log;

/**
 * @className: TestImpl
 * @classDescription: 测试实现类
 * @author: leibing
 * @createTime: 2017/7/10
 */
public class TestImpl implements TestInterface{
    // 日志标识
    private final static String TAG = "TestImpl";

    @Override
    public void getObjectByPool() {
        for (int i=0;i<10;i++){
            Log.e(TAG, "#getObejctByPool mTestClass = " + TestClass.obtain());
        }
    }

    @Override
    public void getObjectByNew() {
        for (int i=0;i<10;i++){
            Log.e(TAG, "#getObjectByNew mTestClass = " + new TestClass());
        }
    }
}
