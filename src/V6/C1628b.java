package v6;

import android.content.Context;
import android.util.Log;
import java.util.Map;
import s8.C1569l;

/* compiled from: CallInterceptUserActionStatistics.java */
/* renamed from: v6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1628b {
    public static void a(Context context, String str, int i10, Map map) {
        if (context == null) {
            return;
        }
        try {
            C1569l.s(context, str, String.valueOf(i10), map);
        } catch (Exception e10) {
            Log.e("CallInterceptUserActionStatistics", "e = " + e10);
        }
    }

    public static void b(Context context, String str, String str2, Map map) {
        if (context == null) {
            return;
        }
        try {
            C1569l.s(context, str, str2, map);
        } catch (Exception e10) {
            Log.e("CallInterceptUserActionStatistics", "e = " + e10);
        }
    }
}
