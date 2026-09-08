package J6;

import android.content.Intent;
import android.content.OplusBaseIntent;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.inner.content.IntentWrapper;

/* compiled from: IntentNative.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f1598a;

    /* renamed from: b, reason: collision with root package name */
    public static int f1599b;

    /* renamed from: c, reason: collision with root package name */
    public static String f1600c;

    /* renamed from: d, reason: collision with root package name */
    public static int f1601d;

    /* renamed from: e, reason: collision with root package name */
    public static int f1602e;

    static {
        try {
            if (S6.c.n()) {
                f1601d = 1024;
                f1602e = 512;
                f1598a = "android.intent.extra.USER_ID";
                f1599b = OplusPhoneUtils.FLAG_RECEIVER_INCLUDE_BACKGROUND;
                f1600c = OplusPhoneUtils.ACTION_CALL_PRIVILEGED;
                return;
            }
            if (S6.c.m()) {
                f1601d = 1024;
                f1602e = 512;
                Response d10 = com.oplus.epona.d.o(new Request.b().c("android.content.Intent").a()).d();
                if (d10.j()) {
                    f1598a = d10.h().getString("EXTRA_USER_ID");
                    f1599b = d10.h().getInt("FLAG_RECEIVER_INCLUDE_BACKGROUND");
                    f1600c = d10.h().getString("ACTION_CALL_PRIVILEGED");
                    return;
                }
                Log.e("IntentNative", "Epona Communication failed, static initializer failed.");
                return;
            }
            if (S6.c.l()) {
                f1601d = ((Integer) b()).intValue();
                f1602e = ((Integer) c()).intValue();
                f1600c = (String) a();
                f1599b = OplusPhoneUtils.FLAG_RECEIVER_INCLUDE_BACKGROUND;
                return;
            }
            if (S6.c.k()) {
                f1599b = OplusPhoneUtils.FLAG_RECEIVER_INCLUDE_BACKGROUND;
            } else if (S6.c.g()) {
                f1600c = OplusPhoneUtils.ACTION_CALL_PRIVILEGED;
            } else {
                Log.e("IntentNative", "Not supported before N");
                throw new UnSupportedApiVersionException("Not supported before N");
            }
        } catch (Throwable th) {
            Log.e("IntentNative", th.toString());
        }
    }

    public static Object a() {
        return d.a();
    }

    public static Object b() {
        return d.b();
    }

    public static Object c() {
        return d.c();
    }

    public static void d(Intent intent, int i10) {
        if (S6.c.n()) {
            OplusBaseIntent oplusBaseIntent = (OplusBaseIntent) R6.a.a(OplusBaseIntent.class, intent);
            if (oplusBaseIntent != null) {
                oplusBaseIntent.setOplusFlags(i10);
                return;
            }
            return;
        }
        if (S6.c.j()) {
            IntentWrapper.setOplusFlags(intent, i10);
        } else {
            if (S6.c.l()) {
                e(intent, i10);
                return;
            }
            throw new UnSupportedApiVersionException();
        }
    }

    public static void e(Intent intent, int i10) {
        d.d(intent, i10);
    }
}
