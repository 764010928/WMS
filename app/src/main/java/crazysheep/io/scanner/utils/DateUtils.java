package crazysheep.io.scanner.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Bing on 2016/12/14.
 */

public class DateUtils {
    public static String DateFomat(Date date) {
        SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormatForMonth.format(date);
    }
}
