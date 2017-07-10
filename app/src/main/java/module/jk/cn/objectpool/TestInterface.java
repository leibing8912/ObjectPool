package module.jk.cn.objectpool;

/**
 * @interfaceName:TestInterface
 * @interfaceDescription: 测试接口
 * @author: leibing
 * @createTime: 2017/7/10
 */
public interface TestInterface {
    /**
     * 通过对象池获取对象
     */
    void getObjectByPool();

    /**
     * 通过new获取对象
     */
    void getObjectByNew();
}
