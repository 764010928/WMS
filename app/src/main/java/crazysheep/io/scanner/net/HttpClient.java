package crazysheep.io.scanner.net;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import crazysheep.io.scanner.BuildConfig;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 网络端
 * <p>
 * Created by yang.li on 2016/11/27.
 */
public class HttpClient {
    public String Token="";

    public static void init(String baseUrl) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .addInterceptor(new RequestInterceptor());
        if (BuildConfig.DEBUG) {
            // 打印网络请求log
            clientBuilder.addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        httpClient = new HttpClient(clientBuilder.build(), baseUrl);
    }

    private static HttpClient httpClient;

    protected static HttpClient getInstance() {
        return httpClient;
    }

    /**
     * 取消一个网络请求
     */
    public static void cancel(String tag) {
        Call call = httpClient.callMap.get(tag);
        if (call != null && !call.isCanceled()) {
            call.cancel();
            httpClient.callMap.remove(tag);
        }
    }

    /////////////////////////////////////////////////

    private Gson gson;
    private OkHttpClient okHttpClient;
    private UrlHandler urlHandler;
    private HashMap<String, Call> callMap;

    private HttpClient(OkHttpClient okHttpClient, String baseUrl) {
        this.okHttpClient = okHttpClient;
        this.urlHandler = new UrlHandler(baseUrl);
        this.gson = new Gson();
        this.callMap = new HashMap<>();
    }

    protected void putCall(@NonNull String tag, @NonNull Call call) {
        if (callMap.get(tag) != null) {
            throw new RuntimeException(
                    String.format("-HttpClient.putCall()-, tag %s is already used", tag));
        }

        if (!call.isCanceled()) {
            callMap.put(tag, call);
        }
    }

    protected void removeCall(@NonNull String tag) {
        callMap.remove(tag);
    }

    protected Gson getGson() {
        return this.gson;
    }

    /**
     * GET请求
     *
     * @param url       请求的url
     * @param queryMaps url后面拼接用的参数
     * @param callback  请求成功的callback
     * @return 本次请求的tag，可用于取消本次请求
     */
    protected <T> String get(
            @NonNull String url,
            @Nullable Map<String, String> queryMaps,
            @NonNull Class<T> tClass,
            @Nullable final Callback<T> callback) {
        String processedUrl = urlHandler.process(url);
        String finalUrl = urlHandler.handleQuerys(processedUrl, queryMaps);
        final Request request = new Request.Builder()
                .url(finalUrl)
                .header("TerminalToken",Token)
                .get()
                .build();
        String requestTag = String.format("GET#%s#%s", System.currentTimeMillis(),
                processedUrl);
        Call call = okHttpClient.newCall(request);
        putCall(requestTag, call); // 将本次的call放入callMap
        call.enqueue(new CallbackDelegate<>(httpClient, requestTag, tClass, callback));
        return requestTag;
    }

    /**
     * POST请求
     *
     * @param url       请求的url
     * @param queryMaps url后面拼接用的参数
     * @param params    POST方法的body传递的参数，注意不能为空
     * @param callback  请求成功的callback
     */
    protected <T> String post(
            @NonNull String url,
            @NonNull Map<String, String> params,
            @Nullable Map<String, String> queryMaps,
            @NonNull Class<T> tClass,
            @Nullable Callback<T> callback,
            @Nullable Callback<Throwable> failedCallback) {
        String processedUrl = urlHandler.process(url);
        String finalUrl = urlHandler.handleQuerys(processedUrl, queryMaps);
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            bodyBuilder.add(entry.getKey(), entry.getValue());
        }
        Request request = new Request.Builder()
                .url(finalUrl)
                .post(bodyBuilder.build())
                .build();
        String requestTag = String.format("POST#%s#%s", System.currentTimeMillis(),
                processedUrl);
        Call call = okHttpClient.newCall(request);
        putCall(requestTag, call); // 将本次的call放入callMap
        call.enqueue(new CallbackDelegate<>(httpClient, requestTag, tClass, callback));
        return requestTag;
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 参数太计较方式为json的post
     * @param url
     * @param json
     * @param queryMaps
     * @param tClass
     * @param callback
     * @param <T>
     * @return
     */
    protected <T> String post(@NonNull String url,
                              @NonNull String json,
                              @Nullable Map<String, String> queryMaps,
                              @NonNull Class<T> tClass,
                              @Nullable Callback<T> callback) {
        String processedUrl = urlHandler.process(url);
        String finalUrl = urlHandler.handleQuerys(processedUrl, queryMaps);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(finalUrl)
                .header("TerminalToken",Token)
                .post(body)
                .build();
        String requestTag = String.format("POST#%s#%s", System.currentTimeMillis(),
                processedUrl);
        Call call = okHttpClient.newCall(request);
        putCall(requestTag, call); // 将本次的call放入callMap
        call.enqueue(new CallbackDelegate<>(httpClient, requestTag, tClass, callback));
        return requestTag;
    }

}
