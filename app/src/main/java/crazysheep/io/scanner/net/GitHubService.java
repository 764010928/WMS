package crazysheep.io.scanner.net;

import com.google.gson.Gson;

import crazysheep.io.scanner.net.Entity.LoginEntity;
import crazysheep.io.scanner.net.Entity.UserEntity;

/**
 * github的service，测试网络框架
 * <p>
 * Created by yang.li on 2016/12/3.
 */
public class GitHubService implements ApiService {

    private static final String URL_LOGIN = "/o2o/terminal/login.do";
    private String USER_TOKEN = "";

    public String Login(String username, String pwd, final Callback<LoginEntity> callback) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(pwd);
        userEntity.setStoreId("1");
        String json = new Gson().toJson(userEntity);
        return HttpClient.getInstance().post(URL_LOGIN, json, null, LoginEntity.class, new Callback<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity loginEntity) {
                if (loginEntity.getData() != null)
                    HttpClient.getInstance().Token = loginEntity.getData().getToken();
                callback.onSuccess(loginEntity);
            }

            @Override
            public void onFailed(Throwable throwable) {
                callback.onFailed(throwable);
            }
        });
    }
}
