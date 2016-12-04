package crazysheep.io.scanner.net;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 解决反序列化中范型无法确定的问题，see{@link http://blog.csdn.net/canchew/article/details/7545363}
 *
 * Created by yang.li on 2016/12/3.
 */
public class EntityWrapper<T> {

    private Type tType;

    public EntityWrapper() {
        Type wrapperType = getClass().getGenericSuperclass();
        tType = ((ParameterizedType) wrapperType).getActualTypeArguments() [0];
    }

    public Type entity() {
        return tType;
    }
}
