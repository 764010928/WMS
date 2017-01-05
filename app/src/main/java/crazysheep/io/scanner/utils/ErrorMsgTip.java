package crazysheep.io.scanner.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Entity.ErrorEntity;

/**
 * Created by Bing on 2016/12/13.
 */

public class ErrorMsgTip {
    public static Context context;
    public static List<ErrorEntity> errorList;
    public static final String ERR_NOINTERNET="0";
    public static final String ERR_NOT_FONUNT="1";

    public static void init(Context mContext){
        context=mContext;
        errorList = new ArrayList<>();
        errorList.add(new ErrorEntity(ERR_NOINTERNET, getString(R.string.net_error)));
        errorList.add(new ErrorEntity(ERR_NOT_FONUNT, getString(R.string.goods_not_found)));
    }

    public static void showMsg(String errorCode, String errorMsg) {
        for (int i = 0; i < errorList.size(); i++) {
            if (errorList.get(i).getErrorCode().equals(errorCode)) {
                Toast.makeText(context, errorList.get(i).getErrorMsg(), Toast.LENGTH_LONG).show();
                return;
            }
        }

        Toast.makeText(context, "错误码：" + errorCode + " 错误信息：" + errorMsg, Toast.LENGTH_LONG).show();
    }

    public static void showMsg(String errorCode) {
        for (int i = 0; i < errorList.size(); i++) {
            if (errorList.get(i).getErrorCode().equals(errorCode)) {
                Toast.makeText(context, errorList.get(i).getErrorMsg(), Toast.LENGTH_LONG).show();
                return;
            }
        }
        Toast.makeText(context, "错误码：" + errorCode, Toast.LENGTH_LONG).show();
    }

    public static String getString(@StringRes int id) {
        return context.getString(id);
    }
}
