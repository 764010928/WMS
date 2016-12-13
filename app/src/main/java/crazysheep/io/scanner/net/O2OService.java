package crazysheep.io.scanner.net;

import com.google.gson.Gson;

import crazysheep.io.scanner.net.Entity.GoodsEntity;
import crazysheep.io.scanner.net.Entity.LoginEntity;
import crazysheep.io.scanner.net.Entity.ReqGoodsEntity;
import crazysheep.io.scanner.net.Entity.UserEntity;

/**
 * github的service，测试网络框架
 * <p>
 * Created by yang.li on 2016/12/3.
 */
public class O2OService implements ApiService {

    public static final String URL_LOGIN = "/terminal/login.do";
    public static final String URL_GET_GOODS="/terminal/product/query.do" ;
    Gson gson=new Gson();

    public String Login(String username, String pwd, final Callback<LoginEntity> callback) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(pwd);
        userEntity.setStoreId("1");
        String json = gson.toJson(userEntity);
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
    public String getGoodsList(String code, Callback<GoodsEntity> callback){
        ReqGoodsEntity reqGoodsEntity=new ReqGoodsEntity();
        reqGoodsEntity.setKeyword(code);
        String json=gson.toJson(reqGoodsEntity);
        return HttpClient.getInstance().post(URL_GET_GOODS,json,null,GoodsEntity.class,callback);
    }
}
