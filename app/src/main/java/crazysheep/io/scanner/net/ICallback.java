package crazysheep.io.scanner.net;

/**
 * 网络回调
 *
 * Created by yang.li on 2016/12/3.
 */
public interface ICallback<T> {
    void onSuccess(T t);
    void onFailed(Throwable throwable);
    void onComplete();
}
