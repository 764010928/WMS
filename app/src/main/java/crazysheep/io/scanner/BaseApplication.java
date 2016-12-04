package crazysheep.io.scanner;

import android.app.Application;

import crazysheep.io.scanner.net.HttpClient;
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

        HttpClient.init("https://api.github.com");
        L.init(BuildConfig.DEBUG);
    }
}
