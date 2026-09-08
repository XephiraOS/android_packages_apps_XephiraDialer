package X9;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.content.b;
import p.i;

/* compiled from: PermissionUtils.java */
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final i<String, Integer> f5469a;

    static {
        i<String, Integer> iVar = new i<>(13);
        f5469a = iVar;
        iVar.put("com.android.voicemail.permission.ADD_VOICEMAIL", 14);
        iVar.put("android.permission.READ_CALL_LOG", 16);
        iVar.put("android.permission.READ_EXTERNAL_STORAGE", 16);
        iVar.put("android.permission.WRITE_CALL_LOG", 16);
        iVar.put("android.permission.BODY_SENSORS", 20);
        iVar.put("android.permission.SYSTEM_ALERT_WINDOW", 23);
        iVar.put("android.permission.WRITE_SETTINGS", 23);
        iVar.put("android.permission.READ_PHONE_NUMBERS", 26);
        iVar.put("android.permission.ANSWER_PHONE_CALLS", 26);
        iVar.put("android.permission.ACCEPT_HANDOVER", 28);
        iVar.put("android.permission.ACTIVITY_RECOGNITION", 29);
        iVar.put("android.permission.ACCESS_MEDIA_LOCATION", 29);
        iVar.put("android.permission.ACCESS_BACKGROUND_LOCATION", 29);
    }

    public static boolean a(Context context, String str) {
        try {
            if (b.a(context, str) != 0) {
                return false;
            }
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static boolean b(Context context, String... strArr) {
        for (String str : strArr) {
            if (c(str) && !a(context, str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) {
        Integer num = f5469a.get(str);
        if (num != null && Build.VERSION.SDK_INT < num.intValue()) {
            return false;
        }
        return true;
    }

    public static boolean d(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (androidx.core.app.a.t(activity, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(int... iArr) {
        if (iArr.length == 0) {
            return false;
        }
        for (int i10 : iArr) {
            if (i10 != 0) {
                return false;
            }
        }
        return true;
    }
}
