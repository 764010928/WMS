package crazysheep.io.scanner.net;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.IOException;

import crazysheep.io.scanner.utils.L;
import okhttp3.Call;
import okhttp3.Response;

/**
 * {@link Callback}的代理类，拦截请求，处理通用的逻辑
 *
 * Created by yang.li on 2016/12/3.
 */
class CallbackDelegate<T> implements okhttp3.Callback {

    private static final Handler uiHandler = new Handler(Looper.getMainLooper());

    private HttpClient httpClient;
    private String tag;
    private Class<T> tClass;
    private Callback<T> callback;

    public CallbackDelegate(
            HttpClient httpClient,
            String tag,
            @NonNull Class<T> tClass,
            @Nullable  Callback<T> callback) {
        this.callback = callback;
        this.httpClient = httpClient;
        this.tClass = tClass;
        this.tag = tag;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        invokeFailedCallback(callback, call, e);
        httpClient.removeCall(tag);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (!response.isSuccessful()) {
            invokeFailedCallback(callback, call, new Throwable(response.toString()));
        } else {
            // TODO 有没有不传入Class<T>实现反序列化的方法？
            try {
                T result = httpClient.getGson().fromJson(response.body().charStream(), tClass);
                L.i("-CallbackDelegate.onRepsonse()-, result: " + result);
                invokeSuccessCallback(callback, call, result);
            } catch (Exception e) {
                invokeFailedCallback(callback, call, e);
            }
        }
        httpClient.removeCall(tag);
    }

    private void invokeSuccessCallback(@Nullable final Callback<T> callback,
                                       Call call, final T result) {
        if (callback != null) {
            callback.setRequestUrl(call.request().url().toString());
            uiHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess(result);
                    callback.onComplete();
                }
            });
        }
    }

    private void invokeFailedCallback(@Nullable final Callback callback,
                                      Call call, final Throwable throwable) {
        if (callback != null) {
            callback.setRequestUrl(call.request().url().toString());
            uiHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onFailed(throwable);
                    callback.onComplete();
                }
            });
        }
    }
}
