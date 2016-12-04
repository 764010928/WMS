package crazysheep.io.scanner.net;

/**
 * 网络回调
 *
 * Created by yang.li on 2016/12/3.
 */
public abstract class Callback<T> implements ICallback<T>  {

    private String requestUrl;

    protected final void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public void onComplete() {
    }

    @Override
    public abstract void onSuccess(T t);

    @Override
    public abstract void onFailed(Throwable throwable);
}
