package crazysheep.io.scanner;

import android.app.Application;

import crazysheep.io.scanner.net.HttpClient;
import crazysheep.io.scanner.utils.ErrorMsgTip;
import crazysheep.io.scanner.utils.L;

/**
 * application
 *
 * Created by yang.li on 2016/11/27.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        HttpClient.init("http://testing.bydian.com/o2o");
        HttpClient.init("http://120.132.8.55/o2o");
        L.init(BuildConfig.DEBUG);
        ErrorMsgTip.init(this);
    }
}
