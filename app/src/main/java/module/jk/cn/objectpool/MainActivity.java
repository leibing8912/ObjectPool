package module.jk.cn.objectpool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @className: MainActivity
 * @classDescription: 对象池测试页
 * @author: leibing
 * @createTime: 2017/7/10
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // 代理对象
    TestInterface proxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建一个原始的TestInterface对象,作为target
        TestInterface target = new TestImpl();
        try {
            // 以指定的target来创建动态代理
             proxy= (TestInterface) TestProxyFactory.getProxy(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // onClick
        findViewById(R.id.btn_object_pool).setOnClickListener(this);
        findViewById(R.id.btn_new_object).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_new_object:
                // new对象
                if (proxy != null)
                    proxy.getObjectByNew();
                break;
            case R.id.btn_object_pool:
                // 对象池处理
                if (proxy != null)
                    proxy.getObjectByPool();
                break;
            default:
                break;
        }
    }
}
