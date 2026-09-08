package com.coui.appcompat.dateutils;

import X8.m;
import android.content.Context;
import android.text.format.DateUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUIDateUtils {
    public static String getYMDWDate(Context context, Date date) {
        if (!isSimplifiedChinese(context)) {
            return DateFormat.getDateInstance(0, Locale.getDefault()).format(date);
        }
        return new SimpleDateFormat(context.getResources().getString(m.f4999I), Locale.getDefault()).format(date);
    }

    public static String getYMDWHMDate(Context context, Date date) {
        if (!isSimplifiedChinese(context)) {
            return DateFormat.getDateTimeInstance(0, 3, Locale.getDefault()).format(date);
        }
        return new SimpleDateFormat(context.getResources().getString(m.f5000J), Locale.getDefault()).format(date);
    }

    public static String getYMDWsHMDate(Context context, Date date) {
        if (!isSimplifiedChinese(context)) {
            return DateUtils.formatDateTime(context, date.getTime(), 32791);
        }
        return new SimpleDateFormat(context.getResources().getString(m.f5001K), Locale.getDefault()).format(date);
    }

    private static boolean isSimplifiedChinese(Context context) {
        String locale = context.getResources().getConfiguration().locale.toString();
        if (locale != null && locale.equalsIgnoreCase("zh_CN")) {
            return true;
        }
        return false;
    }
}
