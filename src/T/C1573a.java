package t;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* compiled from: Debug.java */
/* renamed from: t.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1573a {
    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String b(Context context, int i10) {
        if (i10 != -1) {
            try {
                return context.getResources().getResourceEntryName(i10);
            } catch (Exception unused) {
                return "?" + i10;
            }
        }
        return "UNKNOWN";
    }

    public static String c(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String d(MotionLayout motionLayout, int i10) {
        if (i10 == -1) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(i10);
    }

    public static void e(String str, String str2, int i10) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i10, stackTrace.length - 1);
        String str3 = " ";
        for (int i11 = 1; i11 <= min; i11++) {
            StackTraceElement stackTraceElement = stackTrace[i11];
            str3 = str3 + " ";
            Log.v(str, str2 + str3 + (".(" + stackTrace[i11].getFileName() + ":" + stackTrace[i11].getLineNumber() + ") " + stackTrace[i11].getMethodName()) + str3);
        }
    }
}
