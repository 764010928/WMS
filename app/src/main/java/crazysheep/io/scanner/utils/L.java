package crazysheep.io.scanner.utils;

/**
 * log工具类
 *
 * Created by yang.li on 2016/12/3.
 */
public class L {

    public static final String TAG = "scanner";

    private static boolean DEBUG = false;

    public static void init(boolean debug) {
        DEBUG = debug;
    }

    public static void i(String msg) {
        if (DEBUG) {
            android.util.Log.i(TAG, msg);
        }
    }

    public static void e(String error) {
        e(error, null);
    }

    public static void e(String error, Throwable throwable) {
        if (DEBUG) {
            android.util.Log.e(TAG, error, throwable);
        }
    }

}
