package crazysheep.io.scanner.net;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import crazysheep.io.scanner.net.Entity.CheckEntity;
import crazysheep.io.scanner.net.Entity.CheckListEntity;
import crazysheep.io.scanner.net.Entity.GoodsEntity;
import crazysheep.io.scanner.net.Entity.LoginEntity;
import crazysheep.io.scanner.net.Entity.ReqGoodsEntity;
import crazysheep.io.scanner.net.Entity.ReqScanRuKuEntity;
import crazysheep.io.scanner.net.Entity.RuKuDetailEntity;
import crazysheep.io.scanner.net.Entity.RuKuEntity;
import crazysheep.io.scanner.net.Entity.StartCheckEntity;
import crazysheep.io.scanner.net.Entity.UserEntity;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static crazysheep.io.scanner.net.HttpClient.JSON;

/**
 * github的service，测试网络框架
 * <p>
 * Created by yang.li on 2016/12/3.
 */
public class O2OService implements ApiService {

    public static final String URL_LOGIN = "/terminal/login.do";
    public static final String URL_GET_GOODS = "/terminal/product/query";
    public static final String URL_GET_CHECK_LIST = "/terminal/inventoryCheck/query";
    public static final String URL_CHECK="/terminal/inventoryCheck/checkProduct";
    public static final String URL_RUKU_LIST="/terminal/inStock/query";
    public static final String URL_RUKU_DETAIL="/terminal/inStock/detail";
    public static final String URL_SCAN_RUKU="/terminal/inStock/in";
    public static final String URL_CHUKU_LIST="/terminal/outStock/query";
    public static final String URL_CHUKU_DETAIL="/terminal/outStock/detail";
    public static final String URL_SCAN_CHUKU="/terminal/outStock/in";
    Gson gson = new Gson();

    public String Login(String username, String pwd, final Callback<LoginEntity> callback) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(pwd);
        userEntity.setStoreId("1");
        String json = gson.toJson(userEntity);
        return HttpClient.getInstance().post(URL_LOGIN, json, null, LoginEntity.class, new Callback<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity loginEntity) {
                if (loginEntity.getData() != null) {
                    HttpClient.getInstance().Token = loginEntity.getData().getToken();
                }
                callback.onSuccess(loginEntity);
            }

            @Override
            public void onFailed(Throwable throwable) {
                callback.onFailed(throwable);
            }
        });
    }

    public String getGoodsList(String code, Callback<GoodsEntity> callback) {
        ReqGoodsEntity reqGoodsEntity = new ReqGoodsEntity();
        reqGoodsEntity.setKeyword(code);
        String json = gson.toJson(reqGoodsEntity);
        return HttpClient.getInstance().post(URL_GET_GOODS, json, null, GoodsEntity.class, callback);
    }

    public String getCheckList(int page, int pageSize,Callback<CheckListEntity> callback) {
        Map<String,Integer> map=new HashMap<>();
        map.put("page",page);
        map.put("pageSize",pageSize);
        JSONObject json = new JSONObject(map);
        return HttpClient.getInstance().post(URL_GET_CHECK_LIST,json.toString(),null, CheckListEntity.class,callback);
    }
    public String startCheck(int taskId,int operatorId,Callback<StartCheckEntity> callback){
        Map<String,Integer> map=new HashMap<>();
        map.put("taskId",taskId);
        map.put("operatorId",operatorId);
        JSONObject json = new JSONObject(map);
        return HttpClient.getInstance().post(URL_GET_CHECK_LIST,json.toString(),null, StartCheckEntity.class,callback);
    }
    public String CheckGoods(int taskId,String goodId,Callback<CheckEntity> callback){
        Map<String,String> map=new HashMap<>();
        map.put("taskId",taskId+"");
        map.put("productCode",goodId);
        JSONObject json = new JSONObject(map);
        return HttpClient.getInstance().post(URL_CHECK,json.toString(),null, CheckEntity.class,callback);
    }

    public String getRukuList(boolean isRuKu,int page,int pageSize,Callback<RuKuEntity> callback){
        Map<String,Integer> map=new HashMap<>();
        map.put("page",page);
        map.put("pageSize",pageSize);
        JSONObject json = new JSONObject(map);
        String url=isRuKu?URL_RUKU_LIST:URL_CHUKU_LIST;
        return HttpClient.getInstance().post(url,json.toString(),null, RuKuEntity.class,callback);
    }
    public String getRukuDetail(boolean isRuKu,String taskid,String code,Callback<RuKuDetailEntity> callback){
        Map<String,String> map=new HashMap<>();
        map.put("taskId",taskid);
        map.put("code",code);
        JSONObject json = new JSONObject(map);
        String url=isRuKu?URL_RUKU_DETAIL:URL_CHUKU_DETAIL;
        return HttpClient.getInstance().post(url,json.toString(),null, RuKuDetailEntity.class,callback);
    }
    public String scanRuKu(boolean isRuKu,String taskid,String code,String op,String productCode,Callback<RuKuDetailEntity> callback){
        ReqScanRuKuEntity entity=new ReqScanRuKuEntity();
        entity.setTaskId(taskid);
        entity.setCode(code);
        entity.setOperatorId(op);
        entity.setProductCode(productCode);
        String json=gson.toJson(entity);
        String url=isRuKu?URL_SCAN_RUKU:URL_SCAN_CHUKU;
        return HttpClient.getInstance().post(url,json.toString(),null, RuKuDetailEntity.class,callback);
    }

    ////////////测试////////////////
    public void test(){
        Map<String,Integer> map=new HashMap<>();
        map.put("page",1);
        map.put("pageSize",10);
        JSONObject json = new JSONObject(map);
        System.out.println(">json>>"+json.toString());

        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .url("http://testing.bydian.com/o2o/terminal/inventoryCheck/startInventoryCheck")
                .header("TerminalToken",HttpClient.getInstance().Token)
                .post(body)
                .build();
        System.out.println(">>>token:"+HttpClient.getInstance().Token);
        OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("<<<<<<<:"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(">>>>>>:"+response.body().string());
            }
        });
        System.out.println("<><><><><><><><><><><>");
    }

}
