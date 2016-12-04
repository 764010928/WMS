package crazysheep.io.scanner.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 拦截网络请求，处理requet的通用逻辑，比如添加headers
 *
 * Created by yang.li on 2016/12/3.
 */
class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();
        requestBuilder.addHeader("Accept", "application/json");
        return chain.proceed(requestBuilder.build());
    }
}
