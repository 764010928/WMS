package crazysheep.io.scanner.net;

import android.text.TextUtils;

import java.util.Map;

/**
 * url处理器
 *
 * Created by yang.li on 2016/12/3.
 */
class UrlHandler {

    private String baseUrl;

    public UrlHandler(String baseUrl) {
        if (TextUtils.isEmpty(baseUrl)) {
            throw new IllegalArgumentException("-UrlHandler.init-, base url不能为空");
        }

        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String process(String originUrl) {
        if (TextUtils.isEmpty(originUrl)) {
            throw new IllegalArgumentException("-UrlHandler.process-, origin url不能为空");
        }

        if (originUrl.startsWith("http://")
                || originUrl.startsWith("https://")) {
            return originUrl;
        }

        if (originUrl.startsWith("/")) {
            return baseUrl + originUrl;
        } else {
            return baseUrl + "/" + originUrl;
        }
    }

    public String handleQuerys(String url, Map<String, String> querys) {
        String finalUrl = process(url);

        if (querys == null || querys.entrySet().size() == 0) {
            return finalUrl;
        }

        finalUrl += "?";
        for (Map.Entry<String, String> entry : querys.entrySet()) {
            finalUrl += String.format("%s=%s&", entry.getKey(), entry.getValue());
        }
        finalUrl = finalUrl.substring(0, finalUrl.length() - 1);

        return finalUrl;
    }
}
